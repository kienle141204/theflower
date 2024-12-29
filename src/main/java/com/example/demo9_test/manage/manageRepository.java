package com.example.demo9_test.manage;

import com.example.demo9_test.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class manageRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void update(int id, String name, String description, int price) {
        String sql = "update products set description = ?, price=? where id = ?";
        jdbcTemplate.update(sql, description, price, id);
    }

    public void add(String name, String description, int price, String image_url) {
        String sql = "insert into products (name, description, price, image_url, quantity) values (?, ?, ?, ?,1)";
        jdbcTemplate.update(sql, name, description, price, image_url);
    }

    public List<Map<String, Object>> getAllOrders() {
        // Truy vấn SQL để lấy tất cả đơn hàng
        String sql = "SELECT id, user_name, address, phone_number, products,`time`, total, note FROM `order`";

        return jdbcTemplate.queryForList(sql);
    }

}
