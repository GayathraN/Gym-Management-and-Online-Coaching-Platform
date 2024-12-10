package com.project4x.project4x.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project4x.project4x.entity.MealCategory;
import com.project4x.project4x.entity.MealItem;
import com.project4x.project4x.repository.MealCategoryRepository;
import com.project4x.project4x.repository.MealItemRepository;

@Service
public class MealCategoryService {
    @Autowired
    private MealCategoryRepository mealCategoryRepository;

    @Autowired
    private MealItemRepository mealItemRepository;

    // get member meal categories and regarding meal items
    public List<MealCategoryDetails> getMealCategories() {
        var allMealItems = mealItemRepository.findAll();

        return mealCategoryRepository.findAll()
                .stream().map(mealCategory -> {
                    var mealCategoryDetails = new MealCategoryDetails(mealCategory.getId(), mealCategory.getName());
                    var mealItems = allMealItems
                            .stream()
                            .filter(mealItem -> mealItem.getMealCategoryId() == mealCategoryDetails.getId())
                            .toList();
                    mealCategoryDetails.setMealItems(mealItems);

                    return mealCategoryDetails;
                }).collect(Collectors.toList());
    }

    public static class MealCategoryDetails extends MealCategory {
        public MealCategoryDetails(Long id, String name) {
            super(id, name);
        }

        private List<MealItem> mealItems;

        public List<MealItem> getMealItems() {
            return mealItems;
        }

        public void setMealItems(List<MealItem> mealItems) {
            this.mealItems = mealItems;
        }
    }
}
