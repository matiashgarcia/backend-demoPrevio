package com.uade.demoPrevio.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uade.demoPrevio.entity.Category;
import com.uade.demoPrevio.service.CategoriesService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/categories")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;

    @GetMapping("")
    public List<Category> getCategories() {
        return categoriesService.getCategories();
    }

    @GetMapping("/{categoryID}")
    public Optional<Category> getCategoryByID(@PathVariable Long categoryID) {
        return categoriesService.getCategoryByID(categoryID);
    }

    @PostMapping("")
    public Category createCategory(@RequestBody String description) {
        return categoriesService.createCategory(description);
    }
}
