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

    public List<Product> getDataPlants() {
        String sql = "SELECT shop_all.id, shop_all.name, shop_all.price, shop_all.image_url, shop_all.description " +
                "FROM shop_all " +
                "JOIN plants ON shop_all.id = plants.product_id";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }

    public List<Product> getDataMixedBouquets() {
        String sql = "SELECT shop_all.id, shop_all.name, shop_all.price, shop_all.image_url, shop_all.description " +
                "FROM shop_all " +
                "JOIN mixed_bouquets ON shop_all.id = mixed_bouquets.product_id";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }

    public List<Product> getDataChristmas() {
        String sql = "SELECT shop_all.id, shop_all.name, shop_all.price, shop_all.image_url, shop_all.description " +
                "FROM shop_all " +
                "JOIN christmas_flowers ON shop_all.id = christmas_flowers.product_id";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }

    public List<Product> getDataOneOfAKind() {
        String sql = "SELECT shop_all.id, shop_all.name, shop_all.price, shop_all.image_url, shop_all.description " +
                "FROM shop_all " +
                "JOIN one_of_a_kind ON shop_all.id = one_of_a_kind.product_id";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }

    public List<Product> getDataSeasonal() {
        String sql = "SELECT shop_all.id, shop_all.name, shop_all.price, shop_all.image_url, shop_all.description " +
                "FROM shop_all " +
                "JOIN seasonal_bouquets ON shop_all.id = seasonal_bouquets.product_id";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }

    public List<Product> getDataSpecialOccasion() {
        String sql = "SELECT shop_all.id, shop_all.name, shop_all.price, shop_all.image_url, shop_all.description " +
                "FROM shop_all " +
                "JOIN special_occasions ON shop_all.id = special_occasions.product_id";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }

    public List<Product> getDataFoodDrinks() {
        String sql = "SELECT shop_all.id, shop_all.name, shop_all.price, shop_all.image_url, shop_all.description " +
                "FROM shop_all " +
                "JOIN food_drinks_gifts ON shop_all.id = food_drinks_gifts.product_id";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }


}

