package org.example.recette_springboot.controller;

import jakarta.validation.Valid;
import org.example.recette_springboot.model.Category;
import org.example.recette_springboot.service.ICategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {
    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/listcategory")
    public String categoryList(Model model) {
        List<Category> categories = categoryService.getALLCategories();
        model.addAttribute("categories", categories);
        return "category";
    }
    @GetMapping("/addcategory")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "formCategory";
    }
    @PostMapping("/addcategory")
    public String addCategory(@Valid  @ModelAttribute("category") Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formCategory";
        }else {
            categoryService.saveCategory(category);
            return "redirect:/listcategory";
        }
    }
    @GetMapping("/deletecategory/{id}")
    public String deleteCategory(@PathVariable int id) {
        categoryService.deleteCategoryById(id);
        return "redirect:/listcategory";
    }
    @GetMapping("/updatecategory/{id}")
    public String updateCategory(@PathVariable int id, Model model) {
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        return "formCategory";
    }
    @PostMapping("/updatecategory/{id}")
    public String updateCategory(@ModelAttribute("category") Category category) {
        categoryService.updateCategory(category);
        return "redirect:/listcategory";
    }
}
