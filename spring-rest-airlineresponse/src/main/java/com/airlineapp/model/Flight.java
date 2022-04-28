package com.airlineapp.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Flight {
    String flightName;//("AirBus A321Cr")
    @Id
    @GeneratedValue(generator = "flight_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "flight_gen",sequenceName = "flight_sequence",initialValue = 1,allocationSize = 1)
    int flightId;
    int capacity;//(80)
    double ticketCost;
    String stopsType;//(stop,nonstop)//Enum
    String airlineName; // enum
   String classType;//(business class,economy,premium economy)
    String source;
    String destination;
    String duration;
    LocalDate dateOfJourney;
    String departureTime;// enum(morning, afternoon)
    LocalDateTime arrival;
    LocalDateTime departure;

}
