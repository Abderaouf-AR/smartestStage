package com.smartest.smarteststage.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
}
