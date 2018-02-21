package io.learning.testing;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HamcrestExampleTest {

    private Map<String, Integer> getValues()
    {
        final HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        return map;
    }

    @Test
    public void mapShouldContainValue()
    {
        Map<String, Integer> values = getValues();

        Assert.assertThat(values, Matchers.hasKey("B"));
    }

    @Test
    public void listOrderingIsIrrelevant()
    {
       List<Integer> numbers = getNumbers();

       Assert.assertThat(numbers, Matchers.hasItem(5));
    }

    private List<Integer> getNumbers()
    {
        return Arrays.asList(1,2,3,5,4);
    }



}
