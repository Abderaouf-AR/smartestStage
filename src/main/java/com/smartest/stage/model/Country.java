package com.smartest.stage.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
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
