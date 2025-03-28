package com.msutherland128.dogboarding.model;

import org.springframework.stereotype.Component;

@Component
public class CsvContents {

    private String name;
    private String date;
    private Double cost;
    private Double fees;
    private String provider;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return  "Dog Name: " + name +
                ", Boarding Date: " + date +
                ", Cost: £" + cost +
                ", Fees: £" + fees +
                ", Provider: " + provider;
    }
}
