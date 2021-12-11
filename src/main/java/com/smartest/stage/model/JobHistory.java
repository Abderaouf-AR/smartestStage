package com.smartest.stage.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "jobhistoryPK")
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

    @MapsId("departmentId")
    @ManyToOne
    private Department department;
}
