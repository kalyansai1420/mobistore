package com.example.demo.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.ecommerce.Category;
import com.example.demo.repo.CategoryRepository;
import com.example.demo.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepository.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(this.categoryRepository.findAll());
	}

	@Override
	public Category getCategory(Long categoryId) {
		// TODO Auto-generated method stub
		return this.categoryRepository.findById(categoryId).get();
	}

	@Override
	public void deleteCategory(Long categoryId) {
		// TODO Auto-generated method stub
		Category category = new Category();
		category.setCid(categoryId);
		this.categoryRepository.delete(category);
		
	}

}
