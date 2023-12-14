package com.Dheeraj.reservationAPI.ReservationSystem.Services;



import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dheeraj.reservationAPI.Repositories.FlightRepo;
import com.Dheeraj.reservationAPI.entities.Flight;

@Service
public class FlightService {

    @Autowired
    public FlightRepo flightRepo;
    public Flight addFlight(Flight flight) {
        return flightRepo.save(flight);
    }
    public List<Flight> getFlights() {
        List<Flight> flights= flightRepo.findAll().stream().toList();
        return flights;
    }
    public Flight getByNumber(String flightNo) {
        Flight flight= flightRepo.getByFlightNumber(flightNo);
        return flight;
    }

    public List<Flight> findFlights(String from, String to, Date departureDate) {
        List<Flight> flights= flightRepo.findFlights(from,to,departureDate);
        return flights;
    }


}

