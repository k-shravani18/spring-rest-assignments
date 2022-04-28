package com.airlines.repository;

import com.airlines.model.Flight;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface IFlightRepository {
    //admin
    void addFlight(Flight flight);
    void updateFlight(int flightId, LocalDateTime arrivalTime, LocalDateTime departureTime);
    void deleteFlight(int flightId);
    List<Flight> findAllFlightDetalis();

    //user

    Flight findFlightById(int flightId);
    Flight findFlightByName(String flightName);
    List<Flight>findAllFlights(String source, String destination);

}
