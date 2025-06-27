package com.msutherland128.dogboarding.utils;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DataProcessorOperationsTest {

    private final DataProcessorOperations dataProcessorOperations = new DataProcessorOperations();

    @Test
    void removeDuplicates() {
        ArrayList<String> expected = new ArrayList<>();
        ArrayList<String> actual = new ArrayList<>();

        expected.add("Ernie");
        expected.add("Milo");

        assertEquals(expected, dataProcessorOperations.removeDuplicates(createArrayList(actual)));
    }

    @Test
    void bigDecimalConversion() {
        double doubleValue = 125.9999;

        assertEquals(BigDecimal.valueOf(126).setScale(2, RoundingMode.HALF_EVEN), dataProcessorOperations.bigDecimalConversion(doubleValue));
    }


    private ArrayList<String> createArrayList(ArrayList<String> arrayList) {

        while (arrayList.size() < 10) {
            arrayList.add("Ernie");
            arrayList.add("Milo");
            }

        return arrayList;
    }
}