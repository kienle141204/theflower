package com.example.demo9_test.repository;

import com.example.demo9_test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int check_login(String email, String password) {
        String sql = "select id from user where email=? and password=?";
        try {
            Integer result = jdbcTemplate.queryForObject(sql, Integer.class, email, password);
            return result != null ? result : 0; // Nếu kết quả trả về null, trả về 0
        } catch (Exception e) {
            return 0; // Trả về 0 nếu có lỗi
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
