package edu.miu.cs.cs544.flightservice.service;

import edu.miu.cs.cs544.flightservice.domain.Flight;
import edu.miu.cs.cs544.flightservice.service.response.AirLineResponse;

import java.util.Collection;

public interface FlightService {
    Collection<AirLineResponse> findDepartingAirlines(String code);
    Collection<Flight> findFlightsBetween(String originCode, String destinationCode, String departureDate);
}
