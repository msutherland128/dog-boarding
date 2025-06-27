package com.msutherland128.dogboarding.utils;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedHashSet;

@Component
public class DataProcessorOperations {

    public <T> ArrayList<T> removeDuplicates(ArrayList<T> arrayList) {
        LinkedHashSet<T> set = new LinkedHashSet<>();
        set.addAll(arrayList);
        arrayList.clear();
        arrayList.addAll(set);
        return arrayList;
    }

    public BigDecimal bigDecimalConversion(double doubleValue) {
        BigDecimal bigDecimal = BigDecimal.valueOf(doubleValue).setScale(2, RoundingMode.HALF_EVEN);
        return bigDecimal;
    }
}
