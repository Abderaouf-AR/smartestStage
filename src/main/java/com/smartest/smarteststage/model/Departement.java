package com.smartest.smarteststage.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Entity
@Table(name = "departement")
public class Departement implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "departement")
    private String departement;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "location_id")
    private Location location;


    @OneToMany(mappedBy = "departement")
    private Collection<Employee> employees;

    @OneToMany(mappedBy = "departement")
    private Collection<JobHistory> jobhistories;
}
