package pl.edu.amu.wmi.students.mario.pjn.reviews

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import pl.edu.amu.wmi.students.mario.pjn.reviews.domain.Review
import pl.edu.amu.wmi.students.mario.pjn.reviews.repository.ReviewRepository

/**
 * Created by Mariusz on 2016-11-27.
 */

@SpringBootApplication
open class Application {

    @Bean
    open fun init(repository: ReviewRepository) = CommandLineRunner {
        repository.saveAndFlush(Review("Some review", 3.5f))
        repository.findAll().forEach(::println)
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}