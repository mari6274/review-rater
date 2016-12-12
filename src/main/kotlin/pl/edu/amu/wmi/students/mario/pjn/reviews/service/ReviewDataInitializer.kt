package pl.edu.amu.wmi.students.mario.pjn.reviews.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import pl.edu.amu.wmi.students.mario.pjn.reviews.domain.Review
import pl.edu.amu.wmi.students.mario.pjn.reviews.repository.ReviewRepository
import java.util.function.Consumer

/**
 * Created by Mariusz on 2016-11-27.
 */
@Service
class ReviewDataInitializer(val reviewDownloader: ReviewDownloader, val reviewRepository: ReviewRepository) {

    val LOGGER : Logger = LoggerFactory.getLogger(ReviewDataInitializer::class.java)

    fun init() {
        reviewDownloader.download(70, Consumer {
            reviewRepository.save(Review(it.reviewText ?: "", it.overallRating?.rating ?: 0))
            LOGGER.info("Saved review: {}", it.reviewText?.safeBeginning(80))
        })
    }
}

private fun String.safeBeginning(maxEndIndex: Int): String? {
    return substring(0, if (length < maxEndIndex)  length else maxEndIndex)
}
