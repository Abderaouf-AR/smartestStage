package com.smartest.smarteststage.service;

import com.smartest.smarteststage.model.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();

    Job findById(int id);

    void save(Job job);

    void deleteById(int id);
}
