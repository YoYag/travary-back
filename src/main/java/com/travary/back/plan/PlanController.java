package com.travary.back.plan;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // plan 조회
    @GetMapping("/list/all")
    public List<Plan> getPlanList() {
        return this.planService.getPlanList();
    }
}
