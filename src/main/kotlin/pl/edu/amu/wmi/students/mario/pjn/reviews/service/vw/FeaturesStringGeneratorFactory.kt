package pl.edu.amu.wmi.students.mario.pjn.reviews.service.vw

import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service
import pl.edu.amu.wmi.students.mario.pjn.reviews.domain.Review

/**
 * Created by Mariusz on 2016-12-09.
 */
@Service
class FeaturesStringGeneratorFactory(val applicationContext: ApplicationContext) {

    val featuresMap = mapOf(
            Pair("len", LenFeatureStringGenerator::class.java),
            Pair("topWord", TopWordFeatureStringGenerator::class.java),
            Pair("posWordsCount", PositiveWordCountFeatureStringGenerator::class.java),
            Pair("negWordsCount", NegativeWordCountFeatureStringGenerator::class.java))

    fun get(featuresParam: String): (Review) -> String {

        val featureStringGenerators = featuresParam
                .split(",")
                .map { featuresMap[it] }
                .filterNotNull()
                .map { applicationContext.getBean(it)}

        return {
            val review = it
            featureStringGenerators
                    .map { it.invoke(review) }
                    .fold(StringBuilder(), StringBuilder::append).toString()
        }
    }
}