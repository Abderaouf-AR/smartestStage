package com.smartest.smarteststage.repository;

import com.smartest.smarteststage.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Integer> {
}