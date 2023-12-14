package com.Dheeraj.reservationAPI.ReservationSystem.Services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dheeraj.reservationAPI.Exceptions.ResourceNotFoundException;
import com.Dheeraj.reservationAPI.Repositories.PassengerRepo;
import com.Dheeraj.reservationAPI.entities.Passenger;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepo passengerRepo;
    public Passenger savePassenger(Passenger passenger) {
        return passengerRepo.save(passenger);
    }
    public List<Passenger> getAllPassengers() {
        List<Passenger> passengers= passengerRepo.findAll();
        return passengers.stream().toList();
    }
    public Passenger getPassengerById(Long passengerId) {
        Passenger passenger=passengerRepo.findById(passengerId).orElseThrow(() -> new ResourceNotFoundException(passengerId));
        return passenger;
    }
    public void updatePassenger(Passenger passenger, Long id) {
        Passenger passenger1=passengerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        passenger1.setFirstName(passenger.getFirstName());
        passenger1.setMiddleName(passenger.getMiddleName());
        passenger1.setLastName(passenger.getLastName());
        passenger1.setEmail(passenger.getEmail());
        passenger1.setPhone(passenger.getPhone());
        passengerRepo.save(passenger1);
    }

}
