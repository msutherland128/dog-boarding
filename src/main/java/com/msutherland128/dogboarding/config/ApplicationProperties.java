package com.msutherland128.dogboarding.config;

import org.springframework.beans.factory.annotation.Value;

public class ApplicationProperties {

    @Value("inexceldirectory")
    private String inExcelDirectory;

    public String getInExcelDirectory() {
        return inExcelDirectory;
    }

    public void setInExcelDirectory(String inExcelDirectory) {
        this.inExcelDirectory = inExcelDirectory;
    }
}
