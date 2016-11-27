package pl.edu.amu.wmi.students.mario.pjn.reviews

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import pl.edu.amu.wmi.students.mario.pjn.reviews.repository.ReviewRepository
import pl.edu.amu.wmi.students.mario.pjn.reviews.service.ReviewDataInitializer

/**
 * Created by Mariusz on 2016-11-27.
 */

@SpringBootApplication
open class Application {

    @Bean
    open fun init(reviewDataInitializer: ReviewDataInitializer, reviewRepository: ReviewRepository) = CommandLineRunner {
        val args = it
        if (args.isNotEmpty()) {
            when (args[0]) {
                "init" -> reviewDataInitializer.init()
                "listAll" -> reviewRepository.findAll().forEach(::println)
            }
        } else {
            println("Usage:")
            println("   ./appName init")
            println("   ./appName listAll")
        }
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}