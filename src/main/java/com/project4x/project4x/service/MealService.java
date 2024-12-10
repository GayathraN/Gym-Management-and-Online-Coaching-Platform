package com.project4x.project4x.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project4x.project4x.entity.MealCategory;
import com.project4x.project4x.entity.MealPlan;
import com.project4x.project4x.repository.MealRepository;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    // get member meal plans
    public List<MealPlanDetails> getMealPlansByMemberId(Long Id) {
        return mealRepository.findMealPlansByMemberId(Id)
                .stream().map(meal -> {
                    var mealPlanDetails = new MealPlanDetails(meal.getId(), meal.getMemberId());

                    return mealPlanDetails;
                }).collect(Collectors.toList());
    }

    // save member meal plans
    public List<MealPlan> saveAll(Long memberId, List<MealPlan> mealPlans) {
        MealPlan assignedMealPlan = mealRepository.findByMemberId(memberId);
        if (assignedMealPlan == null) {
            assignedMealPlan = mealRepository.save(new MealPlan(memberId, memberId));
        }

        for (MealPlan mealPlan : mealPlans) {
            mealPlan.setMealPlanId(assignedMealPlan.getMealPlanId());
            mealPlan.setdType(mealPlan.getAmount());
        }

        return mealRepository.saveAll(mealPlans);
    }

    public static class MealPlanDetails extends MealPlan {
        public MealPlanDetails(Long id, Long memberId) {
            super(id, memberId);
        }

        private MealCategory mealCategory;

        public MealCategory getMealCategory() {
            return mealCategory;
        }

        public void setMealCategory(MealCategory mealCategory) {
            this.mealCategory = mealCategory;
        }
    }
}
