package pl.edu.amu.wmi.students.mario.pjn.reviews.service

import org.springframework.stereotype.Service
import java.util.*

/**
 * Created by Mariusz on 2016-11-28.
 */
@Service
class TopWordFinder {

    val whitespaceDelimiter = Regex("\\s")

    fun find(text : String) : String? {
        val words = text.split(whitespaceDelimiter)
        return words.maxBy { Collections.frequency(words, it) }
    }
}