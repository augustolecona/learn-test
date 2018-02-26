package io.learning.testing.outside_in;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;

public class SalesReportSystemTest {

    @Test
    public void shouldPrintStoreReportForSampleData(){

        ApplicationRunner runner = new ApplicationRunner();

        String report = runner.run("src/main/java/resources/example-sales.csv");

        Assert.assertThat(report, containsString("- London         -    235 -"));
    }
}
