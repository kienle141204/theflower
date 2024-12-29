package com.example.demo9_test.controller;

import com.example.demo9_test.entity.Product;
import com.example.demo9_test.repository.shopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products/shop")
public class ShopController {

    @Autowired
    private shopRepository shopRepository;
    @GetMapping("/shop_all")
    public List<Product> getAllProducts() {
        return shopRepository.findAll();
    }

    @GetMapping("/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return shopRepository.getData(category);
    }

    @GetMapping("/sale_out/{name}")
    public List<Product> saleOutProduct(@PathVariable String name) {
        shopRepository.saleOutProduct(name);
        return shopRepository.findAll();
    }

    @GetMapping("/re_stock/{name}")
    public List<Product> reStockProduct(@PathVariable String name) {
        shopRepository.reStockProduct(name);
        return shopRepository.findAll();
    }

    @GetMapping("/delete/{name}")
    public List<Product> deleteProduct(@PathVariable String name) {
        shopRepository.deleteProduct(name);
        return shopRepository.findAll();
    }

}

