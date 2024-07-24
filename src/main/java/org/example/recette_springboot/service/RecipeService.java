package org.example.recette_springboot.service;

import org.example.recette_springboot.model.Category;
import org.example.recette_springboot.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecipeService implements IRecipeService {


    private static int count = 0;
    private final Map<Integer, Recipe> recipes;
    private final CategoryService categoryService;

    public RecipeService(CategoryService categoryService) {
        recipes = new HashMap<>();

        Recipe recipe1 = Recipe.builder()
                .id(++count)
                .name("Fondue de poireaux")
                .ingredients("poireux, creme,moutarde")
                .instructions("bien cuire les poireaux, les couper....")
                .category(categoryService.getALLCategories().get(0))
                .build();

        Recipe recipe2 = Recipe.builder()
                .id(++count)
                .name("salade de tomate")
                .ingredients("tomate,ail,mozzarella,moutarde")
                .instructions("couper les tomates....")
                .category(categoryService.getALLCategories().get(1))
                .build();

        Recipe recipe3 = Recipe.builder()
                .id(++count)
                .name("burger")
                .ingredients("pain,salade,steack,cheddar")
                .instructions("couper les oignons,cuire le steack,faire chauffer....")
                .category(categoryService.getALLCategories().get(2))
                .build();

        recipes.put(recipe1.getId(), recipe1);
        recipes.put(recipe2.getId(), recipe2);
        recipes.put(recipe3.getId(), recipe3);
        this.categoryService = categoryService;
    }
    public List<Recipe> getALLRecipes() {

        return recipes.values().stream().toList();
    }

    public Recipe getRecipeById(int id) {
        return recipes.values().stream().filter(r -> r.getId() == id).findFirst().orElse(null);
    }
    public Recipe saveRecipe(Recipe recipe) {
        recipe.setId(++count);
        recipes.put(recipe.getId(),recipe);
        return recipe;
    }
    public void deleteRecipeById(int id) {
        recipes.remove(id);
    }

    public Recipe updateRecipe(Recipe recipe) {
        getRecipeById(recipe.getId()).setId(recipe.getId());
        getRecipeById(recipe.getId()).setName(recipe.getName());
        getRecipeById(recipe.getId()).setIngredients(recipe.getIngredients());
        getRecipeById(recipe.getId()).setInstructions(recipe.getInstructions());
        getRecipeById(recipe.getId()).setCategory(recipe.getCategory());




        return recipe;
    }
}

