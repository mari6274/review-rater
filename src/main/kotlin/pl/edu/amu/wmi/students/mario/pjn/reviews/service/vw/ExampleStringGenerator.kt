package pl.edu.amu.wmi.students.mario.pjn.reviews.service.vw

import org.springframework.stereotype.Service
import pl.edu.amu.wmi.students.mario.pjn.reviews.domain.Review

/**
 * Created by Mariusz on 2016-11-29.
 */
@Service
class ExampleStringGenerator(val featureStringGenerator: FullFeatureStringGenerator) {
    fun generate(review: Review) = "${review.grade} '${review.id} | ${featureStringGenerator.generate(review)}".trim()
}