package pl.edu.amu.wmi.students.mario.pjn.reviews.domain

import javax.persistence.*

/**
 * Created by Mariusz on 2016-11-28.
 */
@Entity
@Table(name = "features")
data class Features(
        var topWord : String,
        @OneToOne var review : Review? = null,
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id : Long = 0
) {
    constructor() : this("")

    fun length(): Int? = review?.review?.length
}