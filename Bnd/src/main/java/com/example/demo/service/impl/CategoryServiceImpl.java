package com.example.demo.service.impl;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CategoryDto;
import com.example.demo.helper.ResourceNotFoundException;
import com.example.demo.model.ecommerce.Category;
import com.example.demo.repo.CategoryRepository;
import com.example.demo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category category) {
		return this.categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(CategoryDto categoryDto) {

		Category category1 = new Category();
		category1.setCid(categoryDto.getCid());
		category1.setcTitle(categoryDto.getcTitle());
		category1.setcDescription(categoryDto.getcDescription());
		category1.setProducts(categoryDto.getProducts());
		return this.categoryRepository.save(category1);

	}

	@Override
	public Set<Category> getCategories() {
		return new LinkedHashSet<>(this.categoryRepository.findAll());
	}

	@Override
	public Category getCategory(Long categoryId) {
		Optional<Category> category = this.categoryRepository.findById(categoryId);
		if (category.isPresent()) {
			return category.get();
		} else {
			throw new ResourceNotFoundException("Category not found");
		}
	}

	@Override
	public void deleteCategory(Long categoryId) {
		Category category = new Category();
		category.setCid(categoryId);
		this.categoryRepository.delete(category);

	}

}
