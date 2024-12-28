package com.example.demo9_test.controller;

import com.example.demo9_test.repository.CartRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @PostMapping("api/cart/add")
    public ResponseEntity<String> addCart(@RequestParam("product_id") int product_id,
                                  @RequestParam("quantity") Integer quantity,
                                          HttpSession session) {
        int cart_id = (int) session.getAttribute("user_id");
        cartRepository.addProduct2Cart(cart_id,product_id,quantity);
        return ResponseEntity.ok("ok");
    }
}
