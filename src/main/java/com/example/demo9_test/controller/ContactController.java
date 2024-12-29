package com.example.demo9_test.controller;



import com.example.demo9_test.entity.ContactForm;
import com.example.demo9_test.repository.ContactRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private ContactRepository contactRepository;

    @PostMapping("/submit-form")
    public void handleFormSubmit(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("message") String message) {
        contactRepository.saveMessage(name, email, phone, message);
    }
}
