package com.smartest.smarteststage.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
