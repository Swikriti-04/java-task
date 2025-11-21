package com.example.practiceapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.practiceapi.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
    // You can add custom query methods here if needed later
}