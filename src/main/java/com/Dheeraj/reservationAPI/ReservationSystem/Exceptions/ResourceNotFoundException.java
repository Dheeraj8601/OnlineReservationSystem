package com.Dheeraj.reservationAPI.ReservationSystem.Exceptions;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
    Long fieldValue;

    public ResourceNotFoundException(Long fieldValue) {
        super(String.format("Id not found %s", fieldValue));
        this.fieldValue = fieldValue;
    }
}
