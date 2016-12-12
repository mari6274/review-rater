package pl.edu.amu.wmi.students.mario.pjn.reviews.service.vw

import org.springframework.stereotype.Service
import pl.edu.amu.wmi.students.mario.pjn.reviews.domain.Review

/**
 * Created by Mariusz on 2016-11-29.
 */
@Service
class FullFeatureStringGenerator(val lenFeatureStringGenerator: LenFeatureStringGenerator,
                                 val topWordFeatureStringGenerator: TopWordFeatureStringGenerator,
                                 val positiveWordCountFeatureStringGenerator: PositiveWordCountFeatureStringGenerator,
                                 val negativeWordCountFeatureStringGenerator: NegativeWordCountFeatureStringGenerator) : (Review) -> String {

    override fun invoke(review: Review): String =
            lenFeatureStringGenerator.invoke(review) +
            topWordFeatureStringGenerator.invoke(review) +
            positiveWordCountFeatureStringGenerator.invoke(review) +
            negativeWordCountFeatureStringGenerator.invoke(review)
}