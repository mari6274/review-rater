package pl.edu.amu.wmi.students.mario.pjn.reviews.config

import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * Created by Mariusz on 2016-11-28.
 */
@ConfigurationProperties(prefix = "walmart")
class WalmartProperties(val api_key : String)