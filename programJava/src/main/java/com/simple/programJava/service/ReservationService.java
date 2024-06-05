package com.simple.programJava.service;

import com.simple.programJava.model.Reservation;
import com.simple.programJava.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public boolean addReservation(Reservation reservation) {
        LocalDate date = reservation.getDate();
        if (date.getDayOfWeek() == DayOfWeek.WEDNESDAY || date.getDayOfWeek() == DayOfWeek.FRIDAY) {
            return false; // Wednesday and Friday are holidays
        }
        List<Reservation> reservationsOnDate = reservationRepository.findByDate(date);
        if (reservationsOnDate.size() >= 2) {
            return false; // Only 2 reservations allowed per day
        }
        reservationRepository.save(reservation);
        return true;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public List<Reservation> getWeeklyReservations() {
        LocalDate today = LocalDate.now();
        LocalDate endOfWeek = today.plusDays(6);

        List<LocalDate> weekDates = Stream.iterate(today, date -> date.plusDays(1))
                .limit(7)
                .filter(date -> date.getDayOfWeek() != DayOfWeek.WEDNESDAY && date.getDayOfWeek() != DayOfWeek.FRIDAY)
                .collect(Collectors.toList());

        return weekDates.stream()
                .flatMap(date -> reservationRepository.findByDate(date).stream())
                .collect(Collectors.toList());
    }
}
