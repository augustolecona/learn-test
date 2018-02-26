package io.learning.testing.outside_in;

public class SalesAnalyser {

    private final SalesRepository salesRepository;

    public SalesAnalyser(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }
}
