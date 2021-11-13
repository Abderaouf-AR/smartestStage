package com.smartest.smarteststage.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Task {
    private int id;
    private String title;
    private String description;
    private Collection<JobHasTask> jobHasTasksById;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description);
    }

    @OneToMany(mappedBy = "taskByTaskId")
    public Collection<JobHasTask> getJobHasTasksById() {
        return jobHasTasksById;
    }

    public void setJobHasTasksById(Collection<JobHasTask> jobHasTasksById) {
        this.jobHasTasksById = jobHasTasksById;
    }
}
