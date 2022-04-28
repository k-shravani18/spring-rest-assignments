package com.airlineapp.repository;

import com.airlineapp.model.Flight;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IFlightRepository extends JpaRepository<Flight,Integer> {
    Flight findByFlightId(int flightId);
    List<Flight> findByFlightName(String flightName);
    List<Flight> findByTicketCost(double ticketCost);
    List<Flight> findByAirlineName(String airlineName);
    List<Flight> findByStopsType(String stopsType);
    List<Flight> findByDateOfJourney(LocalDate dateOfJourney);
    List<Flight> findByArrival(LocalDateTime arrival);
    List<Flight> findByDeparture(LocalDateTime departure);
    List<Flight> findByDuration(String duration);
    List<Flight> findByClassType(String classType);


    List<Flight> findBySourceAndDestination(String source,String destination);
    List<Flight> findByAirlineNameAndClassType(String airlineName,String classType);
    List<Flight> findByAirlineNameAndDestination(String airlineName,String destination);
    List<Flight> findByAirlineNameAndDateOfJourney(String airlineName, LocalDate dateOfJourney);
}
