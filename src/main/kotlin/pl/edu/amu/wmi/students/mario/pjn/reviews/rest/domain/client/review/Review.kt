package pl.edu.amu.wmi.students.mario.pjn.reviews.rest.domain.client.review

/**
 * Created by Mariusz on 2016-11-27.
 */
class Review {
    var downVotes: String? = null

    var upVotes: String? = null

    var title: String? = null

    var reviewText: String? = null

    var name: String? = null

    var submissionTime: String? = null

    var reviewer: String? = null

    var productAttributes: Array<ProductAttributes>? = null

    var overallRating: OverallRating? = null
}