package com.example.practice_batch.processor;

import com.example.practice_batch.model.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class UserProcessor implements ItemProcessor<User, User> {
    @Override
    public User process(User user) throws Exception {
        User newUser = new User();
        newUser.setName(user.getName().toUpperCase());
        newUser.setEmail(user.getEmail());
        return newUser;  // ID is left null, JPA will auto-generate
    }
}