package io.learning.testing;

import org.junit.Assert;
import org.junit.Test;

public class CafeTest {

    @Test
    public void canBrewEspresso()
    {
        Cafe cafe = new Cafe();
        cafe.restockBeans(8);

        final Coffee coffee = cafe.brew(CoffeeType.Espresso);


        // Ensure that it's an espresso, it has no milk and it has enough coffee
        Assert.assertEquals(CoffeeType.Espresso, coffee.getType());
        Assert.assertEquals(0, coffee.getMilk());
        Assert.assertEquals(8, coffee.getBeans());
    }
}
