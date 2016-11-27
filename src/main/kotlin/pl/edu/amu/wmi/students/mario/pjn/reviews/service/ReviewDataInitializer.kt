package pl.edu.amu.wmi.students.mario.pjn.reviews.service

import org.springframework.stereotype.Service
import pl.edu.amu.wmi.students.mario.pjn.reviews.domain.Review
import pl.edu.amu.wmi.students.mario.pjn.reviews.repository.ReviewRepository
import java.util.function.Consumer

/**
 * Created by Mariusz on 2016-11-27.
 */
@Service
class ReviewDataInitializer(val reviewDownloader: ReviewDownloader, val reviewRepository: ReviewRepository) {
    fun init() {
        reviewDownloader.download(1000, Consumer {
            println(it.reviewText?.substring(0, 80))
            reviewRepository.save(Review(it.reviewText ?: "", it.overallRating?.rating ?: 0))
        })
    }
}