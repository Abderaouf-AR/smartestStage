package com.smartest.smarteststage.repository;

import com.smartest.smarteststage.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}