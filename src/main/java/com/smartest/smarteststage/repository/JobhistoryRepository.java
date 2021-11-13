package com.smartest.smarteststage.repository;

import com.smartest.smarteststage.entity.Jobhistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobhistoryRepository extends JpaRepository<Jobhistory, Integer> {
}