package com.example.employee_service.dto;

public class EmployeeResponse {

    private String name;
    private Object department;

    public EmployeeResponse() {}

    public EmployeeResponse(String name, Object department) {
        this.name = name;
        this.department = department;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Object getDepartment() { return department; }
    public void setDepartment(Object department) { this.department = department; }
}
