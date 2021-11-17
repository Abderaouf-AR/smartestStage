package com.smartest.smarteststage.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class JobHistoryPK implements Serializable {

    @Id
    @Column(name = "departement_id")
    private int departement;

    @Id
    @Column(name = "job_id")
    private int job;

    @Id
    @Column(name = "employee_id")
    private int employee;

    public JobHistoryPK(int departement, int job, int employee) {
        this.departement = departement;
        this.job = job;
        this.employee = employee;
    }

    public int getDepartement() {
        return departement;
    }

    public void setDepartement(int departement) {
        this.departement = departement;
    }

    public int getJob() {
        return job;
    }

    public void setJob(int job) {
        this.job = job;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobHistoryPK that = (JobHistoryPK) o;
        return departement == that.departement && job == that.job && employee == that.employee;
    }

    @Override
    public int hashCode() {
        return Objects.hash(departement, job, employee);
    }

    @Override
    public String toString() {
        return "JobHistoryPK{" +
                "departement=" + departement +
                ", job=" + job +
                ", employee=" + employee +
                '}';
    }
}
