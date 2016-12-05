package pl.edu.amu.wmi.students.mario.pjn.reviews.service.vw

import org.springframework.stereotype.Service
import pl.edu.amu.wmi.students.mario.pjn.reviews.domain.Review

/**
 * Created by Mariusz on 2016-11-29.
 */
@Service
class FullFeatureStringGenerator(val lenFeatureStringGenerator: LenFeatureStringGenerator,
                                 val topWordStringGenerator: TopWordStringGenerator) {
    fun generate(review : Review) = "${lenFeatureStringGenerator.generate(review)}${topWordStringGenerator.generate(review)}"
}