package com.example.department_service.controller;

import com.example.department_service.model.Department;
import com.example.department_service.repository.DepartmentRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentRepo repo;

    public DepartmentController(DepartmentRepo repo) {
        this.repo = repo;
    }

    @PostMapping
    public Department addDepartment(@RequestBody Department dept) {
        return repo.save(dept);
    }

    @GetMapping
    public List<Department> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }
}
