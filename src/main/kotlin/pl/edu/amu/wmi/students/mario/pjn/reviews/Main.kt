package pl.edu.amu.wmi.students.mario.pjn.reviews

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import pl.edu.amu.wmi.students.mario.pjn.reviews.repository.ReviewRepository
import pl.edu.amu.wmi.students.mario.pjn.reviews.service.FeatureGenerator
import pl.edu.amu.wmi.students.mario.pjn.reviews.service.ReviewDataInitializer
import pl.edu.amu.wmi.students.mario.pjn.reviews.service.vw.FullFeatureStringGenerator
import pl.edu.amu.wmi.students.mario.pjn.reviews.service.vw.VWDataSetGenerator

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
            vwDataSetGenerator: VWDataSetGenerator,
            fullFeatureStringGenerator: FullFeatureStringGenerator
    ) = CommandLineRunner {
        val args = it
        if (args.isNotEmpty()) {
            when (args[0]) {
                "downloadReviews" -> reviewDataInitializer.init()
                "generateFeatures" -> featureGenerator.generate()
                "generateVWLearnDataSet" -> vwDataSetGenerator.generateToLearn{fullFeatureStringGenerator.generate(it)}
                "generateVWDataSet" -> vwDataSetGenerator.generate({fullFeatureStringGenerator.generate(it)})
                "listAll" -> reviewRepository.findAll().forEach(::println)
            }
        } else {
            println("Usage:")
            println("   ./appName downloadReviews")
            println("   ./appName generateFeatures")
            println("   ./appName generateVWLearnDataSet")
            println("   ./appName generateVWDataSet")
            println("   ./appName listAll")
        }
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}