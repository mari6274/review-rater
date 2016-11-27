package pl.edu.amu.wmi.students.mario.pjn.reviews.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

/**
 * Created by Mariusz on 2016-11-27.
 */
@Configuration
open class ApplicationConfiguration {
    @Bean
    open fun restTemplate() : RestTemplate {
        return RestTemplate()
    }
}