package com.smartest.stage.repository;

import com.smartest.stage.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    <S extends Employee> S save(S entity);
    List<Employee> findAll();

}