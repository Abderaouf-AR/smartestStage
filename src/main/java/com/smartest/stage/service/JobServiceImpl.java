package com.smartest.stage.service;

import com.smartest.stage.model. Job;
import com.smartest.stage.repository. JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class  JobServiceImpl implements  JobService {
    private  JobRepository jobRepository;

    @Autowired
    public  JobServiceImpl( JobRepository  jobRepository) {
        this. jobRepository =  jobRepository;
    }

    @Override
    public List< Job> findAll() {
        return  jobRepository.findAll();
    }

    @Override
    public  Job findById(int id) {
        Optional< Job> result =  jobRepository.findById(id);
         Job  job = null;

        if (result.isPresent())
             job = result.get();
        else
            throw new RuntimeException("Did not find  job id - " + id);
        return  job;
    }

    @Override
    public void save( Job  job) {
         jobRepository.save( job);
    }

    @Override
    public void deleteById(int id) {
         jobRepository.deleteById(id);
    }
}