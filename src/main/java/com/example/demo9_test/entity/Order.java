package com.example.demo9_test.entity;

import java.util.List;

public class Order {

    private Long id;

    private String userName;
    private String address;
    private String phone;

    private List<ProductWithQuantity> products;

    private String orderTime;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<ProductWithQuantity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductWithQuantity> products) {
        this.products = products;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }
}

