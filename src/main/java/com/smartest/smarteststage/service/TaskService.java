package com.smartest.smarteststage.service;

import com.smartest.smarteststage.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAll();

    Task findById(int id);

    void save(Task task);

    void deleteById(int id);
}
