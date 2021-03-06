package com.smartest.stage.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

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

    @Column(name = "department_id")
    private int departmentId;
}
