package pl.edu.amu.wmi.students.mario.pjn.reviews.service

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import pl.edu.amu.wmi.students.mario.pjn.reviews.rest.domain.Review
import java.util.function.Consumer

/**
 * Created by Mariusz on 2016-11-27.
 */
@Service
class ReviewDownloader(val restTemplate : RestTemplate) {

    val URI : String = "http://api.walmartlabs.com/v1/reviews/"

    fun download(reviewsAmount: Int, onNext: Consumer<Review>) {
        throw NotImplementedError("Downloading reviews not implemented yet!!!")
    }
}