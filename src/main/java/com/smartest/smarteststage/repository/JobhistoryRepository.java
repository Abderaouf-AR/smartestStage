package com.smartest.smarteststage.repository;

import com.smartest.smarteststage.model.JobHistory;
import com.smartest.smarteststage.model.JobHistoryPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobHistoryRepository extends JpaRepository<JobHistory, JobHistoryPK> {
}