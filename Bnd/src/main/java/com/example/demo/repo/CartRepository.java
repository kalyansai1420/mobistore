package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.User;
import com.example.demo.model.ecommerce.Cart;

public interface CartRepository extends JpaRepository<Cart,Long> {
	
	public List<Cart> findByUser(User user);

	// public void deleteByUser(User user);


	// @Query(value ="delete * from cart c where c.user_id:userId",nativeQuery =true)
	// public void deleteByUser(@Param("userId") long userId);

	public void deleteByUser(Cart cart);

	// @Modifying // to mark delete or update query
	// @Query(value = "DELETE * from cart e WHERE e.user_id = :userId") // it will delete all the record with specific
	// public void deleteByUserId(@Param("userId") Long userId);





}
