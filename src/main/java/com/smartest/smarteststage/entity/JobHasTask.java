package com.smartest.smarteststage.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(JobHasTaskPK.class)
public class JobHasTask {
    private Job jobByJobId;
    private Task taskByTaskId;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        JobHasTask that = (JobHasTask) o;
//        return jobId == that.jobId && taskId == that.taskId;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(jobId, taskId);
//    }

    @Id
    @ManyToOne
    @JoinColumn(name = "job_id", referencedColumnName = "id", nullable = false)
    public Job getJobByJobId() {
        return jobByJobId;
    }

    public void setJobByJobId(Job jobByJobId) {
        this.jobByJobId = jobByJobId;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "task_id", referencedColumnName = "id", nullable = false)
    public Task getTaskByTaskId() {
        return taskByTaskId;
    }

    public void setTaskByTaskId(Task taskByTaskId) {
        this.taskByTaskId = taskByTaskId;
    }
}
