package io.learning.testing.outside_in;

import io.learning.testing.before_refactor.Sale;

import java.util.List;

public class SalesRepository {

    private final String fileLocation;

    public SalesRepository(String fileLocation) {

        this.fileLocation = fileLocation;
    }

    public List<Sale> loadSales(){

        return null;
    }
}
