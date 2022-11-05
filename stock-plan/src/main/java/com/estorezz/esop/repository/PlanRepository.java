package com.estorezz.esop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estorezz.esop.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {

	Plan findByPlanId(String planId);

	Plan findByPlanYear(String planYear);

}
