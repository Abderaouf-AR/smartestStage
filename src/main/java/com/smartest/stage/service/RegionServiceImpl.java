package com.smartest.stage.service;


import com.smartest.stage.model.Region;
import com.smartest.stage.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionServiceImpl implements RegionService {
    private RegionRepository regionRepository;

    @Autowired
    public  RegionServiceImpl( RegionRepository  regionRepository) {
        this. regionRepository =  regionRepository;
    }

    @Override
    public List<Region> findAll() {
        return  regionRepository.findAll();
    }

    @Override
    public Region findById(int id) {
        Optional< Region> result =  regionRepository.findById(id);
        Region  region = null;

        if (result.isPresent())
            region = result.get();
        else
            throw new RuntimeException("Did not find  region id - " + id);
        return  region;
    }

    @Override
    public void save(Region region) {
        regionRepository.save( region);
    }

    @Override
    public void deleteById(int id) {
        regionRepository.deleteById(id);
    }
}
