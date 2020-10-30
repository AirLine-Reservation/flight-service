package edu.miu.cs.cs544.flightservice.controller;

import edu.miu.cs.cs544.flightservice.domain.Address;
import edu.miu.cs.cs544.flightservice.domain.AirPort;
import edu.miu.cs.cs544.flightservice.repository.AirPortRepository;
import edu.miu.cs.cs544.flightservice.service.AirPortServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class AirPortControllerTest {

    @Autowired
    private AirPortController airPortController;

    @Autowired
    private AirPortServiceImpl airPortService;

    @MockBean
    private AirPortRepository airPortRepository;

    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllAirPorts() {
        Address address = new Address("Korean St","Asmara","Maekel","5534");
        Address address1 = new Address("Bure St","Addis Ababa","Addis Abeba","3234");
        when(airPortRepository.findAll()).
                thenReturn(Stream.of(new AirPort("ER","Eritrean Airport", address),
                        new AirPort("ET","Ethiopian Airport", address1)).collect(Collectors.toList()));
        assertEquals(2, airPortController.getAllAirPorts().size());
    }
}