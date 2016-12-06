package pl.edu.amu.wmi.students.mario.pjn.reviews.service.writer

import org.springframework.stereotype.Service
import pl.edu.amu.wmi.students.mario.pjn.reviews.domain.Review
import pl.edu.amu.wmi.students.mario.pjn.reviews.service.vw.ExampleStringGenerator

/**
 * Created by Mariusz on 2016-12-06.
 */
@Service
class StringExamplesWriter(val exampleStringGenerator: ExampleStringGenerator) {
    fun write(reviews : List<Review>) : String {
        return reviews.map { exampleStringGenerator.generate(it) }.joinToString("\n")
    }
}