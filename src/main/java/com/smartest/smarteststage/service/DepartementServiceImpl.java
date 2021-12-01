package com.smartest.smarteststage.service;

import com.smartest.smarteststage.model.Departement;
import com.smartest.smarteststage.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartementServiceImpl implements DepartementService{
    private DepartementRepository departementRepository;

    @Autowired
    public DepartementServiceImpl(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    @Override
    public List<Departement> findAll() {
        return departementRepository.findAll();
    }

    @Override
    public Departement findById(int id) {
        Optional<Departement> result = departementRepository.findById(id);
        Departement departement = null;

        if (result.isPresent())
            departement = result.get();
        else
            throw new RuntimeException("Did not find departement id - " + id);
        return departement;
    }

    @Override
    public void save(Departement departement) {
        departementRepository.save(departement);
    }

    @Override
    public void deleteById(int id) {
        departementRepository.deleteById(id);
    }
}
