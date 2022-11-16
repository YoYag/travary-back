package com.travary.back.plan;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private LocalDateTime startPlan;

    @Column
    private LocalDateTime endPlan;

    @Column
    private List<Integer> countDate;

    @Column
    private List<String> dayPlaceSchedule;

    @Column
    private LocalDateTime createDate;
}
