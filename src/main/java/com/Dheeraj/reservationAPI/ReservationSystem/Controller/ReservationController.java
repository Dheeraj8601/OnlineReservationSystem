package com.Dheeraj.reservationAPI.ReservationSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.Dheeraj.reservationAPI.Dto.ReservationRequest;
import com.Dheeraj.reservationAPI.Dto.ReservationUpdateRequest;
import com.Dheeraj.reservationAPI.Services.ReservationService;
import com.Dheeraj.reservationAPI.entities.Reservation;

@RestController
//@RequestMapping("/")
public class ReservationController {
    @Autowired
    public ReservationService reservationService;
    @PostMapping("/completeReservation")
    public String completeReservation(@RequestBody ReservationRequest reservationRequest){
        reservationService.bookFlight(reservationRequest);
        return  "Reservation made succesfully";
    }

    @PutMapping("/reservationUpdate")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest request){
        Reservation reservation=reservationService.updateReservation(request);
        return reservation;
    }

    @GetMapping("/{id}")
    public Reservation getReservationInfo(@PathVariable("id") Long id){
        Reservation reservation= reservationService.getReservationInfo(id);
        return reservation;
    }


}

