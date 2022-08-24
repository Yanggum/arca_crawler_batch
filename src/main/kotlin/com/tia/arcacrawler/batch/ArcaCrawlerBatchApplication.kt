package com.tia.arcacrawler.batch

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableBatchProcessing
class ArcaCrawlerBatchApplication

fun main(args: Array<String>) {
    runApplication<ArcaCrawlerBatchApplication>(*args)
}
