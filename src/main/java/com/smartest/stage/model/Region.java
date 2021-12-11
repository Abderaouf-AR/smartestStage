package com.smartest.stage.model;

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
