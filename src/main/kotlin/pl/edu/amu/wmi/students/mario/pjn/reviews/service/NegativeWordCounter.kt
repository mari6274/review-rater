package pl.edu.amu.wmi.students.mario.pjn.reviews.service

import org.springframework.stereotype.Service
import pl.edu.amu.wmi.students.mario.pjn.reviews.repository.NegativeWordRepository

/**
 * Created by Mariusz on 2016-12-12.
 */
@Service
class NegativeWordCounter(val negativeWordRepository: NegativeWordRepository) {

    val whitespaceDelimiter = Regex("\\s")

    fun count(text: String): Int {
        val words = text.split(whitespaceDelimiter)
        val negativeWords = negativeWordRepository.findAll().map { it.word }
        return words.filter { negativeWords.contains(it) }.size
    }
}