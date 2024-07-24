package org.example.recette_springboot.controller;


import jakarta.validation.Valid;
import org.example.recette_springboot.model.Recipe;
import org.example.recette_springboot.service.IRecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        model.addAttribute("categories", recipeService.getAllCategories());
        return "formRecipe";
    }
    @PostMapping("/add")
    public String addRecipe(@Valid  @ModelAttribute("recipe") Recipe recipe, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", recipeService.getAllCategories());

            return "formRecipe";
        }else {
            recipeService.saveRecipe(recipe);
            return "redirect:/recipe/list";
        }
    }
    @GetMapping("/delete/{id}")
    public String deleteRecipe(@PathVariable int id) {
        recipeService.deleteRecipeById(id);
        return "redirect:/recipe/list";
    }
    @GetMapping("/update/{id}")
    public String updateRecipe(@PathVariable int id, Model model) {
        Recipe recipe = recipeService.getRecipeById(id);
        model.addAttribute("recipe", recipe);
        model.addAttribute("categories", recipeService.getAllCategories());

        return "formRecipe";
    }
    @PostMapping("/update/{id}")
    public String updateRecipe(@ModelAttribute("recipe") Recipe recipe ) {
        recipeService.updateRecipe(recipe);
        return "redirect:/recipe/list";
    }
    @GetMapping("/pb")
    public String pb(){
        if (true) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT);
        }
        return "redirect:/recipe/list";
    }

}
