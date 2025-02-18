package com.wipro.springboot.usecase1.service;

import java.util.List;

import com.wipro.springboot.usecase1.entity.Employee;

public interface EmployeeService {
    Employee addEmployee(String name, String role);
    List<Employee> getAllEmployees();
}
