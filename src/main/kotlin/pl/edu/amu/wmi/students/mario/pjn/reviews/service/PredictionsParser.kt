package pl.edu.amu.wmi.students.mario.pjn.reviews.service

import org.springframework.stereotype.Service

/**
 * Created by Mariusz on 2016-12-05.
 */
@Service
class PredictionsParser {
    fun parse(predictions: String): Map<Long, Double> {
        return predictions.split('\n', '\r')
                .map { it.split(' ') }
                .map { it[1].toLong() to it[0].toDouble() }
                .toMap()
    }
}