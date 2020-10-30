package edu.miu.cs.cs544.flightservice.service.response;

import javax.persistence.Column;
import java.io.Serializable;

public class AirLineResponse implements Serializable {

    private Integer id;
    private String code;
    private String name;
    private String history;

    public AirLineResponse(){}
    public AirLineResponse(Integer id,String code, String name, String history) {
        this.id = id;
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
