package com.msutherland128.dogboarding.userinput;

import com.msutherland128.dogboarding.model.CsvContents;
import com.msutherland128.dogboarding.processor.DataProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;

@Component
public class MainMenu implements Processor {

    private CsvContents csvContents;
    private DataProcessor dataProcessor;

    public MainMenu(CsvContents csvContents, DataProcessor dataProcessor) {
        this.csvContents = csvContents;
        this.dataProcessor = dataProcessor;
    }

    @Override
    public void process(Exchange exchange) throws Exception {

        // todo - assign to String object rather than arrayList?
        // String csvContents = exchange.getIn().getBody(String.class);
        ArrayList<CsvContents> csvContents = exchange.getIn().getBody(ArrayList.class);
        exchange.getIn().setBody(mainMenuOptions(csvContents));

    }

    private ArrayList<CsvContents> mainMenuOptions(ArrayList<CsvContents> csvContents) {

            boolean continueMenu = true;

            while (continueMenu) {

                System.out.println("+-----------------------------+");
                System.out.println("| 1. List all Data            |");
                System.out.println("| 2. Average Cost             |");
                System.out.println("| 3. Average cost by Dog name |");
                System.out.println("| 0. Exit                     |");
                System.out.println("+-----------------------------+");

                System.out.print("Please, enter your option: ");

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
                        dataProcessor.printTotalCostPerDog(csvContents);
                        break;

                    case 0:
                        System.out.println("Exiting menu.");
                        continueMenu = false;
                        break;
                }

            }

            return csvContents;
        }

}

