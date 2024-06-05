package com.simple.programJava.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class TicketSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private int quantity;
    private int totalPrice;
    private LocalDateTime saleTime;

    @Transient
    private static int TICKET_PRICE = 50000; // Harga tiket tetap

    public TicketSale() {
    }

    public TicketSale(String customerName, int quantity, int ticket) {
        this.customerName = customerName;
        this.quantity = quantity;
        this.TICKET_PRICE = ticket;
        this.totalPrice = calculateTotalPrice(quantity);
        this.saleTime = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.totalPrice = calculateTotalPrice(quantity);
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public LocalDateTime getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(LocalDateTime saleTime) {
        this.saleTime = saleTime;
    }

    private int calculateTotalPrice(int quantity) {
        return TICKET_PRICE * quantity;
    }
}

