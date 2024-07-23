package org.example.recette_springboot.service;

import org.example.recette_springboot.model.Category;
import org.example.recette_springboot.model.Recipe;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeService implements IRecipeService {

    private static int count = 0;
    private final Map<String, Recipe> recipes;

    public RecipeService() {
        recipes = new HashMap<>();

        Recipe recipe1 = Recipe.builder()
                .id(++count)
                .name("Fondue de poireaux")
                .ingredients(Collections.singletonList("poireux, creme,moutarde"))
                .instructions("bien cuire les poireaux, les couper....")
                .category(Category.builder().build())
                .build();

        Recipe recipe2 = Recipe.builder()
                .id(++count)
                .name("salade de tomate")
                .ingredients(Collections.singletonList("tomate,ail,mozzarella,moutarde"))
                .instructions("couper les tomates....")
                .category(Category.builder().build())
                .build();

        Recipe recipe3 = Recipe.builder()
                .id(++count)
                .name("burger")
                .ingredients(Collections.singletonList("pain,salade,steack,cheddar"))
                .instructions("couper les oignons,cuire le steack,faire chauffer....")
                .category(Category.builder().build())
                .build();

        recipes.put("Fondue de poireaux", recipe1);
        recipes.put("salade de tomate", recipe2);
        recipes.put("burger", recipe3);
    }
    public List<Recipe> getALLRecipes() {
        return recipes.values().stream().toList();
    }
    public Recipe getRecipeByName(String name) {
        return recipes.values().stream().filter(r -> r.getName().contains(name.toUpperCase())).findFirst().orElse(null);
    }
    public Recipe getRecipeById(int id) {
        return recipes.values().stream().filter(r -> r.getId() == id).findFirst().orElse(null);
    }
    public Recipe saveRecipe(Recipe recipe) {
        recipe.setId(++count);
        recipes.put(String.valueOf(recipe.getId()),recipe);
        return recipe;
    }
    public void deleteRecipeById(int id) {
        recipes.remove(id);
    }
    public Recipe updateRecipe(Recipe recipe) {
        getRecipeByName(recipe.getName()).setId(recipe.getId());
        getRecipeById(recipe.getId()).setName(recipe.getName());
        getRecipeById(recipe.getId()).setIngredients(recipe.getIngredients());
        getRecipeById(recipe.getId()).setInstructions(recipe.getInstructions());
        getRecipeById(recipe.getId()).setCategory(recipe.getCategory());




        return recipe;
    }
}
