package com.project.blog.services;

import com.project.blog.payload.CategoryDto;

import java.util.List;

public interface CategoryService {

    // Create
    CategoryDto createCategory(CategoryDto categoryDto);

    // Update
    CategoryDto updateCategory (CategoryDto categoryDto, Integer categoryId);

    // Delete
    void deleteCategory(Integer categoryId);

    // Get
    CategoryDto getCategory(Integer categoryId);

    // Get all
    List<CategoryDto> getCategories();
}
