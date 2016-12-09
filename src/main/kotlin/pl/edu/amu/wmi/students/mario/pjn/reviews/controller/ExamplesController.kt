package pl.edu.amu.wmi.students.mario.pjn.reviews.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import pl.edu.amu.wmi.students.mario.pjn.reviews.repository.ReviewRepository
import pl.edu.amu.wmi.students.mario.pjn.reviews.service.vw.FeaturesStringGeneratorFactory
import pl.edu.amu.wmi.students.mario.pjn.reviews.service.writer.StringExamplesWriter

/**
 * Created by Mariusz on 2016-12-06.
 */
@RestController("/examples")
class ExamplesController(val reviewRepository: ReviewRepository,
                         val stringExamplesWriter: StringExamplesWriter,
                         val featuresStringGeneratorFactory: FeaturesStringGeneratorFactory) {

    @CrossOrigin(origins = arrayOf("*"))
    @GetMapping(produces = arrayOf(MediaType.TEXT_PLAIN_VALUE))
    fun getExamples(@RequestParam learn: Boolean, @RequestParam features: String): String {
        val featuresStringGenerator = featuresStringGeneratorFactory.get(features)
        return stringExamplesWriter.write(reviewRepository.findByLearnData(learn), featuresStringGenerator)
    }

}
