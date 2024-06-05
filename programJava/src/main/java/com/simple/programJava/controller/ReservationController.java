package com.simple.programJava.controller;

import com.simple.programJava.model.Reservation;
import com.simple.programJava.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<String> addReservation(@RequestBody Reservation reservation) {
        boolean success = reservationService.addReservation(reservation);
        if (success) {
            return ResponseEntity.ok("Reservation added successfully");
        } else {
            return ResponseEntity.badRequest().body("Reservation limit reached or invalid day");
        }
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/week")
    public List<Reservation> getWeeklyReservations() {
        return reservationService.getWeeklyReservations();
    }
}