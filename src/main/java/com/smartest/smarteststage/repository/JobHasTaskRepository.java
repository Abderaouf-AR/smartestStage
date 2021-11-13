package com.smartest.smarteststage.repository;

import com.smartest.smarteststage.entity.JobHasTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobHasTaskRepository extends JpaRepository<JobHasTask, Integer> {
}