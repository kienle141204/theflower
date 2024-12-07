package com.example.demo9_test.controller;

import com.example.demo9_test.entity.Product;
import com.example.demo9_test.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController
{
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/home")
    public String home() {
        return "home_page";
    }

    @GetMapping({"/shop", "/shop/plants", "/shop/mixed_bouquets", "/shop/christmas", "/shop/one_of_aKind", "/shop/seasonal", "/shop/special_occasion", "/shop/food_drinks"})
    public String shop() {
        return "shop";
    }



    @GetMapping("/store")
    public String ourStores() {
        return "store";
    }

    @GetMapping("/contact")
    public String Contact() {
        return "contact_page";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

//    @GetMapping("/products") // Trả về trang HTML khi truy cập /products
//    public String showProductPage() {
//        return "test"; // Tên của view (file HTML trong thư mục templates)
//    }

    @RequestMapping ("/buy/{productId}")
    public String showProductDetails(@PathVariable("productId") Long productId, Model model) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Sản phẩm không tồn tại"));
        model.addAttribute("product", product);
        return "product"; // Trang chi tiết sản phẩm
    }




}