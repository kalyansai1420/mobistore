package com.example.demo.controller;

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

import com.example.demo.model.ecommerce.Category;
import com.example.demo.model.ecommerce.Product;
import com.example.demo.service.ProductService;
import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;

    // add product
    @PostMapping("/")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(this.productService.addProduct(product));
    }

    // get product
    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable("productId") Long productId) {
        return this.productService.getProduct(productId);
    }

    // get all products
    @GetMapping("/")
    public ResponseEntity<?> getProducts() {
        return ResponseEntity.ok(this.productService.getProducts());
    }

    // update product
    @PutMapping("/")
    public Product updateProduct(@RequestBody Product product) {
        return this.productService.updateProduct(product);
    }

    // delete product
    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable("productId") Long ProductId) {
        this.productService.deleteProduct(ProductId);
    }

    @GetMapping("/category/{cid}")
    public List<Product> getProductOfCategory(@PathVariable("cid") Long cid) {
        Category category = new Category();
        category.setCid(cid);
        return this.productService.getProductOfCategory(category);
    }

    // @GetMapping("/cart/{id}")
    // public List<Product> getProductsOfCart(@PathVariable("id") Long id) {
    //     Cart cart = new Cart();
    //     cart.setCartId(id);
    //     return this.productService.getProductOfCart(cart);
    // }

}
