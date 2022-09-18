package com.example.demo.service;

import java.util.List;
import java.util.Set;

import com.example.demo.model.ecommerce.Category;
import com.example.demo.model.ecommerce.Product;

public interface ProductService {
	
	public Product addProduct(Product product);
	
	public Product updateProduct(Product product);
	
	public Set<Product> getProducts();
	
	public Product getProduct(Long productId);
	
	public void deleteProduct(Long productId);
	
	public List<Product> getProductOfCategory(Category category);
	

}
