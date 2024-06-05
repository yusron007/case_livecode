package com.simple.programJava.service;

import com.simple.programJava.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopService {

    private final List<Product> keyboards;
    private final List<Product> mice;

    public ShopService() {
        // Initialize products with example prices
        keyboards = new ArrayList<>();
        keyboards.add(new Product("Keyboard1", 25.0));
        keyboards.add(new Product("Keyboard2", 35.0));
        keyboards.add(new Product("Keyboard3", 45.0));

        mice = new ArrayList<>();
        mice.add(new Product("Mouse1", 12.0));
        mice.add(new Product("Mouse2", 20.0));
        mice.add(new Product("Mouse3", 35.0));
    }

    public List<Product> findBestCombination(double budget) {
        List<Product> result = new ArrayList<>();
        double closestSum = 0;

        for (Product keyboard : keyboards) {
            for (Product mouse : mice) {
                double total = keyboard.getPrice() + mouse.getPrice();
                if (total <= budget && total > closestSum) {
                    closestSum = total;
                    result.clear();
                    result.add(keyboard);
                    result.add(mouse);
                }
            }
        }

        return result;
    }
}
