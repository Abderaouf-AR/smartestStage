package com.smartest.smarteststage.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Location {
    private int id;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;
    private Collection<Departement> departementsById;
    private Country countryByCountryId;

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
    @Column(name = "street_address")
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    @Basic
    @Column(name = "postal_code")
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "state_province")
    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }



//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Location location = (Location) o;
//        return id == location.id && countryId == location.countryId && Objects.equals(streetAddress, location.streetAddress) && Objects.equals(postalCode, location.postalCode) && Objects.equals(city, location.city) && Objects.equals(stateProvince, location.stateProvince);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, streetAddress, postalCode, city, stateProvince, countryId);
//    }

    @OneToMany(mappedBy = "locationByLocationId")
    public Collection<Departement> getDepartementsById() {
        return departementsById;
    }

    public void setDepartementsById(Collection<Departement> departementsById) {
        this.departementsById = departementsById;
    }

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    public Country getCountryByCountryId() {
        return countryByCountryId;
    }

    public void setCountryByCountryId(Country countryByCountryId) {
        this.countryByCountryId = countryByCountryId;
    }
}
