package com.smartest.smarteststage.repository;

import com.smartest.smarteststage.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}