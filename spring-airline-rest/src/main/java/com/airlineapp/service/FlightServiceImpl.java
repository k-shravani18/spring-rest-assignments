package com.airlineapp.service;

import com.airlineapp.exceptions.FlightNotFoundException;
import com.airlineapp.model.Flight;
import com.airlineapp.repository.IFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightServiceImpl implements IFlightService{
    @Autowired
    private IFlightRepository flightRepository;

    @Override
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public void updateFlight(Flight flight) {
        flightRepository.save(flight);
    }

    @Override
    public void deleteFlight(int flightId) {
        flightRepository.deleteById(flightId);
    }

    @Override
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    @Override
    public Flight getByFlightId(int flightId) {
        Flight flight=flightRepository.findById(flightId).get();
        if(flight==null)
            throw new FlightNotFoundException("flight id not found");
        else
            return flight;
    }

    @Override
    public List<Flight> getByFlightName(String flightName) {
        List<Flight> flights=flightRepository.findByFlightName(flightName);
        if(flights.isEmpty())
            throw new FlightNotFoundException("flight name not found");
        else
        return flights;
    }

    @Override
    public List<Flight> getByTicketCost(double ticketCost) {
        List<Flight> flights=flightRepository.findByTicketCost(ticketCost);
        if(flights.isEmpty())
            throw new FlightNotFoundException("ticket cost not found");
        else
            return flights;
    }

    @Override
    public List<Flight> getByAirlineName(String airlineName) {
        List<Flight> flights= flightRepository.findByAirlineName(airlineName);
        if(flights.isEmpty())
            throw new FlightNotFoundException("airline name not found");
        else
            return flights;
    }

    @Override
    public List<Flight> getByStopsType(String stopsType) {
        List<Flight> flights=flightRepository.findByStopsType(stopsType);
        if(flights.isEmpty())
            throw new FlightNotFoundException("stopsType not found");
        else
            return flights;
    }

    @Override
    public List<Flight> getByDateOfJourney(LocalDate dateOfJourney) {
        List<Flight> flights= flightRepository.findByDateOfJourney(dateOfJourney);
        if(flights.isEmpty())
            throw new FlightNotFoundException("dateOfJourney not found");
        else
            return flights;
    }

    @Override
    public List<Flight> getByArrival(LocalDateTime arrival) {
        List<Flight> flights= flightRepository.findByArrival(arrival);
        if (flights.isEmpty())
            throw new FlightNotFoundException("arrivalTime not found");
        else
            return flights;
    }

    @Override
    public List<Flight> getByDeparture(LocalDateTime departure) {
        List<Flight> flights=flightRepository.findByDeparture(departure);
        if (flights.isEmpty())
            throw new FlightNotFoundException("departureTime not found");
        else
            return flights;
    }

    @Override
    public List<Flight> getByDuration(String duration) {
        List<Flight> flights= flightRepository.findByDuration(duration);
        if (flights.isEmpty())
            throw new FlightNotFoundException("duration not found");
        return flights;
    }

    @Override
    public List<Flight> getByClassType(String classType) {
        List<Flight> flights= flightRepository.findByClassType(classType);
        if (flights.isEmpty())
            throw new FlightNotFoundException("this classType not found");
        else
            return flights;
    }

    @Override
    public List<Flight> getBySourceAndDestination(String source, String destination) {
        List<Flight> flights= flightRepository.findBySourceAndDestination(source,destination);
        if (flights.isEmpty())
            throw new FlightNotFoundException("this SourceAndDestination not found");
        else
            return flights;
    }

    @Override
    public List<Flight> getByAirlineNameAndClassType(String airlineName, String classType) {
        List<Flight> flights= flightRepository.findByAirlineNameAndClassType(airlineName,classType);
        if (flights.isEmpty())
            throw new FlightNotFoundException("this AirlineNameAndClassType not found");
        else
            return flights;
    }

    @Override
    public List<Flight> getByAirlineNameAndDestination(String airlineName, String destination) {
        List<Flight> flights= flightRepository.findByAirlineNameAndDestination(airlineName,destination);
        if (flights.isEmpty())
            throw new FlightNotFoundException("this AirlineNameAndDestination not found");
        else
            return flights;
    }

    @Override
    public List<Flight> getByAirlineNameAndDateOfJourney(String airlineName, LocalDate dateOfJourney) {
        List<Flight> flights= flightRepository.findByAirlineNameAndDateOfJourney(airlineName,dateOfJourney);
        if (flights.isEmpty())
            throw new FlightNotFoundException("this AirlineNameAndDateOfJourney not found");
        else
            return flights;
    }
}
