package edu.miu.cs.cs544.flightservice.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import edu.miu.cs.cs544.flightservice.domain.AirLine;
import edu.miu.cs.cs544.flightservice.domain.Flight;
import edu.miu.cs.cs544.flightservice.repository.FlightRepository;
import edu.miu.cs.cs544.flightservice.service.response.AirLineResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private RestTemplate restTemplate;


    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;


    //@Value("${admin-service.service-name}")
    private String EaFinalProjectServiceName = "admin-service";

    private List<Flight> flights = new ArrayList<>();
    private List<AirLine> airLineListCache = new ArrayList<>();

    @Override
    @HystrixCommand(fallbackMethod = "defaultGetAllCountries")
    public List<AirLineResponse> findDepartingAirlines(String airportCode) {
        restTemplate.getInterceptors().add(
                new BasicAuthorizationInterceptor("admin", "354eb0af-082d-4f37-adce-5baa0199801d"));

        return restTemplate.getForObject(lookupUrlFor(EaFinalProjectServiceName) + "/flights/"+airportCode+"/airlines", List.class);

    }

    @Override
    @HystrixCommand(fallbackMethod = "defaultGetAllFlights")
    public List<Flight> findFlightsBetween(String originCode, String destinationCode, String departureDate) {
        restTemplate.getInterceptors().add(
                new BasicAuthorizationInterceptor("admin", "354eb0af-082d-4f37-adce-5baa0199801d"));
        //String url = lookupUrlFor(EaFinalProjectServiceName) + "/flights/from/"+originCode+"/to/"+destinationCode+"/on/"+departureDate;
        flights = restTemplate.getForObject(lookupUrlFor(EaFinalProjectServiceName) + "/flights/from/"+originCode+"/to/"+destinationCode+"/on/"+departureDate, List.class);
        return flights;
    }

    public List<AirLine> defaultGetAllCountries() {
        return airLineListCache;
    }

    public List<Flight> defaultGetAllFlights() {
        return flights;
    }


    private HttpEntity<?> createHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        //headers.setBasicAuth(username, password);

        return new HttpEntity<>(headers);
    }

    private String lookupUrlFor(String appName) {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka(appName, false);
        return instanceInfo.getHomePageUrl();
    }

    public List<AirLineResponse> mapAirline(List<Flight> flightList){
        List<AirLineResponse> airLineResponseList = new ArrayList<>();
        for (Flight flight : flightList){
            System.out.println(flight.getAirLine().getCode());
        }
        return airLineResponseList;
    }

}
