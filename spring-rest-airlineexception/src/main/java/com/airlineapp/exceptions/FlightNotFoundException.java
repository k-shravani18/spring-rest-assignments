package com.airlineapp.exceptions;

public class FlightNotFoundException extends RuntimeException{
    public FlightNotFoundException() {
    }

    public FlightNotFoundException(String message) {
        super(message);
    }
}
