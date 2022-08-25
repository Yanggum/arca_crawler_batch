package com.tia.arcacrawler.batch.domain.entity.config

import CustomItemReader
import com.tia.arcacrawler.batch.domain.entity.ArcaCralwerTest
import com.tia.arcacrawler.batch.domain.repository.ArcaCralwerTestRepository
import lombok.RequiredArgsConstructor
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.ItemWriter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CustomReaderJobConfig(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory,
    private val arcaCralwerTestRepository: ArcaCralwerTestRepository

) {

    private final val CUSTOM_READER_JOB = "CUSTOM_READER_JOB"
    private final val CUSTOM_READER_JOB_STEP = CUSTOM_READER_JOB +"_STEP"
    private final val CHUNK_SIZE = 10

    @Bean
    fun customReaderJob() = jobBuilderFactory.get(CUSTOM_READER_JOB)
        .start(customReaderStep())
        .build()

    @Bean
    fun customReaderStep() = stepBuilderFactory.get(CUSTOM_READER_JOB_STEP)
        .chunk<ArcaCralwerTest, ArcaCralwerTest>(CHUNK_SIZE)
        .reader(reader())
        .writer(writer())
        .build()

    @Bean
    @StepScope
    fun reader(): CustomItemReader{
        return CustomItemReader();
    };

    @Bean
    fun processor(): ItemProcessor<ArcaCralwerTest, ArcaCralwerTest> {
        return ItemProcessor { item ->
            item
        }
    };

    @Bean
    fun writer(): ItemWriter<ArcaCralwerTest> {

        return ItemWriter {
            arcaCralwerTestRepository.saveAll(it);
        }
    }

}
