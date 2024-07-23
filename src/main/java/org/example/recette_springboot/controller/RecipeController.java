package org.example.recette_springboot.controller;


import jakarta.validation.Valid;
import org.example.recette_springboot.model.Recipe;
import org.example.recette_springboot.service.IRecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/recipe")
public class RecipeController {
    private final IRecipeService recipeService;

    public RecipeController(IRecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/list")
    private String recipeList(Model model) {
        List<Recipe> recipes = recipeService.getALLRecipes();
        model.addAttribute("recipes", recipes);
        return "recipes";
    }
    @GetMapping("/add")
    public String addRecipe(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "formRecipe";
    }
    @PostMapping("/add")
    public String addRecipe(@Valid  @ModelAttribute("recipe") Recipe recipe, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "formRecipe";
        }else {
            recipeService.saveRecipe(recipe);
            return "redirect:/recipe/list";
        }
    }

}
