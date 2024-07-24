package org.example.recette_springboot.service;

import org.example.recette_springboot.model.Category;
import org.example.recette_springboot.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService implements ICategoryService {

    private static int count = 0;
    private final Map<Integer, Category> categories;

    public CategoryService() {
        categories = new HashMap<>();

        Category category1 = Category.builder()
                .id(++count)
                .name("fast-food")
                .description("de la nourriture rapide à manger et baigné dans de l'huile...")
                .build();

        Category category2 = Category.builder()
                .id(++count)
                .name("vegan")
                .description("basé sur des légumes et fruits, la protéine se situe dans les légumes")
                .build();

        Category category3 = Category.builder()
                .id(++count)
                .name("italien")
                .description("recette basé sur les secrets des famille italienne")
                .build();



        categories.put(category1.getId(), category1);
        categories.put(category2.getId(), category2);
        categories.put(category3.getId(), category3);
    }
    public List<Category> getALLCategories() {
        return categories.values().stream().toList();
    }

    public Category getCategoryById(int id) {
        return categories.values().stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }
    public Category saveCategory(Category category) {
        category.setId(++count);
        categories.put(category.getId(), category);
        return category;
    }
    public void deleteCategoryById(int id) {
        categories.remove(id);
    }
    public Category updateCategory(Category category) {
        getCategoryById(category.getId()).setId(category.getId());
        getCategoryById(category.getId()).setName(category.getName());
        getCategoryById(category.getId()).setDescription(category.getDescription());

        return category;
    }
}
