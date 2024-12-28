package com.example.demo9_test.repository;


import com.example.demo9_test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //cart_id == user_id
    public void addProduct2Cart(int cart_id, int product_id, int quantity) {
        String sql = "insert into cart_item(cart_id,product_id,quantity) values(?,?,?)";
        jdbcTemplate.update(sql, cart_id, product_id, quantity);
    }

}

