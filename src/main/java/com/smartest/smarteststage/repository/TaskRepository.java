package com.smartest.smarteststage.repository;

import com.smartest.smarteststage.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}