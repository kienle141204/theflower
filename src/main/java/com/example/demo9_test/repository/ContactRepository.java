package com.example.demo9_test.repository;

import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ContactRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveMessage(String name,String email, String phone_number, String message) {
        String sql = "INSERT INTO feedback(name, email, phone_number, message) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, name, email, phone_number, message);
    }

}
