package pl.edu.amu.wmi.students.mario.pjn.reviews.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import pl.edu.amu.wmi.students.mario.pjn.reviews.rest.domain.server.PredictionsDiff
import pl.edu.amu.wmi.students.mario.pjn.reviews.service.PredictionsDiffBuilder

/**
 * Created by Mariusz on 2016-12-05.
 */
@RestController("/predictions")
class DiffController(val predictionsDiffBuilder: PredictionsDiffBuilder) {

    @PostMapping(consumes = arrayOf(MediaType.TEXT_PLAIN_VALUE), produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun postPredictions(@RequestBody predictions: String): PredictionsDiff = predictionsDiffBuilder.build(predictions)

}