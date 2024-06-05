package com.simple.programJava.controller;

import com.simple.programJava.model.TicketSale;
import com.simple.programJava.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/sell")
    public ResponseEntity<TicketSale> sellTickets(@RequestBody TicketSale ticketSale) {
        TicketSale savedTicketSale = ticketService.sellTickets(ticketSale);
        return ResponseEntity.ok(savedTicketSale);
    }

    @GetMapping
    public ResponseEntity<List<TicketSale>> getAllTicketSales() {
        List<TicketSale> ticketSales = ticketService.getAllTicketSales();
        return ResponseEntity.ok(ticketSales);
    }
}

