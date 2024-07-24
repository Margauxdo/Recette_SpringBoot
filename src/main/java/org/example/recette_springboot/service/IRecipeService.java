package org.example.recette_springboot.service;


import org.example.recette_springboot.model.Recipe;

import java.util.List;

public interface IRecipeService {

    List<Recipe> getALLRecipes();


    Recipe getRecipeById(int id);

    Recipe saveRecipe(Recipe recipe);

    void deleteRecipeById(int id);

    Recipe updateRecipe(Recipe recipe);


}
