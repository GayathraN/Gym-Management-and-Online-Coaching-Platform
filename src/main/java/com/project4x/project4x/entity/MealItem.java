package com.project4x.project4x.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MealItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long mealCategoryId;

    public MealItem() {
    }

    public MealItem(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMealCategoryId() {
        return mealCategoryId;
    }

    public void setMealCategoryId(Long mealCategoryId) {
        this.mealCategoryId = mealCategoryId;
    }
}
