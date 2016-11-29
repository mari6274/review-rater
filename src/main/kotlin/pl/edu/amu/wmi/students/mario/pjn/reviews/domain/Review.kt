package pl.edu.amu.wmi.students.mario.pjn.reviews.domain

import javax.persistence.*

/**
 * Created by Mariusz on 2016-11-27.
 */
@Entity
@Table(name = "reviews")
data class Review(
        @Lob var review: String,
        var grade: Short,
        @OneToOne var features: Features? = null,
        var learnData: Boolean = false,
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long = 0
) {
    constructor() : this("", 0)
}