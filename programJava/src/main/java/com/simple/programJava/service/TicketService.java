package com.simple.programJava.service;


import com.simple.programJava.model.TicketSale;
import com.simple.programJava.repository.TicketSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketSaleRepository ticketSaleRepository;

    public TicketSale sellTickets(TicketSale ticketSale) {
        ticketSale.setSaleTime(java.time.LocalDateTime.now());
        return ticketSaleRepository.save(ticketSale);
    }

    public List<TicketSale> getAllTicketSales() {
        return ticketSaleRepository.findAll();
    }}
