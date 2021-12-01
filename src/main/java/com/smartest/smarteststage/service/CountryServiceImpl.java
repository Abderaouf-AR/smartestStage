package com.smartest.smarteststage.service;

import com.smartest.smarteststage.model.Country;
import com.smartest.smarteststage.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService{
    private CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(int id) {
        Optional<Country> result = countryRepository.findById(id);
        Country country = null;

        if (result.isPresent())
            country = result.get();
        else
            throw new RuntimeException("Did not find country id - " + id);
        return country;
    }

    @Override
    public void save(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void deleteById(int id) {
        countryRepository.deleteById(id);
    }
}
