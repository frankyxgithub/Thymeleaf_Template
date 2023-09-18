package com.example.Thymleaf.Thymeleaf_Template.repository;

import com.example.Thymleaf.Thymeleaf_Template.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
