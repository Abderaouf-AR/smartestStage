package com.smartest.smarteststage;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class JobTaskPK implements Serializable {
    private int jobId;
    private int taskId;

    @Column(name = "job_id")
    @Id
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    @Column(name = "task_id")
    @Id
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobTaskPK jobTaskPK = (JobTaskPK) o;
        return jobId == jobTaskPK.jobId && taskId == jobTaskPK.taskId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, taskId);
    }
}
