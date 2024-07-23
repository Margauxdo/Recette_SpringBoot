package org.example.recette_springboot.controller;

import jakarta.validation.Valid;
import org.example.recette_springboot.model.Category;
import org.example.recette_springboot.service.ICategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public String categoryList(Model model) {
        List<Category> categories = categoryService.getALLCategories();
        model.addAttribute("categories", categories);
        return "category";
    }
    @GetMapping("/add")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "formCategory";
    }
    @PostMapping("/add")
    public String addCategory(@Valid  @ModelAttribute("category") Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formCategory";
        }else {
            categoryService.saveCategory(category);
            return "redirect:/category/list";
        }
    }
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable int id) {
        categoryService.deleteCategoryById(id);
        return "redirect:/category/list";
    }
    @GetMapping("/update/{id}")
    public String updateCategory(@PathVariable int id, Model model) {
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        return "formCategory";
    }
    @PostMapping("/update/{id}")
    public String updateCategory(@ModelAttribute("category") Category category) {
        categoryService.updateCategory(category);
        return "redirect:/category/list";
    }
    @GetMapping("/pb")
    public String pb(){
        if (true) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT);
        }
        return "redirect:/category/list";
    }
}
