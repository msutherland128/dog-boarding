package com.msutherland128.dogboarding.userinput;

import com.msutherland128.dogboarding.model.CsvContents;
import com.msutherland128.dogboarding.processor.DataProcessor;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

@Component
public class DateMenu {

    private CsvContents csvContents;
    private DataProcessor dataProcessor;

    public DateMenu(CsvContents csvContents, DataProcessor dataProcessor) {
        this.csvContents = csvContents;
        this.dataProcessor = dataProcessor;
    }

    public void dateMenuOptions(ArrayList<CsvContents> csvContents) throws ParseException {

        boolean continueDateMenu = true;

        while (continueDateMenu) {

            System.out.println("+--------------------------------+");
            System.out.println("|           Date Menu            |");
            System.out.println("| 1. Total Earned Per Month      |");
            System.out.println("| 2. Total Earned Per Year       |");
            System.out.println("| 3. Total Earned Current Month  |");
            System.out.println("| 4. Return to Total Menu        |");
            System.out.println("+--------------------------------+");

            System.out.print("Please enter your option: ");

            Scanner dateScanner = new Scanner(System.in);
            int userSelection = dateScanner.nextInt();

            switch (userSelection) {
                case 1:
                    dataProcessor.printTotalPerMonth(csvContents);
                    break;
                case 2:
                    dataProcessor.printTotalPerYear(csvContents);
                    break;
                case 3:
                    dataProcessor.printTotalForCurrentMonth(csvContents);
                    break;
                case 4:
                    System.out.println("Returning to Totals Menu.");
                    continueDateMenu = false;
                default:
                    System.out.println("Invalid input. Please enter options 1 to 4.");

            }


        }

    }




}
