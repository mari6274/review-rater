package pl.edu.amu.wmi.students.mario.pjn.reviews.service.vw

import org.springframework.stereotype.Service
import pl.edu.amu.wmi.students.mario.pjn.reviews.domain.Review

/**
 * Created by Mariusz on 2016-11-29.
 */
@Service
class LenFeatureStringGenerator : (Review) -> String {
    override fun invoke(review: Review): String = "len:${review.review.length} "
}