package com.example.demo.dto;

import java.util.HashSet;
import java.util.Set;

import com.example.demo.model.User;
import com.example.demo.model.ecommerce.Product;

public class CategoryDto {
    private Long cid;
    private String cTitle;
    private String cDescription;
    private Set<Product> products = new HashSet<>();
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
