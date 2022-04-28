package com.airlines.service;

import com.airlines.exceptions.FlightIdNotFoundException;
import com.airlines.exceptions.FlightNotFoundException;
import com.airlines.model.Flight;
import com.airlines.repository.IFlightRepository;

import java.time.LocalDateTime;
import java.util.List;

public class FlightServiceImpl implements  IFlightService{
    private IFlightRepository flightRepository;

    public void setFlightRepository(IFlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public void addFlight(Flight flight) {
        flightRepository.addFlight(flight);
    }

    @Override
    public void updateFlight(int flightId, LocalDateTime arrivalTime, LocalDateTime departureTime) {
        flightRepository.updateFlight(flightId,arrivalTime,departureTime);
    }

    @Override
    public void deleteFlight(int flightId) {
        flightRepository.deleteFlight(flightId);
    }

    @Override
    public List<Flight> getAllFlightDetalis() {
        List<Flight> flights=flightRepository.findAllFlightDetalis();
        return flights;
    }

    @Override
    public Flight getFlightById(int flightId) throws FlightIdNotFoundException {
        Flight flight=flightRepository.findFlightById(flightId);
        if(flight==null)
            throw new FlightIdNotFoundException("flight id not found");
        return flight;
    }

    @Override
    public Flight getFlightByName(String flightName) throws FlightNotFoundException {
        Flight flight=flightRepository.findFlightByName(flightName);
        if(flight==null)
            throw  new FlightNotFoundException("flight name  is not found");
        return  flight;
    }

    @Override
    public List<Flight> getAllFlights(String source, String destination) {

        List<Flight> flights=flightRepository.findAllFlights(source,destination);
        return flights;
    }
}
