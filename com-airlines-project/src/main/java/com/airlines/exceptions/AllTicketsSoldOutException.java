package com.airlines.exceptions;

public class AllTicketsSoldOutException extends Exception {
    public AllTicketsSoldOutException() {
    }

    public AllTicketsSoldOutException(String message) {
        super(message);
    }
}
