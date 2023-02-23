package com.sample.springboothelloSubway.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.builder.MyBatisBatchItemWriterBuilder;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.sample.springboothelloSubway.dao.Substation;

@Configuration
public class CsvBatch {
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	
	@Bean
	public Job CsvBatchJob(batchJobListener jobListener, StepBuilderFactory CsvbatchStep) {
		return jobBuilderFactory.get("CsvBatchJob")
				.incrementer(jobListener)
				.flow(CsvbatchStep)
				.end()
				.build();
	}
	
	@Bean
	public Step CsvBatchStep(batchStepListener stepListener, MyBatisBatchItemWriter<Substation> writer) {
		return stepBuilderFactory.get("CsvBatchStep")
				.listener(stepListener)
				.<Substation, Substation> chunk(100)
				.reader(reader())
				.processor(processor())
				.writer(writer)
				.build();
	}
	
	@Bean
	public FlatFileItemReader<Substation> reader(){
		return new FlatFileItemReaderBuilder<Substation>()
				.name("flatFileItemReader")
				.resource(new ClassPathResource("C:\\Users\\hhjeo\\DtolStudy\\spring-boot-hello\\src\\main\\resources\\csv\\Subway2.csv"))
				.delimited()
				.names(new String[] {"USE_DT", "LINE_NUM","SUB_STA_NM","RIDE_PASGR_NUM","ALIGHT_PASGR_NUM","WORK_DT"})
				.fieldSetMapper(new BeanWrapperFieldSetMapper<Substation>() {{
					setTargetType(Substation.class);
				}})
				.build();
	}
	
	
	@Bean
    public SubstationLowerProcessor processor() {
        return new SubstationLowerProcessor();
    }
	
	@Bean
    public MyBatisBatchItemWriter<Substation> writer(SqlSessionFactory sqlSessionFactory) {
        return new MyBatisBatchItemWriterBuilder<Substation>()
            .sqlSessionFactory(sqlSessionFactory)
            .statementId("substation.saveSubstation")
            .build();
    }
}
