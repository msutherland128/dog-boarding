package com.msutherland128.dogboarding.processor;

import com.msutherland128.dogboarding.model.CsvContents;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DataProcessor {

    public void printAllData(ArrayList<CsvContents> csvContents) {
        System.out.println("Printing all data:");
        for(CsvContents row : csvContents) {
            System.out.println(row.toString());
        }
    }

    public void printAverageCost(ArrayList<CsvContents> csvContents) {
        double runningTotal = 0;
        for(CsvContents row : csvContents) {
            runningTotal += row.getCost();
        }
        double averageCost = runningTotal/csvContents.size();
        System.out.println("The average cost is: £" + averageCost);
    }

    public void printAverageCostPerDog() {
        // todo - consider dogs with the same name. Implement an id into source file? Or DOB?

    }



}
