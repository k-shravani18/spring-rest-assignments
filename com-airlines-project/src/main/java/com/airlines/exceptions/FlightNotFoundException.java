package com.airlines.exceptions;

public class FlightNotFoundException extends Exception {
    public FlightNotFoundException() {
    }

    public FlightNotFoundException(String message) {
        super(message);
    }
}
