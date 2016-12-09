package pl.edu.amu.wmi.students.mario.pjn.reviews.service.vw

import org.springframework.stereotype.Service
import pl.edu.amu.wmi.students.mario.pjn.reviews.domain.Review
import pl.edu.amu.wmi.students.mario.pjn.reviews.service.WordNumerator

/**
 * Created by Mariusz on 2016-11-29.
 */
@Service
class TopWordFeatureStringGenerator(val wordNumerator: WordNumerator) : (Review) -> String {
    override fun invoke(review: Review): String = if (!review.features?.topWord.isNullOrEmpty()) "topWord:${wordNumerator.getNumber(review.features?.topWord!!)} " else ""

}