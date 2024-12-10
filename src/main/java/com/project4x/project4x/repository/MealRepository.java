package com.project4x.project4x.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project4x.project4x.entity.MealPlan;

public interface MealRepository extends JpaRepository<MealPlan, Long> {
    List<MealPlan> findMealPlansByMemberId(Long memberId);

    MealPlan findByMemberId(Long memberId);
}
