package pl.edu.amu.wmi.students.mario.pjn.reviews.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import pl.edu.amu.wmi.students.mario.pjn.reviews.rest.domain.review.Product
import pl.edu.amu.wmi.students.mario.pjn.reviews.rest.domain.review.Review
import java.util.function.Consumer

/**
 * Created by Mariusz on 2016-11-27.
 */
@Service
class ReviewDownloader(val restTemplate: RestTemplate, val productCatalog: ProductCatalog, @Value("\${walmart.api_key}") val apiKey: String) {

    val URI: String = "http://api.walmartlabs.com/v1/reviews/{productId}?apiKey=$apiKey&format=json"

    fun download(productPagesAmount: Int, onNext: Consumer<Review>) {
        productCatalog.download(productPagesAmount, Consumer {
            it.forEach {
                val product = restTemplate.getForObject(URI, Product::class.java, it)
                product.reviews?.forEach { onNext.accept(it) }
            }
        })
    }
}