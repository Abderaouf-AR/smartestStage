package com.smartest.smarteststage.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Embeddable
public class JobHistoryPK implements Serializable {

    @Column(name = "job_id")
    private int jobId;

    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "departement_id")
    private int departementId;
}
