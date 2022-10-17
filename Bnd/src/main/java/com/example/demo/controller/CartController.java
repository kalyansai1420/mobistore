package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.model.User;
import com.example.demo.model.ecommerce.Cart;
import com.example.demo.service.CartService;

@RestController
@RequestMapping("/cart")
@CrossOrigin("*")
public class CartController {

	@Autowired
	private CartService cartService;
	
	//add cart
	@PostMapping("/")
	public ResponseEntity<Cart> addCart(@RequestBody Cart cart){
		return ResponseEntity.ok(this.cartService.addCart(cart));
	}
	
	
	// get cart
	@GetMapping("/{cartId}")
	public Cart getCart(@PathVariable("cartId") Long cartId) {
		return this.cartService.getCart(cartId);
	}
	
	//get all carts
	@GetMapping("/")
	public ResponseEntity<?> getCarts(){
		return ResponseEntity.ok(this.cartService.getCarts());
	}
	
	//update cart
	@PutMapping("/")
	public Cart updateCart(@RequestBody Cart cart) {
		return this.cartService.updateCart(cart);
	}
	
	
	//delete cart
	@DeleteMapping("/{cartId}")
	public void deleteCart(@PathVariable("cartId") Long cartId) {
		this.cartService.deleteCart(cartId);
	}
	
	@GetMapping("/user/{id}")
	public List<Cart> getCartofUser(@PathVariable("id") Long id){
		 User user = new User();
		 user.setId(id);
		 return this.cartService.getCartofUser(user);
	}
}
