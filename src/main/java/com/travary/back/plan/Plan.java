package com.travary.back.plan;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer planId;

    @Column(nullable = false)
    private LocalDate startPlan;

    @Column(nullable = false)
    private LocalDate endPlan;

    @Column
    private String countDate;

    @Column
    private String dayPlaceSchedule;

    @Column(nullable = false)
    private LocalDateTime createDate;

    @Builder
    public Plan(LocalDate startPlan, LocalDate endPlan,
                String countDate, String dayPlaceSchedule,
                LocalDateTime createDate) {
        this.startPlan = startPlan;
        this.endPlan = endPlan;
        this.countDate = countDate;
        this.dayPlaceSchedule = dayPlaceSchedule;
        this.createDate = createDate;
    }

    public static Plan createPlan(Plan plan) {
        return Plan.builder()
                .startPlan(plan.getStartPlan())
                .endPlan(plan.getEndPlan())
                .countDate(plan.getCountDate())
                .dayPlaceSchedule(plan.getDayPlaceSchedule())
                .createDate(LocalDateTime.now())
                .build();
    }
}

