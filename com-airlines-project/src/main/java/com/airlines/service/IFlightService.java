package com.airlines.service;

import com.airlines.exceptions.AllTicketsSoldOutException;
import com.airlines.exceptions.FlightIdNotFoundException;
import com.airlines.exceptions.FlightNotFoundException;
import com.airlines.model.Flight;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public interface IFlightService {
    void addFlight(Flight flight);
    void updateFlight(int flightId, LocalDateTime arrivalTime, LocalDateTime departureTime);
    void deleteFlight(int flightId);
    List<Flight> getAllFlightDetalis();

    Flight getFlightById(int flightId) throws FlightIdNotFoundException;
    Flight getFlightByName(String flightName) throws FlightNotFoundException;
    List<Flight>getAllFlights(String source, String destination);

}
