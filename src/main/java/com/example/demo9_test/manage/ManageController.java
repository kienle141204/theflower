package com.example.demo9_test.manage;

import com.example.demo9_test.entity.Product;
import com.example.demo9_test.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ManageController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/api/manage_00112299")
    public String shopManage() {
        return "manage_shop";
    }

    @GetMapping("/api/manage_00112299/add")
    public String addProduct() {
        return "manage_addProduct";
    }

    @GetMapping("/api/manage_00112299/{productId}")
    public String productManage(@PathVariable Long productId, Model model) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Sản phẩm không tồn tại"));
        model.addAttribute("manage_product", product);
        return "manage_product";
    }
}
