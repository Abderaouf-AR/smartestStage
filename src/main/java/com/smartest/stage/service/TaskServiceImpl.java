package com.smartest.stage.service;

import com.smartest.stage.model.Task;
import com.smartest.stage.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(int id) {
        Optional<Task> result = taskRepository.findById(id);
        Task task = null;

        if (result.isPresent())
            task = result.get();
        else
            throw new RuntimeException("Did not find task id - " + id);
        return task;
    }

    @Override
    public void save(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void deleteById(int id) {
        taskRepository.deleteById(id);
    }
}
