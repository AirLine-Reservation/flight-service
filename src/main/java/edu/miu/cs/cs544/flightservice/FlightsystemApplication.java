package edu.miu.cs.cs544.flightservice;

import edu.miu.cs.cs544.flightservice.repository.AirPortRepository;
import edu.miu.cs.cs544.flightservice.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableSwagger2
public class FlightsystemApplication  {

    @Autowired
    private AirPortRepository airportRepository;

    @Autowired
    private FlightRepository flightRepository;

    private DateFormat dateFormat = new SimpleDateFormat("MM dd, yyyy hh:mm");
    private DateFormat dateFormat1 = new SimpleDateFormat("MM dd, yyyy");

    public static void main(String[] args) {
        SpringApplication.run(FlightsystemApplication.class, args);

    }

        @Bean
        public RestTemplate restTemplate(){
            return new RestTemplate();
    }



//    @Override
//    public void run(String... args) throws Exception {

//        /* Airline objects */
//        Airline airline1 = new Airline("UA","United Airlines", "HISTORY1");
//        Airline airline2 = new Airline("AC","Air Canada", "HISTORY2");
//        Airline airline3 = new Airline("OM","MIAT-MONGOLIAN AIRLINES", "HISTORY3");
//
//        Address address1 = new Address("1000N 4th str","Fairfield","IA","52557");
//        Address address2 = new Address("1000N 4th str","Chicago","IL","52557");
//        Address address3 = new Address("1000N 4th str","Chicago","IL","52556");
//        /* Airport*/
//   Airport cid = new Airport("CID", "Eastern Iowa Airport", address1);
//    Airport ams = new Airport("AMS", "Schiphol", address2);
//    Airport lhr = new Airport("LHR", "London Heathrow", address3);
//    Airport fra = new Airport("FRA", "Frankfurt International Airport", address1);
//
//
//        /* Flight */
//        Flight flight1 = new Flight("1248", 500, dateFormat1.parse("05 21, 2020"),
//                dateFormat.parse("05 21, 2020 23:00"),
//                dateFormat1.parse("05 21, 2020"), dateFormat.parse("05 21, 2020 21:00"),250.0, airline1, cid, fra);
//        Flight flight2 = new Flight("1249", 500,dateFormat1.parse("05 22, 2020"),
//                dateFormat.parse("05 22, 2020 14:00"), dateFormat1.parse("05 20, 2020"),
//                dateFormat.parse("05 20, 2020 23:45"),280.3, airline2, cid, lhr);
//        Flight flight3 = new Flight("1250", 500,
//                dateFormat1.parse("03 14, 2020"), dateFormat.parse("03 13, 2020 10:00"),
//                dateFormat1.parse("03 13, 2020"), dateFormat.parse("05 21, 2020 08:20"),
//                450.30, airline3, fra, lhr);
//        Flight flight4 = new Flight("1251", 500,
//                dateFormat1.parse("04 21, 2020"), dateFormat.parse("04 21, 2020 23:00"),
//                dateFormat1.parse("04 21, 2020"), dateFormat.parse("04 21, 2020 20:00"),
//                320.0, airline1, fra, ams);
//
//
//
//        flightRepository.saveAll(Arrays.asList(flight1, flight2, flight3,flight4));
//    }
}
