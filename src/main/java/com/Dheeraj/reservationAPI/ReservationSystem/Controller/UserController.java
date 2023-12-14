package com.Dheeraj.reservationAPI.ReservationSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Dheeraj.reservationAPI.Services.SecurityService;
import com.Dheeraj.reservationAPI.Services.UserService;
import com.Dheeraj.reservationAPI.entities.User;

@RestController
@RequestMapping("/register")
public class UserController {

    @Autowired
    public UserService userService;

    @Autowired
    private SecurityService securityService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user){
        userService.createUser(user);
        return user;
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
        boolean loginResponse = securityService.login(email, password);
        if(loginResponse)
            return "Welcome";
        return "Incorrect User details";
    }



}
