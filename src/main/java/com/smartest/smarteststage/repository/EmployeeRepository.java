package com.smartest.smarteststage.repository;

import com.smartest.smarteststage.model.Departement;
import com.smartest.smarteststage.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}