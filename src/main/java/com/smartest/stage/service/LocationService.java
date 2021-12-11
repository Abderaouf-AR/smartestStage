package com.smartest.stage.service;

import com.smartest.stage.model.Location;

import java.util.List;

public interface LocationService {
    List<Location> findAll();

    Location findById(int id);

    void save(Location location);

    void deleteById(int id);
}
