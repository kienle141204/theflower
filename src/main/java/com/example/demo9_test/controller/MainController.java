package com.example.demo9_test.controller;

import com.example.demo9_test.entity.Product;
import com.example.demo9_test.repository.ProductRepository;
import jakarta.servlet.http.HttpSession;
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

    @GetMapping({"/shop", "/shop/plants", "/shop/mixed_bouquets", "/shop/christmas", "/shop/one_of_a_kind", "/shop/seasonal", "/shop/special_occasion", "/shop/food_drinks"})
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


    @GetMapping("/test") // Trả về trang HTML khi truy cập /products
    public String test() {
        return "test"; // Tên của view (file HTML trong thư mục templates)
    }

    @GetMapping ("/buy/{productId}")
    public String showProductDetails(@PathVariable("productId") Long productId, Model model, HttpSession session) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Sản phẩm không tồn tại"));
        model.addAttribute("product", product);

        String userName = (String) session.getAttribute("user_name");
        String phoneNumber = (String) session.getAttribute("phone_number");
        String address = (String) session.getAttribute("address");

        model.addAttribute("user_name", userName);
        model.addAttribute("phone_number", phoneNumber);
        model.addAttribute("address", address);
        return "product";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/forgot-pw")
    public String forgotPassword() {
        return "forgot_password";
    }

    @GetMapping("/cart")
    public String cart(Model model, HttpSession session) {
        String userName = (String) session.getAttribute("user_name");
        String phoneNumber = (String) session.getAttribute("phone_number");
        String address = (String) session.getAttribute("address");

        model.addAttribute("user_name", userName);
        model.addAttribute("phone_number", phoneNumber);
        model.addAttribute("address", address);
        return "cart";
    }

    @GetMapping("/profile")
    public String profile(Model model, HttpSession session) {
        String userName = (String) session.getAttribute("user_name");
        String phoneNumber = (String) session.getAttribute("phone_number");
        String address = (String) session.getAttribute("address");

        model.addAttribute("user_name", userName);
        model.addAttribute("phone_number", phoneNumber);
        model.addAttribute("address", address);
        return "profile";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "/login";
    }

}