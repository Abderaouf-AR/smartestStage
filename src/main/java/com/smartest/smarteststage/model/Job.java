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
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "min_salary")
    private Long minSalary;

    @Column(name = "max_salary")
    private Long maxSalary;

    @ManyToMany
    @JoinTable(
            name = "job_task",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    private Collection<Task> Tasks;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToMany(mappedBy = "job")
    private Collection<JobHistory> jobHistories;
}
