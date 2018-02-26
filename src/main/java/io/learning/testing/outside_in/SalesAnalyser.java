package io.learning.testing.outside_in;

import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class SalesAnalyser {

    private final SalesRepository salesRepository;

    public SalesAnalyser(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    public Map<String, Integer> tallyCitySales(){
        return salesRepository.loadSales()
                              .stream()
                              .collect(groupingBy(Sale::getStore, summingInt(Sale::getValue)));
    }
}
