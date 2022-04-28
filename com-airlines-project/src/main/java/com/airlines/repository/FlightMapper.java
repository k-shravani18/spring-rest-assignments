package com.airlines.repository;

import com.airlines.model.Flight;
import org.springframework.jdbc.core.RowMapper;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class FlightMapper implements RowMapper<Flight> {
    @Override
    public Flight mapRow(ResultSet rs, int rowNum) throws SQLException {
        Flight flight= new Flight();
        flight.setFlightId(rs.getInt("flightId"));
        flight.setFlightName(rs.getString("flightName"));
        flight.setSource(rs.getString("source"));
        flight.setDestination(rs.getString("destination"));
        Date date=rs.getDate("date");
        LocalDate date1=date.toLocalDate();
        flight.setDate(date1);
        LocalDateTime arrivalTime=rs.getTimestamp("arrivalTime").toLocalDateTime();
        LocalDateTime.setArrivalTime1(arrivalTime);
        LocalDateTime departureTime=rs.getTimestamp("departureTime").toLocalDateTime();
        LocalDateTime.setdepartureTime1(departureTime);
        flight.setFlightPrice(rs.getDouble("flightPrice"));
        flight.setNoOfSeats(rs.getInt("noOfSeats"));
        return flight;



    }
}
