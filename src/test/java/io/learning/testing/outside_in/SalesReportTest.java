package io.learning.testing.outside_in;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class SalesReportTest {

    private static final int TALLY = 235;
    private static final String CITY = "LONDON";

    private PrintStream mockOut = mock(PrintStream.class);
    private SalesAnalyser mockAnalyser = mock(SalesAnalyser.class);
    private SalesReport report = new SalesReport(mockAnalyser, mockOut);
    private static final List<Sale> exampleSales = Arrays.asList(
            new Sale("Cardiff", 10, 2),
            new Sale("Cardiff", 3, 5),
            new Sale("Cardiff", 6, 20),
            new Sale("London", 5, 7)
    );

    private static final Map<String, Integer> expectedStoreSales = new HashMap<>();
    static {
        expectedStoreSales.put("Cardiff", 155);
        expectedStoreSales.put("London", 35);
    }


    @Test
    public void shouldPrintCityTallies(){

        Map<String, Integer> cityTallies = new HashMap<>();
        cityTallies.put(CITY, TALLY);
        when(mockAnalyser.tallyCitySales()).thenReturn(cityTallies);

        report.run();

        verify(mockOut).printf(anyString(), eq(CITY), eq(TALLY));
    }

    @Test
    public void shouldAggregateStoreSales(){
        // given
        SalesRepository mockRepository = mock(SalesRepository.class);
        when(mockRepository.loadSales()).thenReturn(exampleSales);

        SalesAnalyser analyser = new SalesAnalyser(mockRepository);

        // when
        Map<String, Integer> storeSales = analyser.tallyCitySales();

        // then
        Assert.assertEquals("Calculated wrong store sales", expectedStoreSales, storeSales);
        verify(mockRepository, times(1)).loadSales();


    }

}
