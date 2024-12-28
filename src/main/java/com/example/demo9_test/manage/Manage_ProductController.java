package com.example.demo9_test.manage;

import com.example.demo9_test.controller.ShopController;
import com.example.demo9_test.entity.Product;
import com.example.demo9_test.repository.ProductRepository;
import com.example.demo9_test.repository.shopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class Manage_ProductController {
    @Autowired
    private manageRepository productManageRepository;

    @Autowired
    private shopRepository shopRepository;

    @PostMapping("/api/manage_00112299/update")
    public ResponseEntity<String> updateProduct(@RequestParam int id,
                                                @RequestParam String name,
                                                @RequestParam int price,
                                                @RequestParam String description) {
        productManageRepository.update(id ,name, description, price);
        return ResponseEntity.ok("Cập nhật thành công!");
    }
//
    @PostMapping("/api/manage_00112299/add")
    public ResponseEntity<String> addProduct(@RequestParam("name") String name,
                                                @RequestParam("price") int price ,
                                                @RequestParam("description") String description,
                                                @RequestParam("image") MultipartFile image) throws IOException {
        String upload_url = "E:/code/demo9_test/src/main/resources/static/image/flowers";
        String filePath = upload_url + image.getOriginalFilename();
        image.transferTo(new File(filePath));

        filePath = "/image/flowers/" + image.getOriginalFilename();

        productManageRepository.add(name, description, price, filePath);
        return ResponseEntity.ok("Cập nhật thành công!");
    }

    @GetMapping("/api/manage_00112299/products/sale_out/{name}")
    public List<Product> saleOutProduct(@PathVariable String name) {
        shopRepository.saleOutProduct(name);
        return shopRepository.findAll();
    }

    @GetMapping("/api/manage_00112299/products/re_stock/{name}")
    public List<Product> reStockProduct(@PathVariable String name) {
        shopRepository.reStockProduct(name);
        return shopRepository.findAll();
    }

    @GetMapping("/api/manage_00112299/products/delete/{name}")
    public List<Product> deleteProduct(@PathVariable String name) {
        shopRepository.deleteProduct(name);
        return shopRepository.findAll();
    }
}
