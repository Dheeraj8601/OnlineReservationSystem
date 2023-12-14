package com.Dheeraj.reservationAPI.ReservationSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Dheeraj.reservationAPI.Services.PassengerService;
import com.Dheeraj.reservationAPI.entities.Passenger;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    public PassengerService passengerService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Passenger addPassenger(@RequestBody Passenger passenger){
        passengerService.savePassenger(passenger);
        return passenger;
    }
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Passenger> getAllPassengers(){
        List<Passenger>  passengers=passengerService.getAllPassengers();
        return passengers;
    }

    @GetMapping("/{passengerId}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable Long passengerId){
        return ResponseEntity.ok(passengerService.getPassengerById(passengerId));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String updatePassenger(@RequestBody Passenger passenger,@PathVariable Long id){
        passengerService.updatePassenger(passenger,id);
        return "Passenger details Updated";
    }




}
