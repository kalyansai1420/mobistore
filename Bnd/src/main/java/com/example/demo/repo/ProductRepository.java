package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ecommerce.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
