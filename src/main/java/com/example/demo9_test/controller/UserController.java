package com.example.demo9_test.controller;

import com.example.demo9_test.entity.User;
import com.example.demo9_test.repository.OrderRepository;
import com.example.demo9_test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.Map;


@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/api/check_login")
    public ResponseEntity<User> checkLogin(@RequestParam("email") String email,
                                           @RequestParam("password") String password,
                                           HttpSession session) {
        User user = userRepository.check_login(email, password);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        session.setAttribute("email", user.getEmail());
        session.setAttribute("user_id", user.getId());
        session.setAttribute("user_name", user.getName());
        session.setAttribute("phone_number", user.getPhone_number());
        session.setAttribute("address", user.getAddress());
        return ResponseEntity.ok(user);
    }

    @PostMapping("/api/register")
    public ResponseEntity<String> register(@RequestParam("email") String email,
                                           @RequestParam("password") String password,
                                           @RequestParam("name") String name,
                                           @RequestParam("phone_number") String phone_number,
                                           @RequestParam("address") String address) {
        try {
            userRepository.addUser(name, email, password, phone_number, address);
            return ResponseEntity.status(HttpStatus.CREATED).body("Đăng ký thành công");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Có lỗi xảy ra, vui lòng thử lại sau");
        }
    }



    @PostMapping("/api/reset-pw")
    public ResponseEntity<String> reset_pw(@RequestParam("email") String email,
                                           @RequestParam("password") String new_password,
                                           @RequestParam("phone_number") String phone_number)

    {
        try {
            userRepository.reset_pw(email, phone_number, new_password);
            return ResponseEntity.status(HttpStatus.CREATED).body("Đổi mật khẩu thành công");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Có lỗi xảy ra, vui lòng thử lại sau");
        }
    }

    @PostMapping("/api/profile/update")
    public ResponseEntity<String> updateProfile(
            @RequestParam String name,
            @RequestParam String phone_number,
            @RequestParam String address,
            HttpSession session) {
        try {
            int user_id = (int) session.getAttribute("user_id");

            userRepository.updateProfile(user_id,name, phone_number, address);
            session.setAttribute("user_name", name);
            session.setAttribute("phone_number", phone_number);
            session.setAttribute("address", address);
            return ResponseEntity.ok("Thông tin đã được cập nhật.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Có lỗi xảy ra khi cập nhật thông tin.");
        }
    }

    @GetMapping("orders/profile")
    public List<Map<String, Object>> getOrder(HttpSession session) {
        int user_id = (int) session.getAttribute("user_id");
        List<Map<String, Object>> orders = orderRepository.getOrders(user_id);
        System.out.println(orders);
        return orders;
    }

}
