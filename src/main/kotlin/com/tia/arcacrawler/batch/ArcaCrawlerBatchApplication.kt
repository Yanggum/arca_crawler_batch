package com.tia.arcacrawler.batch

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.jsoup.Jsoup
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.ComponentScans
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.scheduling.annotation.EnableScheduling
@SpringBootApplication(exclude = [R2dbcAutoConfiguration::class])
@EnableBatchProcessing
@EnableScheduling
@EnableJpaRepositories("com.tia.arcacrawler.batch.domain.repository")
class ArcaCrawlerBatchApplication

//private val test = Jsoup.connect("https://arca.live").get()

fun main(args: Array<String>) {
//    val regex = Regex("[0-9][0-9]-[0-9][0-9] [0-9][0-9]:[0-9][0-9]:[0-9][0-9] q ");
//    val regex2 = Regex(" \\[[0-9]+\\]$");
//    val test2 = test.body().getElementsByAttributeValueContaining("href", "/b/live")
//        .get(2)
//        .text()
//        .replace(regex, "")
//        .replace(regex2, "");
//
//
//    print(test2);


    runApplication<ArcaCrawlerBatchApplication>(*args)

}
