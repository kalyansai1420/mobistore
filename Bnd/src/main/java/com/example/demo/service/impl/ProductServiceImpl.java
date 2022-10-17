package com.example.demo.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ecommerce.Category;
import com.example.demo.model.ecommerce.Product;
import com.example.demo.repo.ProductRepository;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product addProduct(Product product) {
		return this.productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		return this.productRepository.save(product);
	}

	@Override
	public Set<Product> getProducts() {
		return new HashSet<>(this.productRepository.findAll());
	}

	@Override
	public Product getProduct(Long productId) {
		return this.productRepository.findById(productId).get();
	}

	@Override
	public void deleteProduct(Long productId) {
		Product product = new Product();
		product.setPid(productId);
		this.productRepository.delete(product);
	}

	@Override
	public List<Product> getProductOfCategory(Category category) {
		return this.productRepository.findByCategory(category);
	}

}
