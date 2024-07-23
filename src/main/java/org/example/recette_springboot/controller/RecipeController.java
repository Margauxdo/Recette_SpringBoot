package org.example.recette_springboot.controller;

import org.example.recette_springboot.service.IRecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class RecipeController {
    private final IRecipeService recipeService;

    public RecipeController(IRecipeService recipeService) {
        this.recipeService = recipeService;
    }

}
