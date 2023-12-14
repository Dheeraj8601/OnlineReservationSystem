package com.Dheeraj.reservationAPI.ReservationSystem.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dheeraj.reservationAPI.Dto.ReservationRequest;
import com.Dheeraj.reservationAPI.Dto.ReservationUpdateRequest;
import com.Dheeraj.reservationAPI.Exceptions.ResourceNotFoundException;
import com.Dheeraj.reservationAPI.Repositories.FlightRepo;
import com.Dheeraj.reservationAPI.Repositories.PassengerRepo;
import com.Dheeraj.reservationAPI.Repositories.ReservationRepo;
import com.Dheeraj.reservationAPI.entities.Flight;
import com.Dheeraj.reservationAPI.entities.Passenger;
import com.Dheeraj.reservationAPI.entities.Reservation;

@Service
public class ReservationService {

    @Autowired
    public FlightRepo flightRepo;

    @Autowired
    public PassengerRepo passengerRepo;

    @Autowired
    public ReservationRepo reservationRepo;

    public Reservation bookFlight(ReservationRequest reservationRequest){
        Long flightId= reservationRequest.getFlightId();
        Flight flight=flightRepo.findById(flightId).orElseThrow(()->new ResourceNotFoundException(flightId));

        Passenger passenger= new Passenger();
        passenger.setFirstName(reservationRequest.getPassengerFirstName());
        passenger.setLastName(reservationRequest.getPassengerLastName());
        passenger.setEmail(reservationRequest.getPassengerEmail());
        passenger.setPhone(reservationRequest.getPassengerPhone());
        Passenger savedPassenger= passengerRepo.save(passenger);
        Reservation reservation= new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);
        reservationRepo.save(reservation);
        return null;
    }

    public Reservation updateReservation(ReservationUpdateRequest request) {
        long id= request.getId();
        Reservation reservation= reservationRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(id));
        reservation.setCheckedIn(request.getCheckedIn());
        reservation.setNumberOfBags(request.getNumberOfBags());
        Reservation savedReservation=reservationRepo.save(reservation);
        return savedReservation;
    }

    public Reservation getReservationInfo(Long id) {
        Reservation reservation= reservationRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
        return reservation;
    }

}
