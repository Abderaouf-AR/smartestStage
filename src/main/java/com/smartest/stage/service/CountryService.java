package com.smartest.stage.service;

import com.smartest.stage.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> findAll();

    Country findById(int id);

    void save(Country country);

    void deleteById(int id);
}
