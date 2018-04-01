package com.opportunity.application.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.PlatformTransactionManager;

import com.opportunity.spring.batch.listener.JobListener;
import com.opportunity.spring.batch.processor.ExcelRowDataProcessor;
import com.opportunity.spring.batch.reader.ExcelFileReader;
import com.opportunity.spring.batch.writer.DatabaseWriter;
import com.opportunity.spring.model.ExcelRow;

@Configuration
//@EnableJpaRepositories(basePackages="com.opportunity.spring.repository")
@EnableJpaRepositories
@ComponentScan(basePackages = "com.opportunity.spring")
@EnableBatchProcessing(modular = true)
public class BatchConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private ExcelFileReader excelFileReader;

	@Autowired
	private ExcelRowDataProcessor excelRowDataProcessor;

	@Autowired
	private DatabaseWriter databaseWriter;

	@Autowired
	private JobListener jobListener;

	@Bean
	public Job job1() {
		return jobBuilderFactory.get("job1").incrementer(new RunIdIncrementer()).listener(jobListener).flow(step1()).end()
				.preventRestart().build();
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<ExcelRow, AutomationConfiguration>chunk(10).reader(excelFileReader)
				.processor(excelRowDataProcessor).writer(databaseWriter).build();
	}

	/*@Bean
	public PlatformTransactionManager transactionManager() {
		return new ResourcelessTransactionManager();
	}

	@Bean
	public JobRepository jobRepository() throws Exception {
		return new MapJobRepositoryFactoryBean(transactionManager()).getObject();
	}

	@Bean
	public JobLauncher jobLauncher() throws Exception {
		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
		jobLauncher.setJobRepository(jobRepository());
		return jobLauncher;
	}*/
}
