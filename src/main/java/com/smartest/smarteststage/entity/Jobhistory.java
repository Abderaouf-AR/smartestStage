package com.smartest.smarteststage.entity;

import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.ZonedDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "jobhistory")
public class JobHistory implements Serializable {

    @EmbeddedId
    private JobHistoryPK jobhistoryPK;

    @Column(name = "start_date",columnDefinition="TIMESTAMP")
    @UpdateTimestamp
    private ZonedDateTime startDate;

    @Column(name = "end_date",columnDefinition="TIMESTAMP")
    @UpdateTimestamp
    private ZonedDateTime endDate;

    @MapsId("jobId")
    @ManyToOne
    private Job job;

    @MapsId("employeeId")
    @ManyToOne
    private Employee employee;

    @MapsId("jobId")
    @ManyToOne
    private Departement departement;
}
