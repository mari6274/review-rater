package pl.edu.amu.wmi.students.mario.pjn.reviews.service.vw

import org.springframework.stereotype.Service
import pl.edu.amu.wmi.students.mario.pjn.reviews.domain.Review

/**
 * Created by Mariusz on 2016-12-13.
 */
@Service
class BigramsFeatureStringGenerator : (Review) -> String {
    override fun invoke(review: Review): String {
        return review.features?.bigrams?.joinToString(separator = " ", postfix = " ", transform = { "bigram" + it }) ?: ""
    }
}