package io.learning.testing.outside_in;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.core.AllOf.allOf;

public class SalesRepositoryTest {

    @Test
    public void shouldLoadSampleData(){

        SalesRepository repository = new SalesRepository("src/main/resources/example-sales.csv");

        final List<Sale> sales = repository.loadSales();

        // London, 2, 30
        Assert.assertThat(sales, hasItem(allOf(
                hasProperty("store", equalTo("London")),
                hasProperty("number", equalTo(2)),
                hasProperty("pricePerItem", equalTo(30))
        )));
    }
}
