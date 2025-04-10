package com.msutherland128.dogboarding.userinput;

import com.msutherland128.dogboarding.model.CsvContents;
import com.msutherland128.dogboarding.processor.DataProcessor;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

@Component
public class TotalsMenu {

    private CsvContents csvContents;
    private DataProcessor dataProcessor;
    private DateMenu dateMenu;

    public TotalsMenu(CsvContents csvContents, DataProcessor dataProcessor, DateMenu dateMenu) {
        this.csvContents = csvContents;
        this.dataProcessor = dataProcessor;
        this.dateMenu = dateMenu;
    }

    public void totalsMenuOptions(ArrayList<CsvContents> csvContents) throws ParseException {

        boolean continueTotalMenu = true;
        while (continueTotalMenu) {

            System.out.println("+--------------------------------+");
            System.out.println("|           Totals Menu          |");
            System.out.println("| 1. Total Earned (inc fees)     |");
            System.out.println("| 2. Total Earned (without fees) |");
            System.out.println("| 3. Total Fees Paid             |");
            System.out.println("| 4. Total Per Date              |");
            System.out.println("| 5. Return to Main Menu         |");
            System.out.println("+--------------------------------+");

            System.out.print("Please enter your option: ");

            Scanner totalScanner = new Scanner(System.in);
            int userSelection = totalScanner.nextInt();

            if (userSelection == 1 || userSelection == 2 || userSelection == 3) {
                dataProcessor.printTotalEarned(csvContents, userSelection);
            } else if (userSelection == 4) {
                dateMenu.dateMenuOptions(csvContents);
            } else if (userSelection == 5) {
                System.out.println("Returning to Main Menu.");
                continueTotalMenu = false;
            } else {
                System.out.println("Invalid input. Please enter options 1 to 5.");
            }

        }

    }


}
