package com.project4x.project4x.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project4x.project4x.entity.MealItem;

public interface MealItemRepository extends JpaRepository<MealItem, Long> {
}