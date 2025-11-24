package com.example.employee_service.feign_client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE", url = "http://localhost:8081")
public interface DepartmentClient {

    @GetMapping("/departments/{id}")
    Object getDepartment(@PathVariable Long id);
}
