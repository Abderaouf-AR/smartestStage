package com.smartest.smarteststage.repository;

import com.smartest.smarteststage.entity.Departement;
import com.smartest.smarteststage.entity.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobHistoryRepository extends JpaRepository<JobHistory, Departement> {
}