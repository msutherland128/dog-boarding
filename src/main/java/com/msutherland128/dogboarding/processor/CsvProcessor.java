package com.msutherland128.dogboarding.processor;

import com.msutherland128.dogboarding.model.CsvContents;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class CsvProcessor implements Processor {

    private final CsvContents csvContents;

    public CsvProcessor (CsvContents csvContents) {
        this.csvContents = csvContents;
    }

    @Override
    public void process(Exchange exchange) throws Exception {

        String[] csvRows = new String[]{exchange.getIn().getBody(String.class)};

        for (String i : csvRows) {
            System.out.println(i);
        }

        for (int x = 0; x < csvRows.length; x++) {
            if (x > 0) {
                String[] csvColumns = csvRows[x].split(",");
                System.out.println("Printing csvColumns: " + csvColumns);
                for (int y = 0; y < csvColumns.length; y++) {
                    if (y == 0){
                        csvContents.setName(csvColumns[y]);
                    } else if (y == 1) {
                        csvContents.setDate(csvColumns[y]);
                    } else {
                        csvContents.setCost(Double.valueOf(csvColumns[y]));
                    }
                }

            }
        }


    }


}
