package com.smartest.smarteststage.service;

import com.smartest.smarteststage.model.JobHistory;
import com.smartest.smarteststage.model.JobHistoryPK;

import java.util.List;

public interface JobHistoryService {
    List<JobHistory> findAll();

    JobHistory findById(JobHistoryPK jobHistoryPK);

    void save(JobHistory jobHistory);

    void deleteById(JobHistoryPK jobHistoryPK);
}
