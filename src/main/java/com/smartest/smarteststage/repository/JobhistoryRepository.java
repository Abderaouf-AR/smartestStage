package com.smartest.smarteststage.repository;

import com.smartest.smarteststage.entity.JobHistory;
import com.smartest.smarteststage.entity.JobHistoryPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobHistoryRepository extends JpaRepository<JobHistory, JobHistoryPK> {
}