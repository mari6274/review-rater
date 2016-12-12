package pl.edu.amu.wmi.students.mario.pjn.reviews.service

import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers
import org.springframework.stereotype.Service
import pl.edu.amu.wmi.students.mario.pjn.reviews.domain.PositiveWord
import pl.edu.amu.wmi.students.mario.pjn.reviews.repository.PositiveWordRepository
import java.io.File


/**
 * Created by Mariusz on 2016-12-12.
 */
@Service
class PositiveWordsInitializer(val positiveWordRepository: PositiveWordRepository) {

    val WORD_MATCHER = ExampleMatcher.matching()
            .withMatcher("word", GenericPropertyMatchers.exact())
            .withIgnorePaths("id")

    fun initialize() {

        val positiveWords = File(javaClass.getResource("positive_words.txt").file)
                .readLines()
                .map { PositiveWord(it) }
                .filter { !positiveWordRepository.exists(Example.of(it, WORD_MATCHER)) }
        positiveWordRepository.save(positiveWords)
    }
}