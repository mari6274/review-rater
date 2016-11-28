package pl.edu.amu.wmi.students.mario.pjn.reviews.service

import org.springframework.stereotype.Service
import pl.edu.amu.wmi.students.mario.pjn.reviews.repository.FeaturesRepository
import java.io.File

/**
 * Created by Mariusz on 2016-11-28.
 */
@Service
class VWDataSetGenerator(val featuresRepository: FeaturesRepository) {
    fun generate() {
        File("dataset.txt").printWriter().use { out ->
            featuresRepository.findAll().forEach {
                out.println("${it.review.grade} | len:${it.length()} topWord:${it.topWord}")
            }
        }
    }
}