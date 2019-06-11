package com.employee.repository;

import com.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByNameContainingIgnoreCase(String s);
    List<Employee> findByEmployeeCodeContainingIgnoreCase(String s);
    Employee findByEmployeeCode(String code);
    Long countByEmployeeCode(String code);
}
