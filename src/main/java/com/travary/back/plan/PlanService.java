package com.travary.back.plan;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PlanService {

    private final PlanRepository planRepository;

    @Transactional
    public void postPlan(Plan plan) {
        Plan postPlan = plan.createPlan(plan);
        planRepository.save(postPlan);
    }
}
