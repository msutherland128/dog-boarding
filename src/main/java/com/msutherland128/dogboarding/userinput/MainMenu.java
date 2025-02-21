package com.msutherland128.dogboarding.userinput;

import com.msutherland128.dogboarding.model.CsvContents;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;

@Component
public class MainMenu implements Processor {

    private CsvContents csvContents;

    public MainMenu(CsvContents csvContents) {
        this.csvContents = csvContents;
    }

    @Override
    public void process(Exchange exchange) throws Exception {

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
                        printAllData(csvContents);

                    case 2:
                        printAverageCost();
                }

                continueMenu =false;
            }

            return csvContents;
        }


    private void printAllData(ArrayList<CsvContents> csvContents) {
        System.out.println("Printing all data... but how?");
        for(CsvContents row : csvContents) {
            System.out.println(row.toString());
        }
    }

    private void printAverageCost() {
    }

}

