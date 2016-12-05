package pl.edu.amu.wmi.students.mario.pjn.reviews.repository

import org.springframework.data.jpa.repository.JpaRepository
import pl.edu.amu.wmi.students.mario.pjn.reviews.domain.Word

/**
 * Created by Mariusz on 2016-11-27.
 */
interface WordRepository : JpaRepository<Word, Long> {
    fun findByWord(word: String) : Word?
}