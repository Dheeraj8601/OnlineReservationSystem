package com.Dheeraj.reservationAPI.ReservationSystem.Services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    @Autowired
    UserDetailsService userDetailService;

    @Autowired
    AuthenticationManager authenticationManager;

    public boolean login(String username,String password) {
        UserDetails userDetails = userDetailService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken token= new UsernamePasswordAuthenticationToken(password, userDetails
                ,userDetails.getAuthorities());
        authenticationManager.authenticate(token);
        boolean result = token.isAuthenticated();
        if(result)
            SecurityContextHolder.getContext().setAuthentication(token);
        return result;
    }
}
