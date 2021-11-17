package com.smartest.smarteststage.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "departement")
public class Departement {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "departement")
    private String departement;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "location_id")
    private Location location;


    @OneToMany(mappedBy = "departement")
    private Collection<Employee> employees;

    @OneToMany(mappedBy = "departement")
    private Collection<JobHistory> jobhistories;

    public Departement() {
    }

    public Departement(String departement) {
        this.departement = departement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }

    public Collection<JobHistory> getJobhistories() {
        return jobhistories;
    }

    public void setJobhistories(Collection<JobHistory> jobhistories) {
        this.jobhistories = jobhistories;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "id=" + id +
                ", departement='" + departement + '\'' +
                ", location=" + location +
                ", employees=" + employees +
                ", jobhistories=" + jobhistories +
                '}';
    }
}
