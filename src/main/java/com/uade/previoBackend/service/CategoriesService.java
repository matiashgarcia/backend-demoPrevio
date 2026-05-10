package com.uade.previoBackend.service;

import java.util.List;
import java.util.Optional;

import com.uade.previoBackend.entity.Category;

public interface CategoriesService {

    public List<Category> getCategories();

    public Optional<Category> getCategoryByID(Long categoryID);

    public Category createCategory(String description);

}
