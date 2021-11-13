package com.smartest.smarteststage.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Departement {
    private int id;
    private String departement;
    private Location locationByLocationId;
    private Collection<Employee> employeesById;
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
    @Column(name = "departement")
    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Departement that = (Departement) o;
//        return id == that.id && locationId == that.locationId && Objects.equals(departement, that.departement);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, departement, locationId);
//    }

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id", nullable = false)
    public Location getLocationByLocationId() {
        return locationByLocationId;
    }

    public void setLocationByLocationId(Location locationByLocationId) {
        this.locationByLocationId = locationByLocationId;
    }

    @OneToMany(mappedBy = "departementByDepartementId")
    public Collection<Employee> getEmployeesById() {
        return employeesById;
    }

    public void setEmployeesById(Collection<Employee> employeesById) {
        this.employeesById = employeesById;
    }

    @OneToMany(mappedBy = "departementByDepartementId")
    public Collection<Jobhistory> getJobhistoriesById() {
        return jobhistoriesById;
    }

    public void setJobhistoriesById(Collection<Jobhistory> jobhistoriesById) {
        this.jobhistoriesById = jobhistoriesById;
    }
}
