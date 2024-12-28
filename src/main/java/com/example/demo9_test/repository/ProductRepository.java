package com.example.demo9_test.repository;

import com.example.demo9_test.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);
    // Tìm kiếm sản phẩm theo tên (chứa chuỗi tìm kiếm, không phân biệt chữ hoa/thường)
    List<Product> findByNameContainingIgnoreCase(String name);
}
