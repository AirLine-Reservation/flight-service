package edu.miu.cs.cs544.flightservice.service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import edu.miu.cs.cs544.flightservice.domain.AirLine;
import edu.miu.cs.cs544.flightservice.domain.AirPort;
import edu.miu.cs.cs544.flightservice.repository.AirPortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.*;

@Service
@Transactional
public class AirPortServiceImpl implements AirPortService {
    @Autowired
    private AirPortRepository airPortRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;

    //@Value("${Ea-final-project.service-name}")
    //@Value("${admin-service.service-name}")
    private String EaFinalProjectServiceName = "admin-service";


    private List<AirPort> airPortListCache = new ArrayList<>();


    @Override
    @HystrixCommand(fallbackMethod = "defaultGetAllCountries")
    public List<AirPort> getAllAirPorts() {

         //String tokenValue = "Bearer  eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU5MjQ0Mzg3OSwiaWF0IjoxNTkyNDA3ODc5fQ.-cveFnRXWCuguc9NxJqNk3otrnP4HYQ_-HT--7GNhS0";

        /*restTemplate.getInterceptors().add(new ClientHttpRequestInterceptor() {

            @Override
            public ClientHttpResponse intercept(HttpRequest request,
                                                byte[] body,
                                                ClientHttpRequestExecution execution)
                    throws java.io.IOException {
                request.getHeaders().add("Authorization", tokenValue);
                return execution.execute(request,body);
            }
        });*/

        /*URI uri = UriComponentsBuilder.fromUriString(lookupUrlFor(EaFinalProjectServiceName) + "/airPorts")
                .pathSegment(tokenValue)
                .build()
                .toUri();*/

        //HttpRequest request = null;
        //restTemplate.exchange(uri, HttpMethod.POST, (HttpEntity<?>) request, AirPort.class);

        //HttpHeaders headers = new HttpHeaders();
        //headers.set("Authorization", tokenValue);

        //HttpEntity<List<AirLine>> entityReq = new HttpEntity<>(headers);
        //restTemplate.exchange(lookupUrlFor(EaFinalProjectServiceName) + "/airPorts", HttpMethod.GET, entityReq, List.class);

        restTemplate.getInterceptors().add(
              new BasicAuthorizationInterceptor("admin", "354eb0af-082d-4f37-adce-5baa0199801d"));
        String url = lookupUrlFor(EaFinalProjectServiceName) + "/airPorts";
        //airPortListCache = Arrays.asList(restTemplate.exchange(url, HttpMethod.GET, createHttpEntity(), AirPort[].class).getBody());
        return restTemplate.getForObject(lookupUrlFor(EaFinalProjectServiceName) + "/airPorts", List.class);
        //return airPortListCache;
    }

    public List<AirPort> defaultGetAllCountries() {
        return airPortListCache;
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


//    @Override
//    public Collection<AirPort> getAllAirPorts() {
//        return airPortRepository.findAll();
//    }

}
