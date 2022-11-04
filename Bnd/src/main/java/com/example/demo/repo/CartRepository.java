package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;
import com.example.demo.model.ecommerce.Cart;

public interface CartRepository extends JpaRepository<Cart,Long> {
	
	public List<Cart> findByUser(User user);

	public void deleteByUser(Cart cart);






}
