package com.simple.programJava.controller;

import com.simple.programJava.model.Product;
import com.simple.programJava.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping("/purchase")
    public ResponseEntity<List<Product>> purchase(@RequestBody Map<String, Double> request) {
        if (!request.containsKey("budget")) {
            return ResponseEntity.badRequest().build();
        }
        double budget = request.get("budget");
        List<Product> products = shopService.findBestCombination(budget);
        return ResponseEntity.ok(products);
    }
}