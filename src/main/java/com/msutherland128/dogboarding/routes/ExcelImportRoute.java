package com.msutherland128.dogboarding.routes;

import com.msutherland128.dogboarding.config.ApplicationProperties;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ExcelImportRoute extends RouteBuilder {

    private final ApplicationProperties applicationProperties;

    public ExcelImportRoute(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }


    @Override
    public void configure() throws Exception {

        from(applicationProperties.getInExcelDirectory())
                .id("ExcelImportRoute")
                .convertBodyTo(String.class)
                .log(LoggingLevel.INFO, "Received ${headers.CamelFileName} file on excel import route")
                .end();
    }
}
