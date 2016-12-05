package pl.edu.amu.wmi.students.mario.pjn.reviews.service.math

import org.springframework.stereotype.Service

/**
 * Created by Mariusz on 2016-12-05.
 */
@Service
class Calculator {
    fun rms(values: List<Double>): Double {
        val sum = values.map { it * it }.sum()
        val divided = sum / values.size
        return Math.sqrt(divided)
    }
}