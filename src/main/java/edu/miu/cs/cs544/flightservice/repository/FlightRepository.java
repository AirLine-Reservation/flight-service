package edu.miu.cs.cs544.flightservice.repository;


import edu.miu.cs.cs544.flightservice.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Date;

public interface FlightRepository extends JpaRepository<Flight,Integer> {

    Collection<Flight> findAllByOriginCode(String code);
    Collection<Flight> findAllByOriginCodeAndDestinationCodeAndDepartureDate(String originCode, String destinationCode, String departureDate);
}
