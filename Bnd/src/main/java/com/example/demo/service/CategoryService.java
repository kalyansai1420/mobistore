package com.example.demo.service;

import java.util.Set;

import com.example.demo.model.ecommerce.Category;

public interface CategoryService {
	
	public Category addCategory(Category category);
	
	public Category updateCategory(Category category);
	public Set<Category> getCategories();
	public Category getCategory(Long categoryId);
	public void deleteCategory(Long categoryId);

}
