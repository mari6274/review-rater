package pl.edu.amu.wmi.students.mario.pjn.reviews.domain

import javax.persistence.*

/**
 * Created by Mariusz on 2016-11-28.
 */
@Entity
@Table(name = "positive_words")
data class PositiveWord(
        @Column(unique = true) var word : String,
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id : Long = 0
) {
    constructor() : this("")
}