package edu.miu.cs.cs544.flightservice.domain;

import javax.persistence.*;

@Entity
public class AirPort {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(length = 3)
    private String code;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public AirPort(){}

    public AirPort(String code, String name, Address address) {
        this.address = address;
        this.code = code;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
