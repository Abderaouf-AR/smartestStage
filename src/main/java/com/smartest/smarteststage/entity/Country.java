package com.smartest.smarteststage.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@AllArgsConstructor
@Table(name = "Country")
public class Country {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "country_name")
    private String countryName;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(mappedBy = "country")
    private Collection<Location> locations;
}
