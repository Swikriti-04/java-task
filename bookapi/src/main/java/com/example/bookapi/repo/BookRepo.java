package com.example.bookapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bookapi.model.Book;

public interface BookRepo extends JpaRepository<Book, Long> {
}
