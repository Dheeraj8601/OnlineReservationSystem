package com.Dheeraj.reservationAPI.Controller;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Dheeraj.reservationAPI.Services.FlightService;
import com.Dheeraj.reservationAPI.entities.Flight;



@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    public FlightService flightservice;
    @PostMapping("/admin/addFlights")
    @ResponseStatus(HttpStatus.CREATED)
    public Flight addFlight(@RequestBody Flight flight){
        flightservice.addFlight(flight);
        return flight;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Flight> getFlights(){
        return flightservice.getFlights();
    }

    @GetMapping("/{flightNo}")
    @ResponseStatus(HttpStatus.OK)
    public Flight getByFlightNo(@PathVariable String flightNo){
        return flightservice.getByNumber(flightNo);
    }

    @GetMapping("/findflights")
    public List<Flight> findFlights(@RequestParam("from") String from,@RequestParam("to") String to,@RequestParam("depatureDate")
    @DateTimeFormat(pattern="yyyy-MM-dd")Date departureDate){
        return flightservice.findFlights(from,to,departureDate);

    }


}
