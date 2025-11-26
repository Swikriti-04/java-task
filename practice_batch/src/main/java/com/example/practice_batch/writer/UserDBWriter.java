package com.example.practice_batch.writer;

import com.example.practice_batch.repository.UserRepo;
import com.example.practice_batch.model.User;
import com.example.practice_batch.repository.UserRepo;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class UserDBWriter{



    @Bean
    public RepositoryItemWriter<User> writer(UserRepo repository) {
        RepositoryItemWriter<User> writer = new RepositoryItemWriter<>();
        writer.setRepository(repository);
        writer.setMethodName("save");
        return writer;
    }
}