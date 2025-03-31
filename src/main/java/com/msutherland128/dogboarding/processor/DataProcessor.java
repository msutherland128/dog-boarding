package com.msutherland128.dogboarding.processor;

import com.msutherland128.dogboarding.model.CsvContents;
import org.springframework.stereotype.Component;

import java.util.*;

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

    public void printTotalEarned(ArrayList<CsvContents> csvContents, int userSelection) {

        double totalWithoutFees = 0;
        double totalFeesPaid = 0;
        for(CsvContents row : csvContents){
            totalFeesPaid += row.getFees();
            totalWithoutFees += row.getCost();
        }

        if (userSelection == 1) {
            double totalWithFees = totalWithoutFees + totalFeesPaid;
            System.out.println("Total with fees is: £" + totalWithFees);
        } else if (userSelection == 2) {
            System.out.println("Total without fees is: £" + totalWithoutFees);
        } else if (userSelection == 3) {
            System.out.println("Total fees paid is: £" + totalFeesPaid);
        }

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

    public void printBreakdownByProvider(ArrayList<CsvContents> csvContents) {

        System.out.print("Please enter the provider name: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        int counter = 0;
        double totalCostPerProvider = 0;
        double totalCost = 0;
        ArrayList<String> dogs = new ArrayList<>();

        for (CsvContents row : csvContents) {
            totalCost += row.getCost();
            if (userInput.equalsIgnoreCase(row.getProvider())) {
                totalCostPerProvider += row.getCost();
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
            System.out.println("No provider by name " + userInput + " found in file.");
        } else {
            float percentageOfTotal = (float) (totalCostPerProvider / totalCost * 100);
            System.out.println("The total amount made for " + userInput + " provider is £" + totalCostPerProvider);
            System.out.print("The amount made for " + userInput + " is ");
            System.out.printf("%.2f", percentageOfTotal);
            System.out.println(" % of the total amount made: " + totalCost);
            System.out.println("The dogs associated to " + userInput  + " provider are: " + updatedDogsListJoiner);
        }

    }

    public void printSummaryByProvider(ArrayList<CsvContents> csvContents) {

        /* todo - method should:
        print provider name
        total amount made per provider
        percentage of the gross total per provider
        fees charged per provider (only to be inc if fees > 0)
         */
        System.out.println("Summary of providers:");

        // todo needs work.. need to be able to get providers into a hashset (only unique values) and get a running total per provider
        ArrayList<String> providerList = new ArrayList<>();
        for (CsvContents row : csvContents) {
            providerList.add(row.getProvider());
        }

        System.out.println(providerList);

        ArrayList<String> updatedProviderList = removeDuplicates(providerList);
        System.out.println(updatedProviderList);

    }

    private <T>ArrayList<T> removeDuplicates(ArrayList<T> arrayList) {
        LinkedHashSet<T> set = new LinkedHashSet<>();
        set.addAll(arrayList);
        arrayList.clear();
        arrayList.addAll(set);
        return arrayList;
    }

}
