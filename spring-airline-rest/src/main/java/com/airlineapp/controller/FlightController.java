package com.airlineapp.controller;

import com.airlineapp.model.Flight;
import com.airlineapp.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/flight-api")
public class FlightController {
    @Autowired
    private IFlightService flightService;

    //http://localhost:8082/flight-api/flights
   @PostMapping("/flights")
   public Flight addFlight(@RequestBody Flight flight){
        return flightService.addFlight(flight);
    }
    @PutMapping("/flights")
    public void updateFlight(@RequestBody Flight flight){
        flightService.updateFlight(flight);
    }
    @DeleteMapping("/flights/flightId/{flightId}")
    public void deleteFlight(@PathVariable("flightId") int flightId){
       flightService.deleteFlight(flightId);

    }
    //http://localhost:8082/flight-api/flights
    @GetMapping("/flights")
    public List<Flight> getAll(){
       return flightService.getAll();
    }
    //http://localhost:8082/flight-api/flights/flightId
    @GetMapping("flights/flightId/{flightId}")
    public Flight getByFlightId(@PathVariable("flightId") int flightId){
       return flightService.getByFlightId(flightId);

    }
    //http://localhost:8082/flight-api/flights/flightName
    @GetMapping("flights/flightName/{flightName}")
    public List<Flight> getByFlightName(@PathVariable("flightName") String flightName){
       return flightService.getByFlightName(flightName);

    }
    //http://localhost:8082/flight-api/flights/ticketCost
    @GetMapping("flights/ticketCost/{ticketCost}")
    public List<Flight> getByTicketCost(@PathVariable("ticketCost") double ticketCost){
        return flightService.getByTicketCost(ticketCost);
    }
    //http://localhost:8082/flight-api/flights/airlineName
    @GetMapping("/flights/airlineName/{airlineName}")
    public List<Flight> getByAirlineName(@PathVariable("airlineName")String airlineName){
    return flightService.getByAirlineName(airlineName);
    }
    //http://localhost:8082/flight-api/flights/stopsType
    @GetMapping("/flights/stopsType/{stopsType}")
    public List<Flight> getByStopsType(@PathVariable("stopsType")String stopsType){
        return flightService.getByStopsType(stopsType);
    }
    //http://localhost:8082/flight-api/flights/dateOfJourney
    @GetMapping("/flights/dateOfJourney/{dateOfJourney}")
    public List<Flight> getByDateOfJourney(@PathVariable("dateOfJourney")String dateOfJourney){
        return flightService.getByDateOfJourney(LocalDate.parse(dateOfJourney));
    }
    //http://localhost:8082/flight-api/flights/arrival
    @GetMapping("/flights/arrival/{arrival}")
    public List<Flight> getByArrivalTime(@PathVariable("arrival") String arrival){
        return flightService.getByArrival(LocalDateTime.parse(arrival));
    }
    //http://localhost:8082/flight-api/flights/departure
    @GetMapping("/flights/departure/{departure}")
    public List<Flight> getByDepartureTime(@PathVariable("departure")String departure){
        return flightService.getByDeparture(LocalDateTime.parse(departure));
    }
    //http://localhost:8082/flight-api/flights/duration
    @GetMapping("/flights/duration/{duration}")
    public List<Flight> getByDuration(@PathVariable("duration")String duration){
        return flightService.getByDuration(duration);
    }
    //http://localhost:8082/flight-api/flights/classType
    @GetMapping("/flights/classType/{classType}")
    public List<Flight> getByClassType(@PathVariable("classType")String classType){
        return flightService.getByClassType(classType);
    }
    //http://localhost:8082/flight-api/flights/source/destination
    @GetMapping("/flights/source/{source}/destination/{destination}")
    public List<Flight> getBySourceAndDuration(@PathVariable("source")String source,@PathVariable("destination")String destination){
        return flightService.getBySourceAndDestination(source,destination);
    }
    //http://localhost:8082/flight-api/flights/airlineName/classType
    @GetMapping("/flights/airlineName/{airlineName}/classType/{classType}")
    public List<Flight> getByAirlineNameAndClassType(@PathVariable("airlineName")String airlineName,@PathVariable("classType")String classType){
        return flightService.getByAirlineNameAndClassType(airlineName,classType);
    }
    //http://localhost:8082/flight-api/flights/airlineName/destination
    @GetMapping("/flights/airlineName/{airlineName}/destination/{destination}")
    public List<Flight> getByAirlineNameAndDestination(@PathVariable("airlineName")String airlineName,@PathVariable("destination")String destination){
        return flightService.getByAirlineNameAndDestination(airlineName,destination);
    }
    //http://localhost:8082/flight-api/flights/airlineName/dateOfJourney
    @GetMapping("/flights/airlineName/{airlineName}/dateOfJourney/{dateOfJourney}")
    public List<Flight> getByAirlineNameAndDateOfJourney(@PathVariable("airlineName")String airlineName, @PathVariable("dateOfJourney")LocalDate dateOfJourney){
        return flightService.getByAirlineNameAndDateOfJourney(airlineName,dateOfJourney);
    }
}
