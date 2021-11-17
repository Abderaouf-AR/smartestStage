package com.smartest.smarteststage;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class JobhistoryPK implements Serializable {
    private int departementId;
    private int jobId;
    private int employeeId;

    @Column(name = "departement_id")
    @Id
    public int getDepartementId() {
        return departementId;
    }

    public void setDepartementId(int departementId) {
        this.departementId = departementId;
    }

    @Column(name = "job_id")
    @Id
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    @Column(name = "employee_id")
    @Id
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobhistoryPK that = (JobhistoryPK) o;
        return departementId == that.departementId && jobId == that.jobId && employeeId == that.employeeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(departementId, jobId, employeeId);
    }
}
