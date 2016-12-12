package pl.edu.amu.wmi.students.mario.pjn.reviews

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import pl.edu.amu.wmi.students.mario.pjn.reviews.repository.NegativeWordRepository
import pl.edu.amu.wmi.students.mario.pjn.reviews.repository.PositiveWordRepository
import pl.edu.amu.wmi.students.mario.pjn.reviews.repository.ReviewRepository
import pl.edu.amu.wmi.students.mario.pjn.reviews.service.FeatureGenerator
import pl.edu.amu.wmi.students.mario.pjn.reviews.service.NegativeWordsInitializer
import pl.edu.amu.wmi.students.mario.pjn.reviews.service.PositiveWordsInitializer
import pl.edu.amu.wmi.students.mario.pjn.reviews.service.ReviewDataInitializer
import pl.edu.amu.wmi.students.mario.pjn.reviews.service.vw.FullFeatureStringGenerator
import pl.edu.amu.wmi.students.mario.pjn.reviews.service.writer.FileExamplesWriter

/**
 * Created by Mariusz on 2016-11-27.
 */

@SpringBootApplication
open class Application {

    @Bean
    open fun init(
            reviewDataInitializer: ReviewDataInitializer,
            reviewRepository: ReviewRepository,
            featureGenerator: FeatureGenerator,
            fullFeatureStringGenerator: FullFeatureStringGenerator,
            fileExamplesWriter: FileExamplesWriter,
            positiveWordsInitializer: PositiveWordsInitializer,
            negativeWordsInitializer: NegativeWordsInitializer
    ) = CommandLineRunner {
        positiveWordsInitializer.initialize()
        negativeWordsInitializer.initialize()
        val args = it
        if (args.isNotEmpty()) {
            when (args[0]) {
                "downloadReviews" -> reviewDataInitializer.init()
                "generateFeatures" -> featureGenerator.generate()
                "generateVWLearnDataSet" -> fileExamplesWriter.writeToFile("data_set_learn.txt", reviewRepository.findByLearnData(true))
                "generateVWDataSet" -> fileExamplesWriter.writeToFile("data_set.txt", reviewRepository.findByLearnData(false))
                "listAll" -> reviewRepository.findAll().forEach(::println)
            }
        } else {
            println("Usage:")
            println("   ./appName downloadReviews --walmart.api_key=[api_key]")
            println("   ./appName generateFeatures")
            println("   ./appName generateVWLearnDataSet")
            println("   ./appName generateVWDataSet")
            println("   ./appName listAll")
            println("   ./appName --spring.main.web-environment=true")
        }
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}