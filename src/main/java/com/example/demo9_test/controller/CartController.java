package com.example.demo9_test.controller;

import com.example.demo9_test.entity.Cart;
import com.example.demo9_test.entity.Product;
import com.example.demo9_test.repository.CartRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("api/cart/product")
    public List<Product> getCart(HttpSession session) {
        Integer user_id = (Integer) session.getAttribute("user_id");
        return cartRepository.getData4Cart(user_id);
    }

    @PostMapping("api/cart/product/remove")
    public void removeProduct(HttpSession session, @RequestParam("product_id") Integer product_id) {
        Integer user_id = (Integer) session.getAttribute("user_id");
        cartRepository.removeProduct(product_id, user_id);
    }
}
