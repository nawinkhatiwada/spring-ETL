package com.example.advancejavaassignmentfetchandsave.common.utils;

import java.text.DecimalFormat;

public class Utils {

    public static double formatDecimal(double price) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return Double.parseDouble(decimalFormat.format(price));
    }
}
