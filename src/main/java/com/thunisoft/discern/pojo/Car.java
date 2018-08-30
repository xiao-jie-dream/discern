package com.thunisoft.discern.pojo;

import java.util.List;

public class Car {
    private String log_id;
    private LocationResult locationResult;
    private List<Result> result;

    public String getLog_id() {
        return log_id;
    }

    public void setLog_id(String log_id) {
        this.log_id = log_id;
    }

    public LocationResult getLocationResult() {
        return locationResult;
    }

    public void setLocationResult(LocationResult locationResult) {
        this.locationResult = locationResult;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }
}
