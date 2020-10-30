package edu.miu.cs.cs544.flightservice.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Flight implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private AirLine airLine;

    @ManyToOne
    private AirPort origin;

    @ManyToOne
    private AirPort destination;

    private String flightNumber;
    private Integer capacity;
    private Double price;
    @Temporal(TemporalType.DATE)
    private Date arrivalDate;
    @Temporal(TemporalType.TIME)
    private Date arrivalTime;
    @Temporal(TemporalType.DATE)
    private Date departureDate;
    @Temporal(TemporalType.TIME)
    private Date departureTime;
    public Flight(){}

    public Flight(Integer id, AirLine airLine, AirPort origin, AirPort destination,
                  String flightNumber, Integer capacity, Double price,
                  Date arrivalDate, Date arrivalTime, Date departureDate, Date departureTime) {
        this.id = id;
        this.airLine = airLine;
        this.origin = origin;
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.capacity = capacity;
        this.price = price;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AirLine getAirLine() {
        return airLine;
    }

    public void setAirLine(AirLine airLine) {
        this.airLine = airLine;
    }

    public AirPort getOrigin() {
        return origin;
    }

    public void setOrigin(AirPort airPort) {
        this.origin = airPort;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public AirPort getDestination() {
        return destination;
    }

    public void setDestination(AirPort destination) {
        this.destination = destination;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }
}
