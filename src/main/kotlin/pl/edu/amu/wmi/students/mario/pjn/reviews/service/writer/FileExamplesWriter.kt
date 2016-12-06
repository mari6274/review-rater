package pl.edu.amu.wmi.students.mario.pjn.reviews.service.writer

import org.springframework.stereotype.Service
import pl.edu.amu.wmi.students.mario.pjn.reviews.domain.Review
import pl.edu.amu.wmi.students.mario.pjn.reviews.service.vw.ExampleStringGenerator
import java.io.File

/**
 * Created by Mariusz on 2016-12-06.
 */
@Service
class FileExamplesWriter(val exampleStringGenerator: ExampleStringGenerator) {
    fun writeToFile(fileName : String, reviews: List<Review>) {
        File(fileName).printWriter().use { out ->
            reviews.forEach {
                out.println(exampleStringGenerator.generate(it).trim())
            }
        }
    }
}