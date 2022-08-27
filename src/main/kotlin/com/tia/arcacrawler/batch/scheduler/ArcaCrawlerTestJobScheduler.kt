package com.tia.arcacrawler.batch.scheduler

import com.tia.arcacrawler.batch.domain.entity.config.ArcaCrawlerTestReaderJobConfig
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.springframework.batch.core.JobParameter
import org.springframework.batch.core.JobParameters
import org.springframework.batch.core.JobParametersInvalidException
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.text.SimpleDateFormat
import javax.batch.operations.JobExecutionAlreadyCompleteException

@Component
class ArcaCrawlerTestJobScheduler(
    val jobLauncher: JobLauncher,
    val arcaCrawlerTestReaderJobConfig: ArcaCrawlerTestReaderJobConfig
) {
    private val logger: Log = LogFactory.getLog(ArcaCrawlerTestJobScheduler::class.java);
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(cron = "5 * * * * *")
    fun runJob() {
        val jobConf = hashMapOf<String, JobParameter>()
        jobConf["time"] = JobParameter(dateFormat.format(System.currentTimeMillis()));
        val jobParameters = JobParameters(jobConf);

        try {
            jobLauncher
                .run(arcaCrawlerTestReaderJobConfig.customReaderJob(), jobParameters);
        }
        catch (e: JobExecutionAlreadyCompleteException){
            logger.info("Job is already running");
        }
        catch (e: JobExecutionAlreadyRunningException){
            logger.info("Job is already running");
        }
        catch (e: JobParametersInvalidException){
            logger.info("JobParametersInvalidException");
        }
        catch (e: Exception) {
            logger.error(e);
        }
    }

}