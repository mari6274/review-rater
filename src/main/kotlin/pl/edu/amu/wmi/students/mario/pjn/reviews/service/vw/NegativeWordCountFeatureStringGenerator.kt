package pl.edu.amu.wmi.students.mario.pjn.reviews.service.vw

import org.springframework.stereotype.Service
import pl.edu.amu.wmi.students.mario.pjn.reviews.domain.Review
import pl.edu.amu.wmi.students.mario.pjn.reviews.service.NegativeWordCounter

/**
 * Created by Mariusz on 2016-11-29.
 */
@Service
class NegativeWordCountFeatureStringGenerator(val negativeWordCounter: NegativeWordCounter) : (Review) -> String {

    val whitespaceDelimiter = Regex("\\s")

    override fun invoke(review: Review): String {
        return "negWordsCount:${negativeWordCounter.count(review.review)} "
    }

}