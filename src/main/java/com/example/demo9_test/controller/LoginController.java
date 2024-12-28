package com.example.demo9_test.controller;

import com.example.demo9_test.entity.User;
import com.example.demo9_test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;


@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/check_login")
    public ResponseEntity<User> checkLogin(@RequestParam("email") String email,
                                              @RequestParam("password") String password,
                                              HttpSession session) {
        User user = userRepository.check_login(email, password);
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

}
