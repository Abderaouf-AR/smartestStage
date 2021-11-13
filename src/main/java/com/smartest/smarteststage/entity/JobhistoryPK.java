package com.smartest.smarteststage.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class JobhistoryPK implements Serializable {
    private Timestamp startDate;
    private Timestamp endDate;
    private Departement departementByDepartementId;
    private Job jobByJobId;
    private Employee employeeByEmployeeId;

    @Basic
    @Column(name = "start_date")
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date")
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }



//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Jobhistory that = (Jobhistory) o;
//        return departementId == that.departementId && jobId == that.jobId && employeeId == that.employeeId && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(startDate, endDate, departementId, jobId, employeeId);
//    }

    @Id
    @ManyToOne
    @JoinColumn(name = "departement_id", referencedColumnName = "id", nullable = false)
    public Departement getDepartementByDepartementId() {
        return departementByDepartementId;
    }

    public void setDepartementByDepartementId(Departement departementByDepartementId) {
        this.departementByDepartementId = departementByDepartementId;
    }

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
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    public Employee getEmployeeByEmployeeId() {
        return employeeByEmployeeId;
    }

    public void setEmployeeByEmployeeId(Employee employeeByEmployeeId) {
        this.employeeByEmployeeId = employeeByEmployeeId;
    }
}
