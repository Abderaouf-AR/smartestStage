package com.smartest.smarteststage.service;

import com.smartest.smarteststage.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> findAll();

    Country findById(int id);

    void save(Country country);

    void deleteById(int id);
}
