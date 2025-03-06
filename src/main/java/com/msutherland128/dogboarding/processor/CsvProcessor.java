package com.msutherland128.dogboarding.processor;

import com.msutherland128.dogboarding.model.CsvContents;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CsvProcessor implements Processor {

    private final CsvContents csvContents;

    public CsvProcessor (CsvContents csvContents) {
        this.csvContents = csvContents;
    }

    @Override
    public void process(Exchange exchange) throws Exception {

        String[] csvRows = csvParser(exchange.getIn().getBody(String.class));
        exchange.getIn().setBody(csvMessageBodySetter(csvRows));

    }

        private ArrayList<CsvContents> csvMessageBodySetter(String[] csvRows) {
            ArrayList<CsvContents> csvContents = new ArrayList<>();

            for (int x = 0; x < csvRows.length; x++) {
                // ignore header row
                if (x > 0) {
                    CsvContents csvrow = new CsvContents();
                    String[] csvColumns = csvRows[x].split(",");
                    for (int y = 0; y < csvColumns.length; y++) {
                        if (y == 0) {
                            csvrow.setName(csvColumns[y]);
                        } else if (y == 1) {
                            csvrow.setDate(csvColumns[y]);
                        } else {
                            csvrow.setCost(Double.valueOf(csvColumns[y]));
                        }
                    }
                    csvContents.add(csvrow);

                }
            }
            return csvContents;
        }

        private String[] csvParser(String csvMessageBody) {
            return csvMessageBody.split("\n");
        }


}
