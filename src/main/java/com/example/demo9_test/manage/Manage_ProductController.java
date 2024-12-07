package com.example.demo9_test.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Manage_ProductController {
    @Autowired
    private manageRepository productManageRepository;

    @PostMapping("/api/manage_00112299/update")
    public ResponseEntity<String> updateProduct( @RequestParam int id,
                                                @RequestParam String name,
                                                @RequestParam int price,
                                                @RequestParam String description) {
        productManageRepository.update(id ,name, description, price);
        return ResponseEntity.ok("Cập nhật thành công!");
    }
}
