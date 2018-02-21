package io.learning.testing;

import org.junit.Assert;
import org.junit.Test;

public class CafeTest {

    @Test
    public void canBrewEspresso()
    {
        // Given
        Cafe cafe = new Cafe();
        cafe.restockBeans(8);

        // When
        final Coffee coffee = cafe.brew(CoffeeType.Espresso);

        // Then
        // Ensure that it's an espresso, it has no milk and it has enough coffee
        Assert.assertEquals("Wrong coffee type", CoffeeType.Espresso, coffee.getType());
        Assert.assertEquals("Wrong quantity of milk", 0, coffee.getMilk());
        Assert.assertEquals("Wrong quantity of beans",8, coffee.getBeans());
    }

    @Test
    public void brewingEspressoConsumesBeans()
    {
        // Given
        Cafe cafe = new Cafe();
        cafe.restockBeans(8);

        // When
        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        // Then
        Assert.assertEquals(0, cafe.getBeansInStock());
    }

    @Test(expected = IllegalStateException.class)
    public void lattesRequiresMilk()
    {
        // Given
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);

        // When
        cafe.brew(CoffeeType.Latte);

        // Then
    }

    @Test
    public void canBrewLatte()
    {
        // Given
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);
        cafe.restockMilk(227);

        // When
        Coffee coffee = cafe.brew(CoffeeType.Latte);

        // Then
        Assert.assertEquals("Wrong Coffee Type", coffee.getType(), CoffeeType.Latte);
    }
}
