package com.Dheeraj.reservationAPI.ReservationSystem.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Dheeraj.reservationAPI.entities.Passenger;



@Repository
public interface PassengerRepo extends JpaRepository<Passenger,Long> {
}

