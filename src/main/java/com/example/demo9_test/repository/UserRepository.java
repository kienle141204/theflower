package com.example.demo9_test.repository;

import com.example.demo9_test.entity.Product;
import com.example.demo9_test.entity.User;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User check_login(String email, String password) {
        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
        try {
            return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(User.class), email, password);
        } catch (Exception e) {
            return null;
        }
    }


    public void addUser(String name, String email, String password, String phone_number, String address) {
        String checkSql = "SELECT COUNT(*) FROM user WHERE email = ?";
        Integer count = jdbcTemplate.queryForObject(checkSql, Integer.class, email);

        if (count != null && count > 0) {
            throw new IllegalArgumentException("User với email này đã tồn tại!");
        }

        String insertSql = "INSERT INTO user(name, email, password, phone_number, address) VALUES(?,?,?,?,?)";
        jdbcTemplate.update(insertSql, name, email, password, phone_number, address);
    }

    public void reset_pw(String email, String phone_number, String new_password) {
        String checkSql = "SELECT COUNT(*) FROM user WHERE email = ? AND phone_number = ?";
        Integer count = jdbcTemplate.queryForObject(checkSql, Integer.class, email, phone_number);
        String sql = "UPDATE user SET password = ? WHERE email=? AND phone_number=?";
        if(count == 0 ) {
            throw new IllegalArgumentException("Kiểm tra lại thông tin!!!");
        }
        else{
            jdbcTemplate.update(sql, new_password,email, phone_number);
        }
    }


}
