package org.example.recette_springboot.service;

import org.example.recette_springboot.model.Category;
import org.example.recette_springboot.model.Recipe;

import java.util.List;

public interface ICategoryService {

    List<Category> getALLCategories();

    Category getCategoryByName(String name);

    Category getCategoryById(int id);

    Category saveCategory(Category category);

    void deleteCategoryById(int id);

    Category updateCategory(Category category);
}
