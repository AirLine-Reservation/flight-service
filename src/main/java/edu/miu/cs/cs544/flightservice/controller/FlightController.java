package edu.miu.cs.cs544.flightservice.controller;

import edu.miu.cs.cs544.flightservice.domain.AirLine;
import edu.miu.cs.cs544.flightservice.domain.Flight;
import edu.miu.cs.cs544.flightservice.service.FlightService;
import edu.miu.cs.cs544.flightservice.service.response.AirLineResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/flight/{airportCode}/airlines")
    public Collection<AirLineResponse> getAllAirlinesFlyingOut(@PathVariable String airportCode) throws IOException {
        return flightService.findDepartingAirlines(airportCode);
    }

    @GetMapping("/flights/from/{origin}/to/{destination}/on/{departureDate}")
    public Collection<Flight> getAllFlightsBetween(@PathVariable String origin, @PathVariable String destination, @PathVariable String departureDate) throws ParseException {
        //Date date = new SimpleDateFormat("MM dd, yyyy").parse(departureDate);
//        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(departureDate);
//        System.out.println("Date =" +date.toString());
        return flightService.findFlightsBetween(origin, destination, departureDate);
    }
}
