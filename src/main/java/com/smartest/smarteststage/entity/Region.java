package com.smartest.smarteststage.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "region")
public class Region {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "region_name")
    private String regionName;

    @OneToMany(mappedBy = "region")
    private Collection<Country> countriesById;

    public Region(String regionName) {
        this.regionName = regionName;
    }

    public Region() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Collection<Country> getCountriesById() {
        return countriesById;
    }

    public void setCountriesById(Collection<Country> countriesById) {
        this.countriesById = countriesById;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", regionName='" + regionName + '\'' +
                ", countriesById=" + countriesById +
                '}';
    }
}
