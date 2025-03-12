package com.msutherland128.dogboarding.processor;

import com.msutherland128.dogboarding.model.CsvContents;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;

@Component
public class DataProcessor {

    public void printAllData(ArrayList<CsvContents> csvContents) {
        System.out.println("Printing all data:");
        for (CsvContents row : csvContents) {
            System.out.println(row.toString());
        }
    }

    public double printAverageCost(ArrayList<CsvContents> csvContents) {
        double runningTotal = 0;
        for (CsvContents row : csvContents) {
            runningTotal += row.getCost();
        }
        double averageCost = runningTotal / csvContents.size();
        System.out.println("The average cost is: £" + averageCost);

        return averageCost;
    }

    public void printTotalCostPerDog(ArrayList<CsvContents> csvContents) {
        // todo - consider dogs with the same name. Implement an id into source file? Or DOB?
        System.out.print("Please enter the dog name: ");

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        double totalPerDog = 0;
        int counter = 0;

        for (CsvContents row : csvContents) {
            if (userInput.equalsIgnoreCase(row.getName())) {
                totalPerDog += row.getCost();
            } else {
                counter++;
            }
        }

        if (counter == csvContents.size()){
            System.out.println("No dog by name " + userInput + " found in file.");
        } else {
            System.out.println("The total cost for " + userInput + " is £" + totalPerDog);
        }

    }

}
