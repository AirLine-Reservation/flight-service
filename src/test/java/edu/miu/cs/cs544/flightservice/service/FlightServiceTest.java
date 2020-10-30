package edu.miu.cs.cs544.flightservice.service;

import edu.miu.cs.cs544.flightservice.controller.FlightController;
import edu.miu.cs.cs544.flightservice.domain.Address;
import edu.miu.cs.cs544.flightservice.domain.AirLine;
import edu.miu.cs.cs544.flightservice.domain.AirPort;
import edu.miu.cs.cs544.flightservice.domain.Flight;
import edu.miu.cs.cs544.flightservice.repository.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class FlightServiceTest {

    @Autowired
    private FlightService flightService;

    @Autowired
    private FlightController flightController;

    @MockBean
    private FlightRepository flightRepository;

    private Flight flight;
    private AirLine airline;
    private Address address;
    private AirPort airPortOrigin;
    private AirPort airPortDestination;
    private DateFormat dateFormat = new SimpleDateFormat("MM dd, yyyy hh:mm");
    private DateFormat dateFormat1 = new SimpleDateFormat("MM dd, yyyy");

    @BeforeEach
    public void setUp() throws ParseException {
        address = new Address("Bure St","Addis Ababa","Addis Abeba","3234");
        airPortOrigin = new AirPort("ET","Ethiopian Airport", address);
        airPortDestination = new AirPort("ER","Eritrean Airport", address);
        airline= new AirLine("ET","Ethiopian Airline", "Successful Airline");
        flight = new Flight(1, airline, airPortOrigin, airPortDestination,"1249", 500, 280.3,
                dateFormat1.parse("05 22, 2020"), dateFormat.parse("05 22, 2020 14:00"),
                dateFormat1.parse("05 20, 2020"), dateFormat.parse("05 20, 2020 23:45"));

    }

    /*@Test
    void get_All_Flights_In_Between() throws ParseException {
        when(flightRepository.findAllByOriginCodeAndDestinationCodeAndDepartureDate(airPortOrigin.getCode(),
                airPortDestination.getCode(),dateFormat1.parse("05 20, 2020"))).
                thenReturn(Stream.of(flight).collect(Collectors.toList()));
        assertEquals(1, flightService.findFlightsBetween(airPortOrigin.getCode()
                , airPortDestination.getCode(),dateFormat1.parse("05 20, 2020")).size());
    }*/
   /* @Test
    void getAirlineByDepartingAirportCode() {
        when(flightRepository.findAllByOriginCode(airPortOrigin.getCode())).
                thenReturn(Arrays.asList(flight));
        assertEquals(Arrays.asList(airline), flightController.getAllAirlinesFlyingOut(airPortOrigin.getCode()));
    }*/
}