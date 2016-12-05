package pl.edu.amu.wmi.students.mario.pjn.reviews.service.vw

import org.springframework.stereotype.Service
import pl.edu.amu.wmi.students.mario.pjn.reviews.domain.Review
import pl.edu.amu.wmi.students.mario.pjn.reviews.service.WordNumerator

/**
 * Created by Mariusz on 2016-11-29.
 */
@Service
class TopWordStringGenerator(val wordNumerator: WordNumerator) {
    fun generate(review: Review) = if (!review.features?.topWord.isNullOrEmpty()) "topWord:${wordNumerator.getNumber(review.features?.topWord!!)} " else ""
}