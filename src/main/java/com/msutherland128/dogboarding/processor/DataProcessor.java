package com.msutherland128.dogboarding.processor;

import com.msutherland128.dogboarding.model.CsvContents;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.StringJoiner;

@Component
public class DataProcessor {

//    private Scanner scanner;
//
//    public DataProcessor(Scanner scanner) {
//        this.scanner = scanner;
//    }

    public void printAllData(ArrayList<CsvContents> csvContents) {
        System.out.println("Printing all data:");
        for (CsvContents row : csvContents) {
            System.out.println(row.toString());
        }
    }

    public void printAverageCost(ArrayList<CsvContents> csvContents) {
        double runningTotal = 0;
        for (CsvContents row : csvContents) {
            runningTotal += row.getCost();
        }
        double averageCost = runningTotal / csvContents.size();
        System.out.println("The average cost is: £" + averageCost);

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

    public void printBreakdownByPayor(ArrayList<CsvContents> csvContents) {

        System.out.print("Please enter the payor name: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        int counter = 0;
        double totalCost = 0;
        ArrayList<String> dogs = new ArrayList<>();

        for (CsvContents row : csvContents) {
            if (userInput.equalsIgnoreCase(row.getPayor())) {
                totalCost += row.getCost();
                dogs.add(row.getName());
            } else {
                counter++;
            }
        }

        ArrayList<String> updatedDogsList = removeDuplicates(dogs);

        // StringJoiner used to remove [] from printed list and comma separate with white space
        StringJoiner updatedDogsListJoiner = new StringJoiner(", ");

        for (String dog : updatedDogsList) {
            updatedDogsListJoiner.add(dog);
        }

        if (counter == csvContents.size()){
            System.out.println("No payor by name " + userInput + " found in file.");
        } else {
            System.out.println("The total cost for payor " + userInput + " is £" + totalCost);
            System.out.println("The dogs associated to payor " + userInput + " are: " + updatedDogsListJoiner);
        }

    }

    private <T>ArrayList<T> removeDuplicates(ArrayList<T> dogsArrayList) {
        LinkedHashSet<T> set = new LinkedHashSet<>();
        set.addAll(dogsArrayList);
        dogsArrayList.clear();
        dogsArrayList.addAll(set);
        return dogsArrayList;
    }

}
