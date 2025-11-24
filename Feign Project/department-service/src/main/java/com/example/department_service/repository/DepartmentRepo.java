package com.example.department_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.department_service.model.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long> {}
