package com.example.demo9_test.controller;

import com.example.demo9_test.repository.ProductRepository;
import com.example.demo9_test.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/api/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/api/products/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("loi"));

        product.setDescription(product.getDescription().replace("\n", "<br>"));
        return ResponseEntity.ok(product);
    }

    // end point api tim kiem
    @GetMapping("/api/products/search")
    public List<Product> searchProducts(@RequestParam("query") String query) {
        return productRepository.findByNameContainingIgnoreCase(query);
    }


//    @GetMapping("/api/products/test1/{productId}")
//    public ResponseEntity<Product> test1(@PathVariable("productId") Long productId) {
//        Product product = productRepository.findById(productId)
//                .orElseThrow(() -> new RuntimeException("loi"));
//
//        // Chuyển đổi xuống dòng thành HTML nếu cần
//        product.setDescription(product.getDescription().replace("\n", "<br>"));
//        return ResponseEntity.ok(product);
//    }
}