package com.wipro.springboot.usecase1.controller;

import com.wipro.springboot.usecase1.entity.Employee;
import com.wipro.springboot.usecase1.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public Employee addEmployee(@RequestParam String name, @RequestParam String role) {
        return employeeService.addEmployee(name, role);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
