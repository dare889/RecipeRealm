package com.foodie.recipeservice.repository;

import com.foodie.recipeservice.model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecipeRepository extends MongoRepository<Recipe, String> {
    // 自定義查詢方法 (如果需要) 可以在這裡添加
    // 例如:
    // List<Recipe> findByNameContaining(String name);
}
