package io.learning.testing.outside_in;

import java.io.PrintStream;
import java.util.Map;

public class SalesReport {

    private final SalesAnalyser salesAnalyser;
    private final PrintStream out;

    public SalesReport(SalesAnalyser salesAnalyser, PrintStream out ) {
        this.salesAnalyser = salesAnalyser;
        this.out = out;
    }

    public void run(){

        // TODO Print things out here
        final Map<String, Integer> citySales = salesAnalyser.tallyCitySales();
        citySales.forEach((city, tally) -> {
            out.printf("- %-15s - %6.6s - \n", city, tally);
        });
    }
}
