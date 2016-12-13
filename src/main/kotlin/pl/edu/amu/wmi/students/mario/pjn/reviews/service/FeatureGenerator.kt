package pl.edu.amu.wmi.students.mario.pjn.reviews.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import pl.edu.amu.wmi.students.mario.pjn.reviews.domain.Features
import pl.edu.amu.wmi.students.mario.pjn.reviews.repository.FeaturesRepository
import pl.edu.amu.wmi.students.mario.pjn.reviews.repository.ReviewRepository

/**
 * Created by Mariusz on 2016-11-28.
 */
@Service
class FeatureGenerator(
        val reviewRepository: ReviewRepository,
        val featuresRepository: FeaturesRepository,
        val topWordFinder: TopWordFinder,
        val bigramsFinder: BigramsFinder) {

    val LOGGER : Logger = LoggerFactory.getLogger(FeatureGenerator::class.java)

    fun generate() {
        reviewRepository.findAll().forEach {
            val features = Features(
                    topWord = topWordFinder.find(it.review) ?: "",
                    bigrams = bigramsFinder.find(it.review))
            it.features = features
            featuresRepository.save(features)
            reviewRepository.save(it)
            LOGGER.info("Saved features for review id: {}", it.id)
        }
    }
}