package com.smartest.smarteststage.service;

import com.smartest.smarteststage.model.Location;

import java.util.List;

public interface LocationService {
    List<Location> findAll();

    Location findById(int id);

    void save(Location location);

    void deleteById(int id);
}
