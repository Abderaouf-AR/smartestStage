package com.smartest.stage.service;

import com.smartest.stage.model.JobHistory;
import com.smartest.stage.model.JobHistoryPK;

import java.util.List;

public interface JobHistoryService {
    List<JobHistory> findAll();

    JobHistory findById(JobHistoryPK jobHistoryPK);

    void save(JobHistory jobHistory);

    void deleteById(JobHistoryPK jobHistoryPK);
}
