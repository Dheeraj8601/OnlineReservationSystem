package com.Dheeraj.reservationAPI.ReservationSystem.Services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.*;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Dheeraj.reservationAPI.Repositories.UserRepo;
import com.Dheeraj.reservationAPI.entities.User;

@Service
public class UserService {

    @Autowired
    public UserRepo userRepo;
    private BCryptPasswordEncoder encoder;

    public User createUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

}
