package com.msutherland128.dogboarding.routes;

import com.msutherland128.dogboarding.config.ApplicationProperties;
import com.msutherland128.dogboarding.processor.CsvProcessor;
import com.msutherland128.dogboarding.processor.ExcelProcessor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import static com.msutherland128.dogboarding.constant.DogBoardingConstants.*;

@Component
public class ImportRoute extends RouteBuilder {

    private final ApplicationProperties applicationProperties;
    private final ExcelProcessor excelProcessor;
    private final CsvProcessor csvProcessor;

    public ImportRoute(ApplicationProperties applicationProperties, ExcelProcessor excelProcessor, CsvProcessor csvProcessor) {
        this.applicationProperties = applicationProperties;
        this.excelProcessor = excelProcessor;
        this.csvProcessor = csvProcessor;
    }


    @Override
    public void configure() throws Exception {

        from(applicationProperties.getInExcelDirectory())
                .id(EXCEL_IMPORT_ROUTE)
                .convertBodyTo(String.class)
                .log(LoggingLevel.INFO, "Received ${headers.CamelFileName} file on excel import route")
                .process(excelProcessor)
                .end();

        from(applicationProperties.getInCsvDirectory())
                .id(CSV_IMPORT_ROUTE)
                .convertBodyTo(String.class)
                .log(LoggingLevel.INFO, "Received ${headers.CamelFileName} file on csv import route")
                .process(csvProcessor)
                .to("direct:MAIN_MENU_ROUTE")
                .convertBodyTo(String.class)
                .to(applicationProperties.getOutCsvDirectory())
                .log(LoggingLevel.INFO, "Sent file to outCsvFiles directory")
                .end();
    }
}
