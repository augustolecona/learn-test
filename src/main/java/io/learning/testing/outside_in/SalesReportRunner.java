package io.learning.testing.outside_in;

import java.io.PrintStream;

public class SalesReportRunner {

    private final PrintStream out;

    public static void main(String[] args) {

        String fileLocation = args[0];
        new SalesReportRunner(System.out).run(fileLocation);
    }

    public SalesReportRunner(final PrintStream out){

        this.out = out;
    }

    public void run(String fileLocation){
        SalesRepository repository = new SalesRepository(fileLocation);
        SalesAnalyser analyser = new SalesAnalyser(repository);
        SalesReport report = new SalesReport(analyser);
        report.run();
    }
}
