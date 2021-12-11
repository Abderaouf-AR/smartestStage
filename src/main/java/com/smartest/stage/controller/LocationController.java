package com.smartest.stage.controller;

import com.smartest.stage.model.Location;
import com.smartest.stage.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationController {
    private LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/locations")
    public List<Location> findAll() {
        return locationService.findAll();
    }

    @GetMapping("/locations/{locationId}")
    public Location getLocation(@PathVariable int locationId) {
        Location location = locationService.findById(locationId);
        if (location == null)
            throw new RuntimeException("Location id not found - " + locationId);
        return location;
    }

    @PostMapping("/locations")
    public Location addLocation(@RequestBody Location location) {
        location.setId(0);
        locationService.save(location);
        return location;
    }

    @PutMapping("/locations")
    public Location updateLocation(@RequestBody Location location) {
        locationService.save(location);
        return location;
    }

    @DeleteMapping("/locations/{locationId}")
    public String deleteLocation(@PathVariable int locationId) {
        Location tempLocation = locationService.findById(locationId);
        if (tempLocation == null)
            throw new RuntimeException("Location id not found - " + locationId);
        locationService.deleteById(locationId);
        return "Deleted location id - " + locationId;
    }
}
