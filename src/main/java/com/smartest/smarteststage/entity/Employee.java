package com.smartest.smarteststage.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Timestamp hireDate;
    private Long salary;
    private Long comissionPct;
    private Departement departementByDepartementId;
    private Collection<Jobhistory> jobhistoriesById;



    public Employee(String firstName, String lastName, String email, String phoneNumber, Timestamp hireDate, Long salary, Long comissionPct) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.salary = salary;
        this.comissionPct = comissionPct;
    }

    public Employee() {
    }

    public Employee(String firstName) {
        this.firstName = firstName;
    }

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
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "hire_date")
    public Timestamp getHireDate() {
        return hireDate;
    }

    public void setHireDate(Timestamp hireDate) {
        this.hireDate = hireDate;
    }

    @Basic
    @Column(name = "salary")
    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "comission_pct")
    public Long getComissionPct() {
        return comissionPct;
    }

    public void setComissionPct(Long comissionPct) {
        this.comissionPct = comissionPct;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Employee employee = (Employee) o;
//        return id == employee.id && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(email, employee.email) && Objects.equals(phoneNumber, employee.phoneNumber) && Objects.equals(hireDate, employee.hireDate) && Objects.equals(salary, employee.salary) && Objects.equals(comissionPct, employee.comissionPct) && Objects.equals(departementId, employee.departementId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, firstName, lastName, email, phoneNumber, hireDate, salary, comissionPct, departementId);
//    }

    @ManyToOne
    @JoinColumn(name = "departement_id", referencedColumnName = "id")
    public Departement getDepartementByDepartementId() {
        return departementByDepartementId;
    }

    public void setDepartementByDepartementId(Departement departementByDepartementId) {
        this.departementByDepartementId = departementByDepartementId;
    }

    @OneToMany(mappedBy = "employeeByEmployeeId",fetch = FetchType.EAGER)
    public Collection<Jobhistory> getJobhistoriesById() {
        return jobhistoriesById;
    }

    public void setJobhistoriesById(Collection<Jobhistory> jobhistoriesById) {
        this.jobhistoriesById = jobhistoriesById;
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
                ", departementByDepartementId=" + departementByDepartementId +
                ", jobhistoriesById=" + jobhistoriesById +
                '}';
    }
}
