package com.uade.demoPrevio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uade.demoPrevio.entity.Category;
import com.uade.demoPrevio.exceptions.CategoryDuplicateException;
import com.uade.demoPrevio.repository.CategoriesRepository;

@Service
public class CategoriesServiceImpl implements CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public List<Category> getCategories() {
        return categoriesRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryByID(Long categoryID) {
        return categoriesRepository.findById(categoryID);
    }

    @Override
    public Category createCategory(String description) {
        List<Category> categories = categoriesRepository.findAll();
        if (categories.stream().anyMatch(
                category -> category.getDescription().equals(description)))
            throw new CategoryDuplicateException();
        return categoriesRepository.save(new Category(description));
    }

}
