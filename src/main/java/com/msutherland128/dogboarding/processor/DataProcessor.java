package com.msutherland128.dogboarding.processor;

import com.msutherland128.dogboarding.model.CsvContents;
import com.msutherland128.dogboarding.utils.DataProcessorOperations;
import org.springframework.stereotype.Component;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class DataProcessor {


    private DataProcessorOperations dataProcessorOperations;
    
    public DataProcessor(DataProcessorOperations dataProcessorOperations) {
        this.dataProcessorOperations = dataProcessorOperations;
    }
    
    

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
        System.out.println("The average cost is: £" + dataProcessorOperations.bigDecimalConversion(averageCost));

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
            System.out.println("Total with fees is: £" + dataProcessorOperations.bigDecimalConversion(totalWithFees));
        } else if (userSelection == 2) {
            System.out.println("Total without fees is: £" + dataProcessorOperations.bigDecimalConversion(totalWithoutFees));
        } else if (userSelection == 3) {
            System.out.println("Total fees paid is: £" + dataProcessorOperations.bigDecimalConversion(totalFeesPaid));
        }

    }

    public void printTotalPerMonth(ArrayList<CsvContents> csvContents) {

        try {

            // todo - add most profitable month logic?

        System.out.print("Please enter the year: ");

        Scanner scanner = new Scanner(System.in);
        String userInputYear = scanner.nextLine();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("yyyy");

        Year userInput = Year.parse(userInputYear, yearFormatter);

        double januaryTotal = 0;
        double februaryTotal = 0;
        double marchTotal = 0;
        double aprilTotal = 0;
        double mayTotal = 0;
        double juneTotal = 0;
        double julyTotal = 0;
        double augustTotal = 0;
        double septemberTotal = 0;
        double octoberTotal = 0;
        double novemberTotal = 0;
        double decemberTotal = 0;

        for(CsvContents row : csvContents) {
            String dateFromFile = row.getDateFrom();
            LocalDate fromFile = LocalDate.parse(dateFromFile, dateFormatter);
            if (fromFile.getYear() == userInput.getValue()) {
                ArrayList<String> monthAndAmount = new ArrayList<>();
                monthAndAmount.add(0, String.valueOf(fromFile.getMonth()));
                monthAndAmount.add(1, row.getCost().toString());

                if (Objects.equals(monthAndAmount.get(0), "JANUARY")) {
                    januaryTotal += Double.parseDouble(monthAndAmount.get(1));
                } else if (Objects.equals(monthAndAmount.get(0), "FEBRUARY")) {
                    februaryTotal += Double.parseDouble(monthAndAmount.get(1));
                } else if (Objects.equals(monthAndAmount.get(0), "MARCH")) {
                    marchTotal += Double.parseDouble(monthAndAmount.get(1));
                } else if (Objects.equals(monthAndAmount.get(0), "APRIL")) {
                    aprilTotal += Double.parseDouble(monthAndAmount.get(1));
                } else if (Objects.equals(monthAndAmount.get(0), "MAY")) {
                    mayTotal += Double.parseDouble(monthAndAmount.get(1));
                } else if (Objects.equals(monthAndAmount.get(0), "JUNE")) {
                    juneTotal += Double.parseDouble(monthAndAmount.get(1));
                } else if (Objects.equals(monthAndAmount.get(0), "JULY")) {
                    julyTotal += Double.parseDouble(monthAndAmount.get(1));
                } else if (Objects.equals(monthAndAmount.get(0), "AUGUST")) {
                    augustTotal += Double.parseDouble(monthAndAmount.get(1));
                } else if (Objects.equals(monthAndAmount.get(0), "SEPTEMBER")) {
                    septemberTotal += Double.parseDouble(monthAndAmount.get(1));
                } else if (Objects.equals(monthAndAmount.get(0), "OCTOBER")) {
                    octoberTotal += Double.parseDouble(monthAndAmount.get(1));
                } else if (Objects.equals(monthAndAmount.get(0), "NOVEMBER")) {
                    novemberTotal += Double.parseDouble(monthAndAmount.get(1));
                } else if (Objects.equals(monthAndAmount.get(0), "DECEMBER")) {
                    decemberTotal += Double.parseDouble(monthAndAmount.get(1));
                }
            }
        }

        if (januaryTotal > 0.0 || februaryTotal > 0.0 || marchTotal > 0.0 || aprilTotal > 0.0 || mayTotal > 0.0 || juneTotal > 0.0 || julyTotal > 0.0
                || augustTotal > 0.0 || septemberTotal > 0.0 || octoberTotal > 0.0 || novemberTotal > 0.0 || decemberTotal > 0.0) {
            System.out.println("January " + userInput + " Total is: £" + dataProcessorOperations.bigDecimalConversion(januaryTotal));
            System.out.println("February " + userInput + " Total is: £" + dataProcessorOperations.bigDecimalConversion(februaryTotal));
            System.out.println("March " + userInput + " Total is: £" + dataProcessorOperations.bigDecimalConversion(marchTotal));
            System.out.println("April " + userInput + " Total is: £" + dataProcessorOperations.bigDecimalConversion(aprilTotal));
            System.out.println("May " + userInput + " Total is: £" + dataProcessorOperations.bigDecimalConversion(mayTotal));
            System.out.println("June " + userInput + " Total is: £" + dataProcessorOperations.bigDecimalConversion(juneTotal));
            System.out.println("July " + userInput + " Total is: £" + dataProcessorOperations.bigDecimalConversion(julyTotal));
            System.out.println("August " + userInput + " Total is: £" + dataProcessorOperations.bigDecimalConversion(augustTotal));
            System.out.println("September " + userInput + " Total is: £" + dataProcessorOperations.bigDecimalConversion(septemberTotal));
            System.out.println("October " + userInput + " Total is: £" + dataProcessorOperations.bigDecimalConversion(octoberTotal));
            System.out.println("November " + userInput + " Total is: £" + dataProcessorOperations.bigDecimalConversion(novemberTotal));
            System.out.println("December " + userInput + " Total is: £" + dataProcessorOperations.bigDecimalConversion(decemberTotal));
        } else {
            System.out.println("No data for year: " + userInput);
        }

        } catch (Exception e) {
            System.out.println("Invalid year entered. Ensure this is numeric, containing only 4 digits and formatted correctly yyyy.");
        }

    }

    public void printTotalPerYear(ArrayList<CsvContents> csvContents) {

        System.out.print("Please enter the year: ");

        try {

            Scanner scanner = new Scanner(System.in);
            String userInputYear = scanner.nextLine();

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("yyyy");

            Year userInput = Year.parse(userInputYear, yearFormatter);

        double totalPerYear = 0;
        for (CsvContents row : csvContents) {
            String dateFromFile = row.getDateFrom();
            LocalDate fromFile = LocalDate.parse(dateFromFile, dateFormatter);
            if (fromFile.getYear() == userInput.getValue()) {
                totalPerYear += row.getCost();
            }
        }

        if (totalPerYear > 0.0) {
            System.out.println("Total for " + userInputYear + " is: £" + dataProcessorOperations.bigDecimalConversion(totalPerYear));
        } else {
            System.out.println("No data for : " + userInputYear);
        }

        } catch (Exception e) {
            System.out.println("Invalid year entered. Ensure this is numeric, containing only 4 digits and formatted correctly yyyy.");
        }

    }

    public void printTotalForCurrentMonth(ArrayList<CsvContents> csvContents) throws ParseException {

        Format monthFormatter = new SimpleDateFormat("MM");
        Format yearFormatter = new SimpleDateFormat("yyyy");
        String currentMonth = monthFormatter.format(new Date());
        String currentYear = yearFormatter.format(new Date());

        double totalForCurrentMonth = 0;
        for (CsvContents row : csvContents) {

            String dateFromFile = row.getDateFrom();
            Date formattedDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateFromFile);

            if (monthFormatter.format(formattedDate).equals(currentMonth) && yearFormatter.format(formattedDate).equals(currentYear)) {
                totalForCurrentMonth += row.getCost();
            }
        }

        Month month = Month.of(Integer.parseInt(currentMonth));
        System.out.println("Total for current month " + month + " " + currentYear + " is: £" + dataProcessorOperations.bigDecimalConversion(totalForCurrentMonth));

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
            System.out.println("The total cost for " + userInput + " is £" + dataProcessorOperations.bigDecimalConversion(totalPerDog));
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

        ArrayList<String> updatedDogsList = dataProcessorOperations.removeDuplicates(dogs);

        // StringJoiner used to remove [] from printed list and comma separate with white space
        StringJoiner updatedDogsListJoiner = new StringJoiner(", ");

        for (String dog : updatedDogsList) {
            updatedDogsListJoiner.add(dog);
        }

        if (counter == csvContents.size()){
            System.out.println("No provider by name " + userInput + " found in file.");
        } else {
            double percentageOfTotal = (double) (totalCostPerProvider / totalCost * 100);
            System.out.println("The total amount made for " + userInput + " provider is £" + dataProcessorOperations.bigDecimalConversion(totalCostPerProvider));
            System.out.print("The amount made for " + userInput + " is ");
            System.out.print(dataProcessorOperations.bigDecimalConversion(percentageOfTotal));
            System.out.println("% of the total amount made: £" + dataProcessorOperations.bigDecimalConversion(totalCost));
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

        ArrayList<String> updatedProviderList = dataProcessorOperations.removeDuplicates(providerList);
        System.out.println(updatedProviderList);

    }

}
