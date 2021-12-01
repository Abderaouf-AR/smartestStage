package com.smartest.smarteststage.service;

import com.smartest.smarteststage.model.Departement;

import java.util.List;

public interface DepartementService {
    List<Departement> findAll();

    Departement findById(int id);

    void save(Departement departement);

    void deleteById(int id);
}
