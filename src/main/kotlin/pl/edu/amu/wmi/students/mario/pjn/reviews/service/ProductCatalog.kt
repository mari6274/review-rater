package pl.edu.amu.wmi.students.mario.pjn.reviews.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import pl.edu.amu.wmi.students.mario.pjn.reviews.rest.domain.client.catalog.CatalogPage
import java.util.function.Consumer

/**
 * Created by Mariusz on 2016-11-27.
 */
@Service
class ProductCatalog(val restTemplate: RestTemplate, @Value("\${walmart.api_key}") val apiKey: String) {

    val ELECTRINIC_CATEGORY_ID: Int = 3944
    val HOSTNAME = "http://api.walmartlabs.com"
    val REQUEST_URI: String = "/v1/paginated/items?category=$ELECTRINIC_CATEGORY_ID&apiKey=$apiKey&format=json"

    fun download(pagesAmount: Int, onNext: Consumer<List<String?>>) {
        var counter = 0
        var isNext = true
        var uri = HOSTNAME + REQUEST_URI
        while (counter++ < pagesAmount && isNext) {
            val catalogPage: CatalogPage = restTemplate.getForObject(uri, CatalogPage::class.java)
            val ids = catalogPage.items?.map { it.itemId }
            onNext.accept(ids)
            isNext = catalogPage.nextPage != null
            uri = HOSTNAME + catalogPage.nextPage
        }
    }

}