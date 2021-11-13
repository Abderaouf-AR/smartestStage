package com.smartest.smarteststage.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Country {
    private int id;
    private String countryName;
    private Region regionByRegionId;
    private Collection<Location> locationsById;

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
    @Column(name = "country_name")
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Country country = (Country) o;
//        return id == country.id && regionId == country.regionId && Objects.equals(countryName, country.countryName);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, countryName, regionId);
//    }

    @ManyToOne
    @JoinColumn(name = "region_id", referencedColumnName = "id", nullable = false)
    public Region getRegionByRegionId() {
        return regionByRegionId;
    }

    public void setRegionByRegionId(Region regionByRegionId) {
        this.regionByRegionId = regionByRegionId;
    }

    @OneToMany(mappedBy = "countryByCountryId")
    public Collection<Location> getLocationsById() {
        return locationsById;
    }

    public void setLocationsById(Collection<Location> locationsById) {
        this.locationsById = locationsById;
    }
}
