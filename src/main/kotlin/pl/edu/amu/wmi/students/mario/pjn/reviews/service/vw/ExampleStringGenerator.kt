package pl.edu.amu.wmi.students.mario.pjn.reviews.service.vw

import org.springframework.stereotype.Service
import pl.edu.amu.wmi.students.mario.pjn.reviews.domain.Review

/**
 * Created by Mariusz on 2016-11-29.
 */
@Service
class ExampleStringGenerator() {
    fun generate(review: Review, featuresStringGenerator : (Review) -> String) = "${review.grade} '${review.id} | ${featuresStringGenerator.invoke(review)}".trim()
}