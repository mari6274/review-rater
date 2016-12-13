package pl.edu.amu.wmi.students.mario.pjn.reviews.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import pl.edu.amu.wmi.students.mario.pjn.reviews.domain.Review
import pl.edu.amu.wmi.students.mario.pjn.reviews.repository.ReviewRepository

/**
 * Created by Mariusz on 2016-12-12.
 */
@RestController
class ReviewsController(val reviewRepository: ReviewRepository) {

    @CrossOrigin(origins = arrayOf("*"))
    @GetMapping(value = "/reviews/{id}", produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun getReview(@PathVariable id: Long): Review {
        return reviewRepository.getOne(id)
    }
}