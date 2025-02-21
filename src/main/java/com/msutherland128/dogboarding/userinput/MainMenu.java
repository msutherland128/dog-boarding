package com.msutherland128.dogboarding.userinput;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class MainMenu implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {

            boolean continueMenu = true;

            while (continueMenu) {

                System.out.println("+-----------------------------+");
                System.out.println("| 1. List all Data            |");
                System.out.println("| 2. Average Cost             |");
                System.out.println("| 3. Average cost by Dog name |");
                System.out.println("| 0. Exit                     |");
                System.out.println("+-----------------------------+");

                continueMenu =false;
            }
        }

    }

