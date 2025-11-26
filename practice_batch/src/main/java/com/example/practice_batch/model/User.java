package com.example.practice_batch.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data   // Lombok
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String name;

    @Column(unique = true)
    private String email;
}
