package com.smartest.smarteststage.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "hire_date")
    private Timestamp hireDate;

    @Column(name = "salary")
    private Long salary;

    @Column(name = "comission_pct")
    private Long comissionPct;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "departement_id")
    private Departement departement;

    @OneToMany(mappedBy = "employee")
    private Collection<Job> jobs;

    @OneToMany(mappedBy = "employee")
    private Collection<JobHistory> jobhistories;
}
