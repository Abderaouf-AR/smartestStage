package com.smartest.stage.service;

import com.smartest.stage.model.Department;
import com.smartest.stage.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(int id) {
        Optional<Department> result = departmentRepository.findById(id);
        Department department = null;

        if (result.isPresent())
            department = result.get();
        else
            throw new RuntimeException("Did not find department id - " + id);
        return department;
    }

    @Override
    public void save(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void deleteById(int id) {
        departmentRepository.deleteById(id);
    }
}
