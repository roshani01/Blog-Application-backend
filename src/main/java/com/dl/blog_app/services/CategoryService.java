package com.dl.blog_app.services;

import com.dl.blog_app.payload.CategoryDto;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public interface CategoryService {
    
    // Create a new category
    CategoryDto createCategory(CategoryDto categoryDto);

    // Update an existing category
    CategoryDto updateCategory(CategoryDto categoryDto, int categoryId);

    // Delete a category by ID
    void deleteCategory(int categoryId);

    // Get a category by ID
    CategoryDto getCategoryById(int categoryId);

    // Get all categories
    List<CategoryDto> getAllCategories();
}
