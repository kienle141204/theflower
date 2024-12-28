package com.example.demo9_test.repository;

import com.example.demo9_test.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //cart_id == user_id
    public void addProduct2Cart(int cart_id, int product_id, int quantity) {
        String sql = "insert into cart_item(cart_id,product_id,quantity) values(?,?,?)";
        jdbcTemplate.update(sql, cart_id, product_id, quantity);
    }


    public List<Product> getData4Cart(Integer user_id){
        String sql = "SELECT p.id, p.name, p.price, p.image_url, p.description, p.quantity " +
                "FROM products p " +
                "JOIN cart_item ci ON p.id = ci.product_id " +
                "WHERE ci.cart_id=?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class), user_id);
    }
    public void removeProduct(Integer product_id, Integer user_id) {
        String sql = "DELETE FROM cart_item WHERE product_id=? AND cart_id=?";
        jdbcTemplate.update(sql, product_id, user_id);
    }
}

