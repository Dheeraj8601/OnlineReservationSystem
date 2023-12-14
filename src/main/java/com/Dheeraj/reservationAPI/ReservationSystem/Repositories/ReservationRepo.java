package com.Dheeraj.reservationAPI.ReservationSystem.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Dheeraj.reservationAPI.entities.Reservation;

@Repository
public interface ReservationRepo  extends JpaRepository<Reservation, Long>{

}