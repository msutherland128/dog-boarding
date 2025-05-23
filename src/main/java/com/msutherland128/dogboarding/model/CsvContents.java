package com.msutherland128.dogboarding.model;

import org.springframework.stereotype.Component;

@Component
public class CsvContents {

    private String name;
    private String dateFrom;
    private String dateTo;
    private String paymentDate;
    private String provider;
    private Double cost;
    private Double fees;
    private String type;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return  "Dog Name: " + name +
                ", Boarding Date From: " + dateFrom +
                ", Boarding Date To: " + dateTo +
                ", Payment Date: " + paymentDate +
                ", Provider: " + provider +
                ", Cost: £" + cost +
                ", Fees: £" + fees +
                ", Type: " + type;
    }
}
