package com.foodie.recipeservice.service;

import com.foodie.recipeservice.dto.RecipeDto;
import com.foodie.recipeservice.model.Recipe;
import com.foodie.recipeservice.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<RecipeDto> findAll() {
        return recipeRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<RecipeDto> findById(String id) {
        return recipeRepository.findById(id).map(this::convertToDto);
    }

    public RecipeDto create(RecipeDto recipeDto) {
        Recipe recipe = convertToEntity(recipeDto);
        Recipe savedRecipe = recipeRepository.save(recipe);
        return convertToDto(savedRecipe);
    }

    public RecipeDto update(String id, RecipeDto recipeDto) {
        if(recipeRepository.existsById(id)) {
            Recipe updatedRecipe = convertToEntity(recipeDto);
            updatedRecipe.setId(id); // ensure the ID is set to avoid creating a new record
            return convertToDto(recipeRepository.save(updatedRecipe));
        }
        // Handle the not found case, perhaps throw an exception or return Optional
        return null;
    }

    public void delete(String id) {
        recipeRepository.deleteById(id);
    }

    private RecipeDto convertToDto(Recipe recipe) {
        // Logic to convert Recipe entity to RecipeDto
        RecipeDto dto = new RecipeDto();
        dto.setId(recipe.getId());
        dto.setName(recipe.getName());
        dto.setDescription(recipe.getDescription());
        dto.setIngredients(recipe.getIngredients());
        dto.setInstructions(recipe.getInstructions());
        return dto;
    }

    private Recipe convertToEntity(RecipeDto recipeDto) {
        // Logic to convert RecipeDto to Recipe entity
        Recipe recipe = new Recipe();
        recipe.setId(recipeDto.getId());
        recipe.setName(recipeDto.getName());
        recipe.setDescription(recipeDto.getDescription());
        recipe.setIngredients(recipeDto.getIngredients());
        recipe.setInstructions(recipeDto.getInstructions());
        return recipe;
    }
}
