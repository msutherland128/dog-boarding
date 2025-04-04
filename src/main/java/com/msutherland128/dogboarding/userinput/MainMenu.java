package com.msutherland128.dogboarding.userinput;

import com.msutherland128.dogboarding.model.CsvContents;
import com.msutherland128.dogboarding.processor.DataProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

@Component
public class MainMenu implements Processor {

    private CsvContents csvContents;
    private DataProcessor dataProcessor;
    private TotalsMenu totalsMenu;

    public MainMenu(CsvContents csvContents, DataProcessor dataProcessor, TotalsMenu totalsMenu) {
        this.csvContents = csvContents;
        this.dataProcessor = dataProcessor;
        this.totalsMenu = totalsMenu;
    }

    @Override
    public void process(Exchange exchange) throws Exception {

        // todo - assign to String object rather than arrayList?
        // String csvContents = exchange.getIn().getBody(String.class);
        ArrayList<CsvContents> csvContents = exchange.getIn().getBody(ArrayList.class);
        exchange.getIn().setBody(mainMenuOptions(csvContents));

    }

    private ArrayList<CsvContents> mainMenuOptions(ArrayList<CsvContents> csvContents) throws ParseException {

            boolean continueMenu = true;

            while (continueMenu) {

                System.out.println("+-----------------------------+");
                System.out.println("|          Main Menu          |");
                System.out.println("| 1. Print all Data           |");
                System.out.println("| 2. Average Cost             |");
                System.out.println("| 3. Total Earned             |");
                System.out.println("| 4. Total per Dog            |");
                System.out.println("| 5. Breakdown by Provider    |");
                System.out.println("| 6. Summary by Provider      |");
                System.out.println("| 0. Exit                     |");
                System.out.println("+-----------------------------+");

                System.out.print("Please enter your option: ");

                Scanner menuScanner = new Scanner(System.in);
                int mainMenuSelection = menuScanner.nextInt();

                switch(mainMenuSelection) {
                    case 1:
                        dataProcessor.printAllData(csvContents);
                        break;

                    case 2:
                        dataProcessor.printAverageCost(csvContents);
                        break;

                    case 3:
                        totalsMenu.totalsMenuOptions(csvContents);
                        break;

                    case 4:
                        dataProcessor.printTotalCostPerDog(csvContents);
                        break;

                    case 5:
                        dataProcessor.printBreakdownByProvider(csvContents);
                        break;

                    case 6: //todo - needs work
                        dataProcessor.printSummaryByProvider(csvContents);
                        break;

                    case 0:
                        System.out.println("Exiting menu.");
                        continueMenu = false;
                        break;

                    default:
                        System.out.println("Invalid input. Please enter options 0 to 6.");
                }

            }

            return csvContents;
        }

}

