package com.example.demo.model.ecommerce;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cid;
	private String cTitle;
	private String cDescription;
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Product> products = new HashSet<>();

	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(Long cid, String cTitle, String cDescription) {
		super();
		this.cid = cid;
		this.cTitle = cTitle;
		this.cDescription = cDescription;
	}
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public String getcTitle() {
		return cTitle;
	}
	public void setcTitle(String cTitle) {
		this.cTitle = cTitle;
	}
	public String getcDescription() {
		return cDescription;
	}
	public void setcDescription(String cDescription) {
		this.cDescription = cDescription;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
	
	
}
