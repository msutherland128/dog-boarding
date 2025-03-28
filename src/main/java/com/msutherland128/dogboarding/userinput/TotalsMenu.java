package com.msutherland128.dogboarding.userinput;

import com.msutherland128.dogboarding.model.CsvContents;
import com.msutherland128.dogboarding.processor.DataProcessor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;

@Component
public class TotalsMenu {

    private CsvContents csvContents;
    private DataProcessor dataProcessor;

    public TotalsMenu(CsvContents csvContents, DataProcessor dataProcessor) {
        this.csvContents = csvContents;
        this.dataProcessor = dataProcessor;
    }

    public void totalsMenuOptions(ArrayList<CsvContents> csvContents) {

        boolean continueTotalMenu = true;
        while (continueTotalMenu) {

            System.out.println("Select an option:");
            System.out.println("+--------------------------------+");
            System.out.println("|           Totals Menu          |");
            System.out.println("| 1. Total Earned (inc fees)     |");
            System.out.println("| 2. Total Earned (without fees) |");
            System.out.println("| 3. Total Fees Paid             |");
            System.out.println("| 4. Total Per Year              |");
            System.out.println("| 5. Return to Main Menu         |");
            System.out.println("+--------------------------------+");

            Scanner totalScanner = new Scanner(System.in);
            int userSelection = totalScanner.nextInt();

            switch(userSelection) {
                case 1:
                    break;
                case 2:
                    dataProcessor.printTotalEarned(csvContents, userSelection);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    continueTotalMenu = false;
                    break;
                default:
                    System.out.println("Invalid input. Please enter options 1 to 5.");
            }

        }

    }


}
