package com.smartest.smarteststage.service;

import com.smartest.smarteststage.model.JobHistory;
import com.smartest.smarteststage.model.JobHistoryPK;
import com.smartest.smarteststage.repository.JobHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobHistoryServiceImpl implements JobHistoryService{
    private JobHistoryRepository jobHistoryRepository;

    @Autowired
    public JobHistoryServiceImpl(JobHistoryRepository jobHistoryRepository) {
        this.jobHistoryRepository = jobHistoryRepository;
    }

    @Override
    public List<JobHistory> findAll() {
        return jobHistoryRepository.findAll();
    }

    @Override
    public JobHistory findById(JobHistoryPK jobHistoryPK) {
        Optional<JobHistory> result = jobHistoryRepository.findById(jobHistoryPK);
        JobHistory jobHistory = null;

        if (result.isPresent())
            jobHistory = result.get();
        else
            throw new RuntimeException("Did not find jobHistory jobHistoryPK - " + jobHistoryPK);
        return jobHistory;
    }

    @Override
    public void save(JobHistory jobHistory) {
        jobHistoryRepository.save(jobHistory);
    }

    @Override
    public void deleteById(JobHistoryPK jobHistoryPK) {
        jobHistoryRepository.deleteById(jobHistoryPK);
    }
}
