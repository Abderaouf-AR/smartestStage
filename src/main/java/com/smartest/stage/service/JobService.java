package com.smartest.stage.service;

import com.smartest.stage.model.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();

    Job findById(int id);

    void save(Job job);

    void deleteById(int id);
}
