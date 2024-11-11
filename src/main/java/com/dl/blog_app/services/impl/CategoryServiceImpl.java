package com.dl.blog_app.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dl.blog_app.entities.Category;
import com.dl.blog_app.exception.ResourceNotFoundException;
import com.dl.blog_app.payload.CategoryDto;
import com.dl.blog_app.repository.CategoryRepo;
import com.dl.blog_app.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    // Create a new category
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category cat = this.modelMapper.map(categoryDto, Category.class);
        Category addedCat = this.categoryRepo.save(cat);
        return this.modelMapper.map(addedCat, CategoryDto.class);
    }

    // Update an existing category
    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, int categoryId) {
        // Find the existing category or throw an exception if not found
        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));

        // Update the category fields with values from categoryDto
        cat.setCategoryTitle(categoryDto.getCategoryTitle());
        cat.setCategoryDescription(categoryDto.getCategoryDescription());

        // Save the updated category
        Category updatedCat = this.categoryRepo.save(cat);

        // Convert the updated Category entity back to a CategoryDto
        return this.modelMapper.map(updatedCat, CategoryDto.class);
    }

    // Delete a category by ID
    @Override
    public void deleteCategory(int categoryId) {
        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));
        this.categoryRepo.delete(cat);
    }

    // Get a category by ID
    @Override
    public CategoryDto getCategoryById(int categoryId) {
        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));
        return this.modelMapper.map(cat, CategoryDto.class);
    }

    // Get all categories
    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = this.categoryRepo.findAll();
        return categories.stream()
                .map(cat -> this.modelMapper.map(cat, CategoryDto.class))
                .collect(Collectors.toList());
    }
}
