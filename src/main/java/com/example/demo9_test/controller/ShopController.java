package com.example.demo9_test.controller;

import com.example.demo9_test.entity.Product;
import com.example.demo9_test.repository.shopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products/shop")
public class ShopController {

    @Autowired
    private shopRepository shopRepository;
//    @Autowired
//    private CartRepository cartRepository ;
    @GetMapping("/shop_all")
    public List<Product> getAllProducts() {
        return shopRepository.findAll();
    }

    @GetMapping("/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return shopRepository.getData(category);
    }
//    @GetMapping("/{id}")
//    public void addProduct(@PathVariable Long id) {
//        Cart cart = new Cart() ;
//        cart.setId(id) ;
//        cartRepository.save(cart);
//    }

//    // API cho Plants
//    @GetMapping("/plants")
//    public List<Product> getDataPlants() {
//        return shopRepository.getDataPlants();
//    }
//
//    // API cho Mixed Bouquets
//    @GetMapping("/mixed_bouquets")
//    public List<Product> getDataMixedBouquets() {
//        return shopRepository.getDataMixedBouquets();
//    }
//
//    // API cho Christmas
//    @GetMapping("/christmas")
//    public List<Product> getDataChristmas() {
//        return shopRepository.getDataChristmas();
//    }
//
//    // API cho One of a Kind
//    @GetMapping("/one_of_a_kind")
//    public List<Product> getDataOneOfAKind() {
//        return shopRepository.getDataOneOfAKind();
//    }
//
//    // API cho Seasonal
//    @GetMapping("/seasonal")
//    public List<Product> getDataSeasonal() {
//        return shopRepository.getDataSeasonal();
//    }
//
//    // API cho Special Occasion
//    @GetMapping("/special_occasion")
//    public List<Product> getDataSpecialOccasion() {
//        return shopRepository.getDataSpecialOccasion();
//    }
//
//    // API cho Food and Drinks
//    @GetMapping("/food_drinks")
//    public List<Product> getDataFoodDrinks() {
//        return shopRepository.getDataFoodDrinks();
//    }

    @GetMapping("/sale_out/{name}")
    public List<Product> saleOutProduct(@PathVariable String name) {
        shopRepository.saleOutProduct(name);
        return shopRepository.findAll();
    }

    @GetMapping("/re_stock/{name}")
    public List<Product> reStockProduct(@PathVariable String name) {
        shopRepository.reStockProduct(name);
        return shopRepository.findAll();
    }

    @GetMapping("/delete/{name}")
    public List<Product> deleteProduct(@PathVariable String name) {
        shopRepository.deleteProduct(name);
        return shopRepository.findAll();
    }

}

