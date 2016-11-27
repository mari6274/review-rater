package pl.edu.amu.wmi.students.mario.pjn.reviews

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import pl.edu.amu.wmi.students.mario.pjn.reviews.service.ReviewDataInitializer

/**
 * Created by Mariusz on 2016-11-27.
 */

@SpringBootApplication
open class Application {

    @Bean
    open fun init(reviewDataInitializer: ReviewDataInitializer) = CommandLineRunner {
        val args = it
        when (args[1]) {
            "init" -> reviewDataInitializer.init()
        }
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}