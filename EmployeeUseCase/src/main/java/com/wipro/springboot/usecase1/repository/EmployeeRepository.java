package com.wipro.springboot.usecase1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.springboot.usecase1.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {}
