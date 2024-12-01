package com.example.demo9_test.controller;



import com.example.demo9_test.entity.ContactForm;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ContactController {

    @PostMapping("/submit-form")
    public ModelAndView handleFormSubmit(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("message") String message) {

        // Tạo đối tượng ContactForm từ dữ liệu form
        ContactForm contactForm = new ContactForm(name, email, phone, message);

        ObjectMapper objectMapper = new ObjectMapper();
        // Bật chế độ pretty print để ghi JSON có định dạng đẹp
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        File file = new File("contacts.json");
        List<ContactForm> contacts = new ArrayList<>();

        try {
            // Nếu file đã tồn tại, đọc danh sách cũ trước
            if (file.exists()) {
                contacts = objectMapper.readValue(file, new TypeReference<List<ContactForm>>() {});
            }

            // Thêm contact mới vào danh sách
            contacts.add(contactForm);

            // Ghi danh sách contacts vào file JSON
            objectMapper.writeValue(file, contacts);

            ModelAndView modelAndView = new ModelAndView("contact_page");
            modelAndView.addObject("message", "Thanks for contacting us. We'll get back to you as soon as possible.");
            return modelAndView;
        } catch (IOException e) {
            e.printStackTrace();
            ModelAndView modelAndView = new ModelAndView("contact_page");
            modelAndView.addObject("message", "khong thong tin thanh cong");
            return modelAndView;
        }
    }
}
