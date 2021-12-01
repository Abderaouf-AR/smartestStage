package com.smartest.smarteststage.repository;

import com.smartest.smarteststage.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}