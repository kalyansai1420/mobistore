package com.example.demo.service;

import java.util.Set;

import com.example.demo.dto.CategoryDto;
import com.example.demo.model.ecommerce.Category;

public interface CategoryService {

	public Category addCategory(Category category);

	public Category updateCategory(CategoryDto categoryDto);

	public Set<Category> getCategories();

	public Category getCategory(Long categoryId);

	public void deleteCategory(Long categoryId);

}
