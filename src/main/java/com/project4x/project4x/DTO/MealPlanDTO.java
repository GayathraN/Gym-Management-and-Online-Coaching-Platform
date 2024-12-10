package com.project4x.project4x.DTO;

import lombok.Data;

@Data
public class MealPlanDTO {
    private Long memberId;

    private String amount;

    private String mealType;

    private Long mealItemId;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public Long getMealItemId() {
        return mealItemId;
    }

    public void setMealItemId(Long mealItemId) {
        this.mealItemId = mealItemId;
    }
}
