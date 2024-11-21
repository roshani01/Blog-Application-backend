package com.dl.blog_app.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoryDto {
	
	private int categoryId;
	
	@NotBlank
	@Size(min = 4 ,message="min size of title is 4")
	private String categoryTitle;
	@NotBlank
	@Size(min=10,message="min size of des is 10")
	private String categoryDescription;

	// Constructor with parameters
	public CategoryDto(int categoryId, String categoryTitle, String categoryDescription) {
		this.categoryId = categoryId;
		this.categoryTitle = categoryTitle;
		this.categoryDescription = categoryDescription;
	}
	
	// Default constructor
	public CategoryDto() {
	}

	// Getters and setters
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
}
