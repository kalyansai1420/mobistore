package com.example.demo.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.model.ecommerce.Cart;
import com.example.demo.repo.CartRepository;
import com.example.demo.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public Cart addCart(Cart cart) {
		return this.cartRepository.save(cart);
	}

	@Override
	public Cart updateCart(Cart cart) {
		return this.cartRepository.save(cart);
	}

	@Override
	public Set<Cart> getCarts() {
		return new HashSet<>(this.cartRepository.findAll());
	}

	@Override
	public Cart getCart(Long cartId) {
		return this.cartRepository.findById(cartId).get();
	}

	@Override
	public void deleteCart(Long cartId) {
		Cart cart = new Cart();
		cart.setCartId(cartId);
		this.cartRepository.delete(cart);
	}

	@Override
	public List<Cart> getCartofUser(User user) {
		return this.cartRepository.findByUser(user);
	}
	
	
	

}
