package com.smartest.stage.controller;

import com.smartest.stage.model.Job;
import com.smartest.stage.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    private JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public List<Job> findAll() {
        return jobService.findAll();
    }

    @GetMapping("/jobs/{jobId}")
    public Job getJob(@PathVariable int jobId) {
        Job job = jobService.findById(jobId);
        if (job == null)
            throw new RuntimeException("Job id not found - " + jobId);
        return job;
    }

    @PostMapping("/jobs")
    public Job addJob(@RequestBody Job job) {
        job.setId(0);
        jobService.save(job);
        return job;
    }

    @PutMapping("/jobs")
    public Job updateJob(@RequestBody Job job) {
        jobService.save(job);
        return job;
    }

    @DeleteMapping("/jobs/{jobId}")
    public String deleteJob(@PathVariable int jobId) {
        Job tempJob = jobService.findById(jobId);
        if (tempJob == null)
            throw new RuntimeException("Job id not found - " + jobId);
        jobService.deleteById(jobId);
        return "Deleted job id - " + jobId;
    }
}
