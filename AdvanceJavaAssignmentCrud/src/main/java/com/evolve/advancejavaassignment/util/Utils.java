package com.evolve.advancejavaassignment.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {
    public static Double formatDouble(double value) {
        NumberFormat formatter = new DecimalFormat("#0.00");
        return Double.parseDouble(formatter.format(value));
    }
}
