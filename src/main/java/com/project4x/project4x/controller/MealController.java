package com.project4x.project4x.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project4x.project4x.DTO.MealPlanDTO;
import com.project4x.project4x.entity.MealPlan;
import com.project4x.project4x.service.MealCategoryService;
import com.project4x.project4x.service.MealService;

@Controller
@RequestMapping("/meals")
public class MealController {

    @Autowired
    MealService mealService;

    @Autowired
    MealCategoryService mealCategoryService;

    // Show meals dashboard
    @GetMapping("/meals")
    public String getMeals(@RequestParam("username") String username, @RequestParam("id") Long id, Model model) {
        var mealPlans = mealService.getMealPlansByMemberId(id);
        var mealCategories = mealCategoryService.getMealCategories();

        model.addAttribute("mealPlans", mealPlans);
        model.addAttribute("mealCategories", mealCategories);
        model.addAttribute("memberId", id);

        return "Meal/mealPlans";
    }

    // Assign meal plan to a member
    @PostMapping("/assign")
    public ResponseEntity<Map<String, String>> assignMeals(
            @RequestParam Long memberId,
            @RequestBody List<MealPlanDTO> mealPlanDTOs) {

        List<MealPlan> mealPlans = mealPlanDTOs.stream()
                .map(dto -> {
                    MealPlan mealPlan = new MealPlan();
                    mealPlan.setMealItemId(dto.getMealItemId());
                    mealPlan.setMealType(dto.getMealType());
                    mealPlan.setMemberId(memberId);
                    mealPlan.setAmount(dto.getAmount());

                    return mealPlan;
                }).collect(Collectors.toList());

        mealService.saveAll(memberId, mealPlans);

        // Return a valid JSON response
        Map<String, String> response = new HashMap<>();
        response.put("message", "Meals assigned successfully");
        return ResponseEntity.ok(response);
    }
}
