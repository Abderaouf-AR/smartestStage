package com.smartest.stage.controller;

import com.smartest.stage.model.Country;
import com.smartest.stage.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {
    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public List<Country> findAll() {
        return countryService.findAll();
    }

    @GetMapping("/countries/{countryId}")
    public Country getCountry(@PathVariable int countryId) {
        Country country = countryService.findById(countryId);
        if (country == null)
            throw new RuntimeException("Country id not found - " + countryId);
        return country;
    }

    @PostMapping("/countries")
    public Country addCountry(@RequestBody Country country) {
        country.setId(0);
        countryService.save(country);
        return country;
    }

    @PutMapping("/countries")
    public Country updateCountry(@RequestBody Country country) {
        countryService.save(country);
        return country;
    }

    @DeleteMapping("/countries/{countryId}")
    public String deleteCountry(@PathVariable int countryId) {
        Country tempCountry = countryService.findById(countryId);
        if (tempCountry == null)
            throw new RuntimeException("Country id not found - " + countryId);
        countryService.deleteById(countryId);
        return "Deleted country id - " + countryId;
    }
}
