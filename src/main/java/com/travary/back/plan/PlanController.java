package com.travary.back.plan;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/plan")
@AllArgsConstructor
public class PlanController {

    private final PlanService planService;

    // plan 생성
    @PostMapping("/create")
    public String postPlan(@RequestBody Plan plan) {
        System.out.println(plan);
        this.planService.postPlan(plan);
        return "생성됨";
    }
}
