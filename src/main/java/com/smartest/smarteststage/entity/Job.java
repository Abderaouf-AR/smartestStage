package com.smartest.smarteststage.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Job {
    private int id;
    private String jobTitle;
    private Long minSalary;
    private Long maxSalary;
    private Collection<JobHasTask> jobHasTasksById;
    private Collection<Jobhistory> jobhistoriesById;

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
    @Column(name = "job_title")
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Basic
    @Column(name = "min_salary")
    public Long getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Long minSalary) {
        this.minSalary = minSalary;
    }

    @Basic
    @Column(name = "max_salary")
    public Long getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Long maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id && Objects.equals(jobTitle, job.jobTitle) && Objects.equals(minSalary, job.minSalary) && Objects.equals(maxSalary, job.maxSalary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, jobTitle, minSalary, maxSalary);
    }

    @OneToMany(mappedBy = "jobByJobId")
    public Collection<JobHasTask> getJobHasTasksById() {
        return jobHasTasksById;
    }

    public void setJobHasTasksById(Collection<JobHasTask> jobHasTasksById) {
        this.jobHasTasksById = jobHasTasksById;
    }

    @OneToMany(mappedBy = "jobByJobId")
    public Collection<Jobhistory> getJobhistoriesById() {
        return jobhistoriesById;
    }

    public void setJobhistoriesById(Collection<Jobhistory> jobhistoriesById) {
        this.jobhistoriesById = jobhistoriesById;
    }
}
