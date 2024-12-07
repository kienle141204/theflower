package com.example.demo9_test.repository;

import com.example.demo9_test.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;

@Repository
public class shopRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Product> findAll() {
        String sql = "select * from products";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }

    public List<Product> getDataPlants() {
        String sql = "SELECT p.id, p.name, p.price, p.image_url, p.description, p.quantity " +
                "FROM products p " +
                "JOIN product_category pc ON p.id = pc.product_id AND pc.category ='pl'";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }

    public List<Product> getDataMixedBouquets() {
        String sql = "SELECT p.id, p.name, p.price, p.image_url, p.description, p.quantity " +
                "FROM products p " +
                "JOIN product_category pc ON p.id = pc.product_id AND pc.category ='mb'";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }

    public List<Product> getDataChristmas() {
        String sql = "SELECT p.id, p.name, p.price, p.image_url, p.description, p.quantity " +
                "FROM products p " +
                "JOIN product_category pc ON p.id = pc.product_id AND pc.category ='ch'";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }

    public List<Product> getDataOneOfAKind() {
        String sql = "SELECT p.id, p.name, p.price, p.image_url, p.description, p.quantity " +
                "FROM products p " +
                "JOIN product_category pc ON p.id = pc.product_id AND pc.category ='ooak'";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }

    public List<Product> getDataSeasonal() {
        String sql = "SELECT p.id, p.name, p.price, p.image_url, p.description, p.quantity " +
                "FROM products p " +
                "JOIN product_category pc ON p.id = pc.product_id AND pc.category ='ss'";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }

    public List<Product> getDataSpecialOccasion() {
        String sql = "SELECT p.id, p.name, p.price, p.image_url, p.description, p.quantity " +
                "FROM products p " +
                "JOIN product_category pc ON p.id = pc.product_id AND pc.category ='so'";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }

    public List<Product> getDataFoodDrinks() {
        String sql = "SELECT p.id, p.name, p.price, p.image_url, p.description, p.quantity " +
                "FROM products p " +
                "JOIN product_category pc ON p.id = pc.product_id AND pc.category ='fd'";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }

    public void saleOutProduct(String name){
        String sql = "UPDATE products SET quantity = 0 WHERE name = ?";
        jdbcTemplate.update(sql,name);
    }

    public void reStockProduct(String name){
        String sql = "UPDATE products SET quantity = 1 WHERE name = ?";
        jdbcTemplate.update(sql,name);
    }

    public void deleteProduct(String name){
        String sql ="delete pc " +
                "from product_category pc " +
                "join products p on pc.product_id = p.id " +
                "where p.name = ?";
        jdbcTemplate.update(sql,name);
        String sql2 = "DELETE FROM products WHERE name = ?;";
        jdbcTemplate.update(sql2,name);
    }
}

