package com.travary.back.plan;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PlanService {

    private final PlanRepository planRepository;

    @Transactional
    public void postPlan(Plan plan) {
        Plan postPlan = plan.createPlan(plan);
        this.planRepository.save(postPlan);
    }

    public List<Plan> getPlanList() {
        return this.planRepository.findAll();
    }
}
