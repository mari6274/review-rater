package pl.edu.amu.wmi.students.mario.pjn.reviews.service

import org.springframework.stereotype.Service

/**
 * Created by Mariusz on 2016-12-13.
 */
@Service
class BigramsFinder {

    fun find(text: String): List<String> {
        //TODO how to do it better?
        val bigrams = mutableListOf<String>()
        val lettersAndDigits = text.filter(Char::isLetterOrDigit)
        for ((index, char) in lettersAndDigits.withIndex()) {
            if (lettersAndDigits.length > index + 1) {
                bigrams.add("$char${lettersAndDigits[index + 1]}")
            }
        }
        return bigrams.toList()
    }

}