package pl.edu.amu.wmi.students.mario.pjn.reviews.service.writer

import org.springframework.stereotype.Service
import pl.edu.amu.wmi.students.mario.pjn.reviews.domain.Review
import pl.edu.amu.wmi.students.mario.pjn.reviews.service.vw.ExampleStringGenerator
import pl.edu.amu.wmi.students.mario.pjn.reviews.service.vw.FullFeatureStringGenerator
import java.io.File

/**
 * Created by Mariusz on 2016-12-06.
 */
@Service
class FileExamplesWriter(val exampleStringGenerator: ExampleStringGenerator,
                         val fullFeatureStringGenerator: FullFeatureStringGenerator) {
    fun writeToFile(fileName : String, reviews: List<Review>) {
        File(fileName).printWriter().use { out ->
            reviews.forEach {
                out.println(exampleStringGenerator.generate(it, fullFeatureStringGenerator).trim())
            }
        }
    }
}