package com.smartest.stage.controller;

import com.smartest.stage.model.Task;
import com.smartest.stage.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> findAll() {
        return taskService.findAll();
    }

    @GetMapping("/tasks/{taskId}")
    public Task getTask(@PathVariable int taskId) {
        Task task = taskService.findById(taskId);
        if (task == null)
            throw new RuntimeException("Task id not found - " + taskId);
        return task;
    }

    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task task) {
        task.setId(0);
        taskService.save(task);
        return task;
    }

    @PutMapping("/tasks")
    public Task updateTask(@RequestBody Task task) {
        taskService.save(task);
        return task;
    }

    @DeleteMapping("/tasks/{taskId}")
    public String deleteTask(@PathVariable int taskId) {
        Task tempTask = taskService.findById(taskId);
        if (tempTask == null)
            throw new RuntimeException("Task id not found - " + taskId);
        taskService.deleteById(taskId);
        return "Deleted task id - " + taskId;
    }
}
