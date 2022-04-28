package com.airlines.repository;

import com.airlines.model.Flight;
import com.airlines.util.Queries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class FlightRepositoryImpl implements IFlightRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void addFlight(Flight flight) {
        Date date= Date.valueOf(flight.getDate());
        LocalDateTime arrivalTime=LocalDateTime.parse(flight.getArrivalTime());
        LocalDateTime departureTime=LocalDateTime.parse(flight.getDepatureTime());
        Object[] flights={flight.getFlightId(),flight.getFlightName(),flight.getSource(),flight.getDestination(),flight.getDate(),flight.getArrivalTime(),flight.getDepatureTime(),flight.getFlightPrice(),flight.getNoOfSeats()};
        jdbcTemplate.update(Queries.INSERTQUERY,flights);
    }

    @Override
    public void updateFlight(int flightId, LocalDateTime arrivalTime, LocalDateTime departureTime) {
        jdbcTemplate.update(Queries.UPDATEQUERY,arrivalTime,departureTime);
    }

    @Override
    public void deleteFlight(int flightId) {
        jdbcTemplate.update(Queries.DELETEQUERY,flightId);
    }

    @Override
    public List<Flight> findAllFlightDetalis() {
       RowMapper<Flight> flightRowMapper=new FlightMapper();
       List<Flight> flights=jdbcTemplate.query(Queries.SELECTQUERY,flightRowMapper);
        return flights;
    }

    @Override
    public Flight findFlightById(int flightId) {
        RowMapper<Flight> flightRowMapper=new FlightMapper();
        return jdbcTemplate.queryForObject(Queries.SELECTIDQUERY,flightRowMapper);

    }

    @Override
    public Flight findFlightByName(String flightName) {
        RowMapper<Flight> flightRowMapper=new FlightMapper();
        return jdbcTemplate.queryForObject(Queries.SELECTNAMEQUERY,flightRowMapper);

    }

    @Override
    public List<Flight> findAllFlights(String source, String destination) {
        RowMapper<Flight> flightRowMapper=new FlightMapper();
        List<Flight> flights=jdbcTemplate.query(Queries.SELECTALLQUERY,flightRowMapper);
        return flights;
    }
}
