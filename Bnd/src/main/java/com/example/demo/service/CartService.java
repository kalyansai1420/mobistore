package com.example.demo.service;

import java.util.List;
import java.util.Set;

import com.example.demo.model.User;
import com.example.demo.model.ecommerce.Cart;

public interface CartService {

	public Cart addCart(Cart cart);
	
	public Cart updateCart(Cart cart);
	
	public Set<Cart> getCarts();
	
	public Cart getCart(Long cartId);
	
	public void deleteCart(Long cartId);
	
	public List<Cart> getCartofUser(User user);

	// public void deleteCartOfUser(Long userId);
	
}
