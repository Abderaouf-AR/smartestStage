package com.smartest.stage.service;

import com.smartest.stage.model.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();

    Department findById(int id);

    void save(Department department);

    void deleteById(int id);
}
