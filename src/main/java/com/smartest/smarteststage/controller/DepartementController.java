package com.smartest.smarteststage.controller;

import com.smartest.smarteststage.model.Departement;
import com.smartest.smarteststage.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartementController {
    private DepartementService departementService;

    @Autowired
    public DepartementController(DepartementService departementService) {
        this.departementService = departementService;
    }

    @GetMapping("/departements")
    public List<Departement> findAll() {
        return departementService.findAll();
    }

    @GetMapping("/departements/{departementId}")
    public Departement getDepartement(@PathVariable int departementId) {
        Departement departement = departementService.findById(departementId);
        if (departement == null)
            throw new RuntimeException("Departement id not found - " + departementId);
        return departement;
    }

    @PostMapping("/departements")
    public Departement addDepartement(@RequestBody Departement departement) {
        departement.setId(0);
        departementService.save(departement);
        return departement;
    }

    @PutMapping("/departements")
    public Departement updateDepartement(@RequestBody Departement departement) {
        departementService.save(departement);
        return departement;
    }

    @DeleteMapping("/departements/{departementId}")
    public String deleteDepartement(@PathVariable int departementId) {
        Departement tempDepartement = departementService.findById(departementId);
        if (tempDepartement == null)
            throw new RuntimeException("Departement id not found - " + departementId);
        departementService.deleteById(departementId);
        return "Deleted departement id - " + departementId;
    }
}
