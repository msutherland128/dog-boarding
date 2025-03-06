package com.msutherland128.dogboarding.processor;

import com.msutherland128.dogboarding.model.CsvContents;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;

@Component
public class DataProcessor {

    public void printAllData(ArrayList<CsvContents> csvContents) {
        System.out.println("Printing all data:");
        for(CsvContents row : csvContents) {
            System.out.println(row.toString());
        }
    }

    public double printAverageCost(ArrayList<CsvContents> csvContents) {
        double runningTotal = 0;
        for(CsvContents row : csvContents) {
            runningTotal += row.getCost();
        }
        double averageCost = runningTotal/csvContents.size();
        System.out.println("The average cost is: £" + averageCost);

        return averageCost;
    }

    public void printTotalCostPerDog(ArrayList<CsvContents> csvContents) {
        // todo - consider dogs with the same name. Implement an id into source file? Or DOB?
        System.out.print("Please enter the dog name: ");

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        int counter = 0;
        double totalPerDog = 0;

        for (CsvContents row : csvContents) {
            counter++;
            if (userInput.equalsIgnoreCase(row.getName())) {
                boolean x = userInput.equalsIgnoreCase(row.getName());
                while (x) {
                    totalPerDog += row.getCost();
                    x = false;
                }
            }
            else if (counter == csvContents.size()){
                System.out.println("No record of " + userInput + " in file.");
                break;
            }

        }

        System.out.println("The total cost for " + userInput + " is £" + totalPerDog);



    }



}
