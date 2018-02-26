package io.learning.testing.before_refactor;

import java.util.Map;
import java.util.function.Function;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class SalesAnalysisService {

    private final SalesRepository repository;

    public SalesAnalysisService(SalesRepository repository) {
        this.repository = repository;
    }

    public Map<String, Integer> tallyProductSales(){
        return tallySalesBy(Sale::getProduct);
    }

    public Map<String, Integer> tallyStoreSales(){
        return tallySalesBy(Sale::getStore);
    }

    private Map<String, Integer> tallySalesBy(Function<Sale, String> classifier){
        return repository.loadSales().stream().collect(groupingBy(classifier,summingInt(Sale::getValue)));
    }
}
