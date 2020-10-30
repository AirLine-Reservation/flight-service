package edu.miu.cs.cs544.flightservice.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@SecondaryTable(name = "history")
public class AirLine {

    @Id
    @GeneratedValue
    private long id;
    @Column(length = 2)
    private String code;
    private String name;
    @Column(table = "history" , length = 2000)
    private String history;

    public AirLine(){}
    public AirLine(String code, String name, String history) {
        this.code = code;
        this.name = name;
        this.history = history;
    }

    public long getId() {
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

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}
