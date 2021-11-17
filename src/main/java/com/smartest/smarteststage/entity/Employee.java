package com.smartest.smarteststage.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "hire_date")
    private Timestamp hireDate;

    @Column(name = "salary")
    private Long salary;

    @Column(name = "comission_pct")
    private Long comissionPct;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "departement_id")
    private Departement departement;

    @OneToMany(mappedBy = "employee")
    private Collection<Job> jobs;

    @OneToMany(mappedBy = "employee")
    private Collection<JobHistory> jobhistories;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String email, String phoneNumber, Timestamp hireDate, Long salary, Long comissionPct) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.salary = salary;
        this.comissionPct = comissionPct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Timestamp getHireDate() {
        return hireDate;
    }

    public void setHireDate(Timestamp hireDate) {
        this.hireDate = hireDate;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Long getComissionPct() {
        return comissionPct;
    }

    public void setComissionPct(Long comissionPct) {
        this.comissionPct = comissionPct;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Collection<JobHistory> getJobhistories() {
        return jobhistories;
    }

    public void setJobhistories(Collection<JobHistory> jobhistories) {
        this.jobhistories = jobhistories;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                ", comissionPct=" + comissionPct +
                ", departement=" + departement +
                ", jobhistories=" + jobhistories +
                '}';
    }
}
