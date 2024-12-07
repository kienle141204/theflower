//package com.example.demo9_test.entity;
//
//
//import jakarta.persistence.*;
//
//import java.util.UUID;
//
//@Entity
//@Table(name="cart")
//public class Cart {
//
//    @Id
//    @Column(name="id")
//    private int id;
//
//    @GeneratedValue
//    @Column(name = "guest_id", updatable = false, nullable = false)
//    private String guestId = UUID.randomUUID().toString();
//
//    @Column(name="user_id")
//    private int userId;
//
//    @Column(name="total_price")
//    private double totalPrice;
//
//    public Cart(){
//    }
//
//    public Cart(int id, int userId, String guestId, double totalPrice) {
//        this.id = id;
//        this.userId = userId;
//        this.guestId = guestId;
//        this.totalPrice = totalPrice;
//    }
//
//    public int getId() {
//        return id;
//    }
//    public void setId(int id) {
//        this.id = id;
//    }
//    public int getUserId() {
//        return userId;
//    }
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//    public String getGuestId() {
//        return guestId;
//    }
//    public void setGuestId(String guestId) {
//        this.guestId = guestId;
//    }
//    public double getTotalPrice() {
//        return totalPrice;
//    }
//    public void setTotalPrice(double totalPrice) {
//        this.totalPrice = totalPrice;
//    }
//
//}