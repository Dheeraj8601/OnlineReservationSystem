package com.Dheeraj.reservationAPI.ReservationSystem.Repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Dheeraj.reservationAPI.entities.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {

}
