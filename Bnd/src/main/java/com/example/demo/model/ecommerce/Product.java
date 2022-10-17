package com.example.demo.model.ecommerce;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pid;
	private String pName;
	private String pDescription;
	private String pPhoto;
	private String pPrice;
	
	@JoinColumn(name = "cid")
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;
	
	
	 @JsonIgnore
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private Set<Cart> carts = new HashSet<>();
	
	public Set<Cart> getCarts() {
		return carts;
	}
	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}
	public Product() {
		super();
	}
	public Product(Long pid, String pName, String pDescription, String pPhoto, String pPrice) {
		super();
		this.pid = pid;
		this.pName = pName;
		this.pDescription = pDescription;
		this.pPhoto = pPhoto;
		this.pPrice = pPrice;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpDescription() {
		return pDescription;
	}
	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}
	public String getpPhoto() {
		return pPhoto;
	}
	public void setpPhoto(String pPhoto) {
		this.pPhoto = pPhoto;
	}
	public String getpPrice() {
		return pPrice;
	}
	public void setpPrice(String pPrice) {
		this.pPrice = pPrice;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}
