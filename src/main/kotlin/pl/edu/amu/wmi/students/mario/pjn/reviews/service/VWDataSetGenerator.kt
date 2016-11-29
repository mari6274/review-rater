package pl.edu.amu.wmi.students.mario.pjn.reviews.service

import org.springframework.stereotype.Service
import pl.edu.amu.wmi.students.mario.pjn.reviews.repository.ReviewRepository
import java.io.File

/**
 * Created by Mariusz on 2016-11-28.
 */
@Service
class VWDataSetGenerator(val reviewRepository: ReviewRepository) {
    fun generate(learnData: Boolean = false) {

        File("dataset${postfix(learnData)}.txt").printWriter().use { out ->
            reviewRepository.findByLearnData(learnData).forEach {
                val len = "len:${it.review.length} "
                val topWord = if(!it.features?.topWord.isNullOrEmpty()) "topWord:${it.features?.topWord} " else ""
                out.println("${it.grade} | $len$topWord".trim())
            }
        }
    }

    fun postfix(learnData: Boolean) = if(learnData) "-learnData" else ""


    fun generateToLearn() {
        generate(true)
    }
}