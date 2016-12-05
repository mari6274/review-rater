package pl.edu.amu.wmi.students.mario.pjn.reviews.service

import org.springframework.stereotype.Service
import pl.edu.amu.wmi.students.mario.pjn.reviews.domain.Word
import pl.edu.amu.wmi.students.mario.pjn.reviews.repository.WordRepository

/**
 * Created by Mariusz on 2016-11-29.
 */
@Service
class WordNumerator(val wordRepository: WordRepository) {
    fun getNumber(word: String): Long {
        return wordRepository.findByWord(word)?.id ?: wordRepository.save(Word(word)).id
    }
}