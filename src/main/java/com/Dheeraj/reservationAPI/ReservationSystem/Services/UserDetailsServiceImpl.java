package com.Dheeraj.reservationAPI.ReservationSystem.Services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Dheeraj.reservationAPI.Repositories.UserRepo;
import com.Dheeraj.reservationAPI.entities.User;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub

        User user=userRepo.findByEmail(username);
        if(user==null)
            throw new UsernameNotFoundException("User name not found");
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getRoles());
    }

}
