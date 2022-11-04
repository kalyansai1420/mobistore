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

import com.example.demo.dto.ProductDto;
import com.example.demo.model.ecommerce.Category;
import com.example.demo.model.ecommerce.Product;
import com.example.demo.service.ProductService;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;

    // add product
    @PostMapping("/")
    public ResponseEntity<Product> addProduct(@RequestBody ProductDto productDto) {
        Product product = new Product();
        product.setPid(productDto.getPid());
        product.setpName(productDto.getpName());
        product.setpDescription(productDto.getpDescription());
        product.setpPhoto(productDto.getpPhoto());
        product.setpPrice(productDto.getpPrice());
        product.setCategory(productDto.getCategory());
        product.setCarts(productDto.getCarts());

        return ResponseEntity.ok(this.productService.addProduct(product));
    }

    // get product
    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable("productId") Long productId) {
        return this.productService.getProduct(productId);
    }

    // get all products
    @GetMapping("/")
    public Set<Product> getProducts() {
        return this.productService.getProducts();
    }

    // update product
    @PutMapping("/")
    public Product updateProduct(@RequestBody ProductDto productDto) {
        return this.productService.updateProduct(productDto);
    }

    // delete product
    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId) {
        this.productService.deleteProduct(productId);
    }

    @GetMapping("/category/{cid}")
    public List<Product> getProductOfCategory(@PathVariable("cid") Long cid) {
        Category category = new Category();
        category.setCid(cid);
        return this.productService.getProductOfCategory(category);
    }

}
