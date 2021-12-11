package com.smartest.stage.service;

import com.smartest.stage.model.Region;

import java.util.List;

public interface RegionService {

    List<Region> findAll();

    Region findById(int id);

    void save(Region region);

    void deleteById(int id);
}
