package com.smartest.smarteststage.controller;

import com.smartest.smarteststage.model.Region;
import com.smartest.smarteststage.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegionController {
    private RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("/regions")
    public List<Region> findAll() {
        return regionService.findAll();
    }

    @GetMapping("/regions/{regionId}")
    public Region getRegion(@PathVariable int regionId) {
        Region region = regionService.findById(regionId);
        if (region == null)
            throw new RuntimeException("Region id not found - " + regionId);
        return region;
    }

    @PostMapping("/regions")
    public Region addRegion(@RequestBody Region region) {
        region.setId(0);
        regionService.save(region);
        return region;
    }

    @PutMapping("/regions")
    public Region updateRegion(@RequestBody Region region) {
        regionService.save(region);
        return region;
    }

    @DeleteMapping("/regions/{regionId}")
    public String deleteRegion(@PathVariable int regionId) {
        Region tempRegion = regionService.findById(regionId);
        if (tempRegion == null)
            throw new RuntimeException("Region id not found - " + regionId);
        regionService.deleteById(regionId);
        return "Deleted region id - " + regionId;
    }
}
