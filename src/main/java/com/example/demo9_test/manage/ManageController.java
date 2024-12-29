package com.example.demo9_test.manage;

import com.example.demo9_test.entity.ContactForm;
import com.example.demo9_test.entity.Product;
import com.example.demo9_test.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
public class ManageController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private manageRepository ManageRepository;

    @GetMapping("/api/manage_00112299")
    public String shopManage() {
        return "manage_shop";
    }

    @GetMapping("/api/manage_00112299/add")
    public String addProduct() {
        return "manage_addProduct";
    }

    @GetMapping("/api/manage_00112299/{productId}")
    public String productManage(@PathVariable Long productId, Model model) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Sản phẩm không tồn tại"));
        model.addAttribute("manage_product", product);
        return "manage_product";
    }

    @GetMapping("/api/manage/orders")
    public String getOrders(Model model) {
//        // Lấy danh sách đơn hàng từ dịch vụ
//        List<Map<String, Object>> orders = ManageRepository.getAllOrders();
//
//        System.out.println("Danh sách đơn hàng: ");
//        for (Map<String, Object> order : orders) {
//            System.out.println(order);
//        }
//
//        // Thêm dữ liệu vào model để hiển thị trên trang
//        model.addAttribute("orders", orders);

        return "manage_order"; // Trả về tên view (orderList.html)
    }

    @GetMapping("/manage_00112299/orders")
    @ResponseBody
    public List<Map<String, Object>> getOrder() {
        List<Map<String, Object>> orders = ManageRepository.getAllOrders();
        System.out.println(orders);
        return orders; // Spring tự động chuyển đổi thành JSON
    }

    @GetMapping("/manage_00112299/feedback")
    @ResponseBody
    public List<ContactForm> getFeedback(){
        List<ContactForm> feedback = ManageRepository.getFeedback();
        return feedback;
    }

    @GetMapping("/api/manage/feedback")
    public String fb(){
        return "manage_feedback";
    }
}
