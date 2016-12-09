package pl.edu.amu.wmi.students.mario.pjn.reviews.service

import org.springframework.stereotype.Service
import pl.edu.amu.wmi.students.mario.pjn.reviews.repository.ReviewRepository
import pl.edu.amu.wmi.students.mario.pjn.reviews.rest.domain.server.PredictionExampleDiff
import pl.edu.amu.wmi.students.mario.pjn.reviews.rest.domain.server.PredictionsDiff
import pl.edu.amu.wmi.students.mario.pjn.reviews.service.math.Calculator
import pl.edu.amu.wmi.students.mario.pjn.reviews.service.vw.PredictionsParser

/**
 * Created by Mariusz on 2016-12-05.
 */
@Service
class PredictionsDiffBuilder(val predictionsParser: PredictionsParser, val reviewRepository: ReviewRepository, val calculator: Calculator) {
    fun build(predictions: String): PredictionsDiff {
        val examples = predictionsParser.parse(predictions)
                .map { PredictionExampleDiff(it.key, reviewRepository.findOne(it.key).grade, it.value) }
        val gradeDiffs = examples.map { Math.abs(it.predictedGrade - it.grade) }
        return PredictionsDiff(examples, calculator.rms(gradeDiffs))
    }
}