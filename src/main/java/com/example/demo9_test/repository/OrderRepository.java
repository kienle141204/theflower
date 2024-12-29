package com.example.demo9_test.repository;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class OrderRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getOrders(int user_id) {

        String sql = "SELECT id, user_name, address, phone_number, products,`time`, total, note FROM `order` WHERE user_id=?";

        return jdbcTemplate.queryForList(sql, user_id);
    }
}
