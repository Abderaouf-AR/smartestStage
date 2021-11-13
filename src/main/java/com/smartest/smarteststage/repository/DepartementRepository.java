package com.smartest.smarteststage.repository;

import com.smartest.smarteststage.entity.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {
}