package com.msutherland128.dogboarding.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("dir")
public class ApplicationProperties {

    private String inExcelDirectory;
    private String inCsvDirectory;
    private String outCsvDirectory;

    public String getInExcelDirectory() {
        return inExcelDirectory;
    }

    public void setInExcelDirectory(String inExcelDirectory) {
        this.inExcelDirectory = inExcelDirectory;
    }

    public String getInCsvDirectory() {
        return inCsvDirectory;
    }

    public void setInCsvDirectory(String inCsvDirectory) {
        this.inCsvDirectory = inCsvDirectory;
    }

    public String getOutCsvDirectory() {
        return outCsvDirectory;
    }

    public void setOutCsvDirectory(String outCsvDirectory) {
        this.outCsvDirectory = outCsvDirectory;
    }
}
