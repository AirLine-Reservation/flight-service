package edu.miu.cs.cs544.flightservice.controller;

import edu.miu.cs.cs544.flightservice.domain.AirPort;
import edu.miu.cs.cs544.flightservice.service.AirPortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/airports")
public class AirPortController {

    @Autowired
    private AirPortService airportService;

    @GetMapping()
    public Collection<AirPort> getAllAirPorts(){
        return airportService.getAllAirPorts();
    }





}
