package com.tia.arcacrawler.batch.domain.entity.config

import ArcaCrawlerTestReader
import com.tia.arcacrawler.batch.domain.entity.ArcaCrawlerTest
import com.tia.arcacrawler.batch.domain.repository.ArcaCrawlerTestRepository
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.ItemWriter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ArcaCrawlerTestReaderJobConfig(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory,

) {

    private final val CUSTOM_READER_JOB = "CUSTOM_READER_JOB"
    private final val CUSTOM_READER_JOB_STEP = CUSTOM_READER_JOB +"_STEP"
    private final val CHUNK_SIZE = 10

    @Autowired
    private val arcaCrawlerTestRepository: ArcaCrawlerTestRepository? = null;

    @Bean
    fun customReaderJob() = jobBuilderFactory.get(CUSTOM_READER_JOB)
        .start(customReaderStep())
        .build()

    @Bean
    fun customReaderStep() = stepBuilderFactory.get(CUSTOM_READER_JOB_STEP)
        .chunk<ArcaCrawlerTest, ArcaCrawlerTest>(CHUNK_SIZE)
        .reader(reader())
        .writer(writer())
        .build()

    @Bean
    @StepScope
    fun reader(): ArcaCrawlerTestReader{
        return ArcaCrawlerTestReader();
    };

    @Bean
    fun processor(): ItemProcessor<ArcaCrawlerTest, ArcaCrawlerTest> {
        return ItemProcessor { item ->
            item
        }
    };

    @Bean
    fun writer(): ItemWriter<ArcaCrawlerTest> {

        return ItemWriter {
            arcaCrawlerTestRepository?.saveAll(it);
        }
    }

}
