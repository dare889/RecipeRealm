package com.foodie.recipeservice.dto;

public class RecipeDto {
    private String id;
    private String name; // 食譜名稱
    private String description; // 簡短描述
    private String ingredients; // 主要成分，可以擴展為List或其他結構
    private String instructions; // 烹飪指南

    // 標準的getters和setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    // 根據需要可以添加hashCode, equals 和 toString 方法
}
