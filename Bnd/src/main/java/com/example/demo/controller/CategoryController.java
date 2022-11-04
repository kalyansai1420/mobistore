package com.example.demo.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CategoryService;
import com.example.demo.dto.CategoryDto;
import com.example.demo.model.ecommerce.Category;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	// add category
	@PostMapping("/")
	public ResponseEntity<Category> addCategory(@RequestBody CategoryDto categoryDto) {

		Category category1 = new Category();
		category1.setCid(categoryDto.getCid());
		category1.setcTitle(categoryDto.getcTitle());
		category1.setcDescription(categoryDto.getcDescription());
		category1.setProducts(categoryDto.getProducts());
		return ResponseEntity.ok(category1);
	}

	// get category
	@GetMapping("/{categoryId}")
	public Category getCategory(@PathVariable("categoryId") Long categoryId) {
		return this.categoryService.getCategory(categoryId);
	}

	// get all categories
	@GetMapping("/")
	public Set<Category> getCategories() {
		return this.categoryService.getCategories();
	}

	// update category
	@PutMapping("/")
	public Category updateCategory(@RequestBody CategoryDto categoryDto) {
		return this.categoryService.updateCategory(categoryDto);
	}

	// delete category
	@DeleteMapping("/{categoryId}")
	public void deleteCategory(@PathVariable("categoryId") Long categoryId) {
		this.categoryService.deleteCategory(categoryId);
	}

}