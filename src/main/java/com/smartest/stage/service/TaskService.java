package com.smartest.stage.service;

import com.smartest.stage.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAll();

    Task findById(int id);

    void save(Task task);

    void deleteById(int id);
}
