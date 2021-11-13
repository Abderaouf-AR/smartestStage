package com.smartest.smarteststage.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Region {
    private int id;
    private String regionName;
    private Collection<Country> countriesById;

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
    @Column(name = "region_name")
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return id == region.id && Objects.equals(regionName, region.regionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, regionName);
    }

    @OneToMany(mappedBy = "regionByRegionId")
    public Collection<Country> getCountriesById() {
        return countriesById;
    }

    public void setCountriesById(Collection<Country> countriesById) {
        this.countriesById = countriesById;
    }
}
