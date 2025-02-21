package com.msutherland128.dogboarding.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component
public class ExcelProcessor implements Processor {


    @Override
    public void process(Exchange exchange) throws Exception {

        XSSFWorkbook workbook = new XSSFWorkbook(exchange.getIn().getBody(String.class));
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

        for (int i = 0; i < rowCount; i++) {
            int cellCount = sheet.getRow(i).getLastCellNum();

            for (int j = 0; j < cellCount; j++) {
                System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
            }

        }



    }
}
