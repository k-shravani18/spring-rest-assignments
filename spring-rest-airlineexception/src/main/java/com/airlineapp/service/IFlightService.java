package com.airlineapp.service;

import com.airlineapp.exceptions.FlightNotFoundException;
import com.airlineapp.model.Flight;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IFlightService {
    Flight addFlight(Flight flight);
    void updateFlight(Flight flight);
    void deleteFlight(int flightId);
    List<Flight>getAll();

    Flight getByFlightId(int flightId);
    List<Flight> getByFlightName(String flightName)throws FlightNotFoundException;
    List<Flight> getByTicketCost(double ticketCost)throws FlightNotFoundException;
    List<Flight> getByAirlineName(String airlineName)throws FlightNotFoundException;
    List<Flight> getByStopsType(String stopsType)throws FlightNotFoundException;
    List<Flight> getByDateOfJourney(LocalDate dateOfJourney)throws FlightNotFoundException;
    List<Flight> getByArrival(LocalDateTime arrival)throws FlightNotFoundException;
    List<Flight> getByDeparture(LocalDateTime departure)throws FlightNotFoundException;
    List<Flight> getByDuration(String duration)throws FlightNotFoundException;
    List<Flight> getByClassType(String classType)throws FlightNotFoundException;

    @Query("from Flight f where f.source=?1,f.destination=?2")
    List<Flight> getBySourceAndDestination(String source,String destination) throws FlightNotFoundException;
    @Query("from Flight f where f.airlineName=?1,f.classType=?2")
    List<Flight> getByAirlineNameAndClassType(String airlineName,String classType)throws FlightNotFoundException;
    @Query("from Flight f where f.airlineName=?1,f.destination=?2")
    List<Flight> getByAirlineNameAndDestination(String airlineName,String destination)throws FlightNotFoundException;
    @Query("from Flight f where f.airlineName=?1,f.dateOfJourney=?2")
    List<Flight> getByAirlineNameAndDateOfJourney(String airlineName, LocalDate dateOfJourney)throws FlightNotFoundException;
}
