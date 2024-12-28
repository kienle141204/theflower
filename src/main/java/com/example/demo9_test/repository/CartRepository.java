package com.example.demo9_test.repository;

import com.example.demo9_test.entity.CartItem;
import com.example.demo9_test.entity.Product;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        String checkExistSql = "SELECT COUNT(*) FROM cart_item WHERE cart_id = ? AND product_id = ?";
        int count = jdbcTemplate.queryForObject(checkExistSql, Integer.class, cart_id, product_id);

        if (count > 0) {
            String updateQuantitySql = "UPDATE cart_item SET quantity = quantity + ? WHERE cart_id = ? AND product_id = ?";
            jdbcTemplate.update(updateQuantitySql, quantity, cart_id, product_id);
        } else {
            String insertSql = "INSERT INTO cart_item(cart_id, product_id, quantity) VALUES(?, ?, ?)";
            jdbcTemplate.update(insertSql, cart_id, product_id, quantity);
        }
    }



    public List<CartItem> getData4Cart(Integer user_id) {
        // Truy vấn lấy thông tin sản phẩm và số lượng từ giỏ hàng
        String sql = "SELECT p.id, p.name, p.price, p.image_url, p.description, ci.quantity " +
                "FROM products p " +
                "JOIN cart_item ci ON p.id = ci.product_id " +
                "WHERE ci.cart_id=?";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CartItem.class), user_id);
    }

    public void removeProduct(Integer product_id, Integer user_id) {
        String sql = "DELETE FROM cart_item WHERE product_id=? AND cart_id=?";
        jdbcTemplate.update(sql, product_id, user_id);
    }

    public void addOrder(String name, String phone_number, String address, JsonNode products, String timeString) {
        try {
            // Chuyển JsonNode thành String
            ObjectMapper objectMapper = new ObjectMapper();
            String productsJson = objectMapper.writeValueAsString(products);

            // Câu lệnh SQL để thêm đơn hàng
            String sql = "INSERT INTO `order`(user_name, address, phone_number, products, time) VALUES(?, ?, ?, ?, ?)";

            // Thực hiện câu lệnh SQL
            jdbcTemplate.update(sql, name, address, phone_number, productsJson, timeString);
        } catch (Exception e) {
            // Xử lý lỗi nếu có
            e.printStackTrace();
            // Có thể ném ngoại lệ hoặc xử lý lỗi theo yêu cầu của bạn
        }
    }

    public void clearCart(Integer userId) {
        String sql = "DELETE FROM cart_item WHERE cart_id = ?";
        jdbcTemplate.update(sql, userId);
    }



}

