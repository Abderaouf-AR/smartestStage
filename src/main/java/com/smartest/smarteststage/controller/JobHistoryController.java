package com.smartest.smarteststage.controller;

import com.smartest.smarteststage.model.Job;
import com.smartest.smarteststage.model.JobHistory;
import com.smartest.smarteststage.model.JobHistoryPK;
import com.smartest.smarteststage.service.JobHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobHistoryController {
    private JobHistoryService jobHistoryService;

    @Autowired
    public JobHistoryController(JobHistoryService jobHistoryService) {
        this.jobHistoryService = jobHistoryService;
    }

    @GetMapping("/jobHistories")
    public List<JobHistory> findAll() {
        return jobHistoryService.findAll();
    }

    @GetMapping("/jobHistories/{jobHistoryId}")
    public JobHistory getJobHistory(@PathVariable JobHistoryPK jobHistoryId) {
        JobHistory jobHistory = jobHistoryService.findById(jobHistoryId);
        if (jobHistory == null)
            throw new RuntimeException("jobHistories id not found - " + jobHistoryId);
        return jobHistory;
    }

    @PostMapping("/jobHistories")
    public JobHistory addJobHistory(@RequestBody JobHistory jobHistory) {
        jobHistory.setJobhistoryPK(null);
        jobHistoryService.save(jobHistory);
        return jobHistory;
    }

    @PutMapping("/jobHistories")
    public JobHistory updateJobHistory(@RequestBody JobHistory jobHistory) {
        jobHistoryService.save(jobHistory);
        return jobHistory;
    }

    @DeleteMapping("/jobHistories/{jobHistoryId}")
    public String deleteJobHistory(@PathVariable JobHistoryPK jobHistoryId) {
        JobHistory tempjobHistories = jobHistoryService.findById(jobHistoryId);
        if (tempjobHistories == null)
            throw new RuntimeException("jobHistories id not found - " + jobHistoryId);
        jobHistoryService.deleteById(jobHistoryId);
        return "Deleted jobHistory id - " + jobHistoryId;
    }
}
