package com.airlines.model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Flight {
    private Integer flightId;
    private String flightName;
    private String source;
    private String destination;
    private LocalDate date;
    private LocalDateTime arrivalTime;
    private LocalDateTime depatureTime;
    private double flightPrice;
    public int noOfSeats;
}
