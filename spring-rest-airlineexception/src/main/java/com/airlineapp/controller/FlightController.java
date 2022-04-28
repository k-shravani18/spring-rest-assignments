package com.airlineapp.controller;

import com.airlineapp.model.Flight;
import com.airlineapp.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/flight-api")
public class FlightController {
    @Autowired
    private IFlightService flightService;

    //http://localhost:8080/flight-api/flights
   @PostMapping("/flights")
   public ResponseEntity<Flight> addFlight(@RequestBody Flight flight){
       flightService.addFlight(flight);
       return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/flights")
    public ResponseEntity<Void> updateFlight(@RequestBody Flight flight){
        flightService.updateFlight(flight);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @DeleteMapping("/flights/flightId/{flightId}")
    public ResponseEntity<Void> deleteFlight(@PathVariable("flightId") int flightId){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","delete flight by id");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();

    }
    //http://localhost:8082/flight-api/flights
    @GetMapping("/flights")
    public ResponseEntity<List<Flight>> getAll(){
        List<Flight> flights=flightService.getAll();
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","getting all flights");
        headers.add("info","get all method called");
        ResponseEntity<List<Flight>> flightResponse=new ResponseEntity(flights,headers,HttpStatus.OK);
        return flightResponse;
    }


    //http://localhost:8082/flight-api/flights/flightId
    @GetMapping("flights/flightId/{flightId}")
    public ResponseEntity<Flight> getByFlightId(@PathVariable("flightId") int flightId){
       Flight flight= flightService.getByFlightId(flightId);
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","get by id");
        return ResponseEntity.ok().headers(headers).body(flight);

    }
    //http://localhost:8082/flight-api/flights/flightName
    @GetMapping("flights/flightName/{flightName}")
    public ResponseEntity<List<Flight>> getByFlightName(@PathVariable("flightName") String flightName){
       List<Flight> flights= flightService.getByFlightName(flightName);
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","get by flight name");
        return  ResponseEntity.ok().headers(headers).body(flights);
    }

    //http://localhost:8082/flight-api/flights/ticketCost
    @GetMapping("flights/ticketCost/{ticketCost}")
    public ResponseEntity<List<Flight>> getByTicketCost(@PathVariable("ticketCost") double ticketCost){
        List<Flight> flights=  flightService.getByTicketCost(ticketCost);
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","get by ticket cost");
        return  ResponseEntity.ok().headers(headers).body(flights);
    }
    //http://localhost:8082/flight-api/flights/airlineName
    @GetMapping("/flights/airlineName/{airlineName}")
    public ResponseEntity<List<Flight>> getByAirlineName(@PathVariable("airlineName")String airlineName){
        List<Flight> flights= flightService.getByAirlineName(airlineName);
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","get by airlineName");
        return  ResponseEntity.ok().headers(headers).body(flights);
    }
    //http://localhost:8082/flight-api/flights/stopsType
    @GetMapping("/flights/stopsType/{stopsType}")
    public ResponseEntity<List<Flight>> getByStopsType(@PathVariable("stopsType")String stopsType){
        List<Flight> flights= flightService.getByStopsType(stopsType);
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","get by stopsType");
        return  ResponseEntity.ok().headers(headers).body(flights);
    }
    //http://localhost:8082/flight-api/flights/dateOfJourney
    @GetMapping("/flights/dateOfJourney/{dateOfJourney}")
    public ResponseEntity<List<Flight>> getByDateOfJourney(@PathVariable("dateOfJourney")String dateOfJourney){
        List<Flight> flights=flightService.getByDateOfJourney(LocalDate.parse(dateOfJourney));
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","get by dateOfJourney");
        return  ResponseEntity.ok().headers(headers).body(flights);
    }
    //http://localhost:8082/flight-api/flights/arrival
    @GetMapping("/flights/arrival/{arrival}")
    public ResponseEntity<List<Flight>> getByArrivalTime(@PathVariable("arrival") String arrival){
        List<Flight> flights=flightService.getByArrival(LocalDateTime.parse(arrival));
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","get by dateOfJourney");
        return  ResponseEntity.ok().headers(headers).body(flights);
    }
    //http://localhost:8082/flight-api/flights/departure
    @GetMapping("/flights/departure/{departure}")
    public ResponseEntity<List<Flight>> getByDepartureTime(@PathVariable("departure")String departure){
        List<Flight> flights= flightService.getByDeparture(LocalDateTime.parse(departure));
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","get by departure");
        return  ResponseEntity.ok().headers(headers).body(flights);
    }
    //http://localhost:8082/flight-api/flights/duration
    @GetMapping("/flights/duration/{duration}")
    public ResponseEntity<List<Flight>> getByDuration(@PathVariable("duration")String duration){
        List<Flight> flights= flightService.getByDuration(duration);
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","get by duration");
        return  ResponseEntity.ok().headers(headers).body(flights);
    }
    //http://localhost:8082/flight-api/flights/classType
    @GetMapping("/flights/classType/{classType}")
    public ResponseEntity<List<Flight>> getByClassType(@PathVariable("classType")String classType){
        List<Flight> flights=flightService.getByClassType(classType);
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","get by classType");
        return  ResponseEntity.ok().headers(headers).body(flights);
    }
    //http://localhost:8082/flight-api/flights/source/destination
    @GetMapping("/flights/source/{source}/destination/{destination}")
    public ResponseEntity<List<Flight>> getBySourceAndDuration(@PathVariable("source")String source,@PathVariable("destination")String destination){
        List<Flight> flights=flightService.getBySourceAndDestination(source,destination);
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","get by source"+source+" and destination "+destination);
        return  ResponseEntity.ok().headers(headers).body(flights);
    }
    //http://localhost:8082/flight-api/flights/airlineName/classType
    @GetMapping("/flights/airlineName/{airlineName}/classType/{classType}")
    public ResponseEntity<List<Flight>> getByAirlineNameAndClassType(@PathVariable("airlineName")String airlineName,@PathVariable("classType")String classType){
        List<Flight> flights= flightService.getByAirlineNameAndClassType(airlineName,classType);
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","get by airlineName"+airlineName+"classType"+classType);
        return  ResponseEntity.ok().headers(headers).body(flights);
    }
    //http://localhost:8082/flight-api/flights/airlineName/destination
    @GetMapping("/flights/airlineName/{airlineName}/destination/{destination}")
    public ResponseEntity<List<Flight>> getByAirlineNameAndDestination(@PathVariable("airlineName")String airlineName,@PathVariable("destination")String destination){
        List<Flight> flights= flightService.getByAirlineNameAndDestination(airlineName,destination);
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","get by airlineName"+airlineName+"destination"+destination);
        return  ResponseEntity.ok().headers(headers).body(flights);
    }
    //http://localhost:8082/flight-api/flights/airlineName/dateOfJourney
    @GetMapping("/flights/airlineName/{airlineName}/dateOfJourney/{dateOfJourney}")
    public ResponseEntity<List<Flight>> getByAirlineNameAndDateOfJourney(@PathVariable("airlineName")String airlineName, @PathVariable("dateOfJourney")LocalDate dateOfJourney){
        List<Flight> flights= flightService.getByAirlineNameAndDateOfJourney(airlineName,dateOfJourney);
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","get by airlineName"+airlineName+"dateOfJourney"+dateOfJourney);
        return  ResponseEntity.ok().headers(headers).body(flights);
    }
}
