package pl.edu.amu.wmi.students.mario.pjn.reviews.repository

import org.springframework.data.jpa.repository.JpaRepository
import pl.edu.amu.wmi.students.mario.pjn.reviews.domain.Review

/**
 * Created by Mariusz on 2016-11-27.
 */
interface ReviewRepository : JpaRepository<Review, Long>