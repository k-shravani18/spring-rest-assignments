package com.airlines.exceptions;

public class FlightIdNotFoundException extends RuntimeException {
    public FlightIdNotFoundException() {
    }

    public FlightIdNotFoundException(String message) {
        super(message);
    }
}
