package pl.edu.amu.wmi.students.mario.pjn.reviews.domain

import javax.persistence.*

/**
 * Created by Mariusz on 2016-11-28.
 */
@Entity
@Table(name = "features")
data class Features(
        var topWord: String = "",
        @ElementCollection
        @CollectionTable(name = "bigrams")
        var bigrams: List<String> = listOf(),
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long = 0
)