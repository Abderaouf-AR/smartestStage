package com.smartest.stage.repository;

import com.smartest.stage.model.JobHistory;
import com.smartest.stage.model.JobHistoryPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobHistoryRepository extends JpaRepository<JobHistory, JobHistoryPK> {
}