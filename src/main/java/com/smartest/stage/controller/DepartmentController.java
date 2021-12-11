package com.smartest.stage.controller;

import com.smartest.stage.model.Department;
import com.smartest.stage.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
    public List<Department> findAll() {
        return departmentService.findAll();
    }

    @GetMapping("/departments/{departmentId}")
    public Department getDepartment(@PathVariable int departmentId) {
        Department department = departmentService.findById(departmentId);
        if (department == null)
            throw new RuntimeException("Department id not found - " + departmentId);
        return department;
    }

    @PostMapping("/departments")
    public Department addDepartment(@RequestBody Department department) {
        department.setId(0);
        departmentService.save(department);
        return department;
    }

    @PutMapping("/departments")
    public Department updateDepartment(@RequestBody Department department) {
        departmentService.save(department);
        return department;
    }

    @DeleteMapping("/departments/{departmentId}")
    public String deleteDepartment(@PathVariable int departmentId) {
        Department tempDepartment = departmentService.findById(departmentId);
        if (tempDepartment == null)
            throw new RuntimeException("Department id not found - " + departmentId);
        departmentService.deleteById(departmentId);
        return "Deleted department id - " + departmentId;
    }
}
