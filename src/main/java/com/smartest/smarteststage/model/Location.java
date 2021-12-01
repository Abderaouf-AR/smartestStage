package com.smartest.smarteststage.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "city")
    private String city;

    @Column(name = "state_province")
    private String stateProvince;

    @OneToMany(mappedBy = "location")
    private Collection<Departement> departements;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "country_id")
    private Country country;
}
