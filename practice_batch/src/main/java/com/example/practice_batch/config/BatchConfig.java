package com.example.practice_batch.config;

import com.example.practice_batch.model.User;
import com.example.practice_batch.processor.UserProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
//@EnableBatchProcessing
public class BatchConfig {
    private final FlatFileItemReader<User> reader;
    private final UserProcessor processor;
    private final RepositoryItemWriter<User> writer;

    public BatchConfig(FlatFileItemReader<User> reader,
                       UserProcessor processor,
                       RepositoryItemWriter<User> writer) {
        this.reader = reader;
        this.processor = processor;
        this.writer = writer;
    }

    @Bean
    public Step userStep(JobRepository jobRepository,
                         PlatformTransactionManager transactionManager,
                         FlatFileItemReader<User> reader,
                         UserProcessor processor,
                         ItemWriter<User> writer) {
        return new StepBuilder("userStep", jobRepository)
                .<User, User>chunk(2, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public Job userJob(JobRepository jobRepository, Step userStep) {
        return new JobBuilder("userJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(userStep)
                .build();
    }
}