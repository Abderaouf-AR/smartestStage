package com.smartest.smarteststage.service;

import com.smartest.smarteststage.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void deleteById(int id);
}
