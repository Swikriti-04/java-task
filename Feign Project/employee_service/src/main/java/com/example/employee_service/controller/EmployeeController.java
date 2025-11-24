package com.example.employee_service.controller;

import com.example.employee_service.dto.EmployeeResponse;
import com.example.employee_service.model.Employee;
import com.example.employee_service.repository.EmployeeRepo;
import com.example.employee_service.feign_client.DepartmentClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepo repo;
    private final DepartmentClient departmentClient;

    public EmployeeController(EmployeeRepo repo, DepartmentClient departmentClient) {
        this.repo = repo;
        this.departmentClient = departmentClient;
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee emp) {
        return repo.save(emp);
    }

    @GetMapping
    public List<Employee> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public EmployeeResponse getEmployeeDetails(@PathVariable Long id) {
        Employee emp = repo.findById(id).orElse(null);
        Object department = departmentClient.getDepartment(emp.getDepartmentId());
        return new EmployeeResponse(emp.getName(), department);
    }
}
