package com.example.demo.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CartDto;
import com.example.demo.model.User;
import com.example.demo.model.ecommerce.Cart;
import com.example.demo.service.CartService;

@RestController
@RequestMapping("/cart")
@CrossOrigin("*")
public class CartController {

	@Autowired
	private CartService cartService;

	// add cart
	@PostMapping("/")
	public ResponseEntity<Cart> addCart(@RequestBody CartDto cartDto) {
		Cart cart = new Cart();
		cart.setCartId(cartDto.getCartId());
		cart.setCount(cartDto.getCount());
		cart.setProduct(cartDto.getProduct());
		cart.setUser(cartDto.getUser());
		return ResponseEntity.ok(this.cartService.addCart(cart));
	}

	// get cart
	@GetMapping("/{cartId}")
	public Cart getCart(@PathVariable("cartId") Long cartId) {
		return this.cartService.getCart(cartId);
	}

	// get all carts
	@GetMapping("/")
	public Set<Cart> getCarts() {
		return this.cartService.getCarts();
	}

	// delete cart
	@DeleteMapping("/{cartId}")
	public void deleteCart(@PathVariable("cartId") Long cartId) {
		this.cartService.deleteCart(cartId);
	}

	@GetMapping("/user/{id}")
	public List<Cart> getCartofUser(@PathVariable("id") Long id) {
		User user = new User();
		user.setId(id);
		return this.cartService.getCartofUser(user);
	}

}
