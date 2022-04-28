package com.airlines;

import com.airlines.model.City;
import com.airlines.model.Flight;
import com.airlines.model.FlightName;
import com.airlines.service.IFlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class AirlinesServicesApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(AirlinesServicesApplication.class, args);

	}
	@Autowired
	IFlightService flightService;

	@Override
	public void run(String... args) throws Exception {
		Flight flight =new Flight(FlightName.AIRINDIA, City.BANGALORE,City.HYDERABAD,2022/5/4,2022/5/4/3/30,2022/5/4/4/30,5000,80);
		flightService.addFlight(flight);
		flightService.updateFlight(1,2022/5/6/6/30,2022/5/6/7/30);
		System.out.println(flightService.getFlightById(1));
		System.out.println(flightService.getFlightByName("AIRINDIA"));
		flightService.getAllFlightDetalis().forEach(System.out::println);
		flightService.getAllFlights("bangalore","hyderabad").forEach(System.out::println);


	}
}
