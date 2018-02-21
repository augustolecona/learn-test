package io.learning.testing;

import org.hamcrest.Matchers;
import org.junit.*;

public class CafeTest {

    public static final int ESPRESSO_BEANS = CoffeeType.Espresso.getRequiredBeans();
    public static final int NO_MILK = 0;
    public static final int NO_BEANS = 0;

    private Cafe cafe;

    @BeforeClass
    public static void beforeClass()
    {
        System.out.println("Before Class");
    }

    @AfterClass
    public static void afterClass()
    {
        System.out.println("After Class");
    }

    @Before
    public void before()
    {
        cafe = new Cafe();
    }

    @After
    public void after()
    {
        System.out.println("After");
    }

    @Test
    public void canBrewEspresso()
    {
        // Given
        withBeans();

        // When
        final Coffee coffee = cafe.brew(CoffeeType.Espresso);

        // Then
        // Ensure that it's an espresso, it has no milk and it has enough coffee
        Assert.assertThat(coffee, Matchers.hasProperty("beans", Matchers.equalTo(ESPRESSO_BEANS)));
        Assert.assertThat(coffee, Matchers.hasProperty("type", Matchers.equalTo(CoffeeType.Espresso)));
        Assert.assertThat(coffee, Matchers.hasProperty("milk", Matchers.equalTo(NO_MILK)));
    }

    @Test
    public void brewingEspressoConsumesBeans()
    {
        // Given
        withBeans();

        // When
        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        // Then
        Assert.assertThat(cafe.getBeansInStock(), Matchers.equalTo(NO_BEANS));
    }

    @Test(expected = IllegalStateException.class)
    public void lattesRequiresMilk()
    {
        // Given
        withBeans();

        // When
        cafe.brew(CoffeeType.Latte);

        // Then
    }

    @Test
    public void canBrewLatte()
    {
        // Given
        withBeans();
        cafe.restockMilk(CoffeeType.Latte.getRequiredMilk());

        // When
        Coffee coffee = cafe.brew(CoffeeType.Latte);

        // Then
        Assert.assertEquals("Wrong Coffee Type", coffee.getType(), CoffeeType.Latte);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mustRestockBeans()
    {
        Cafe cafe = new Cafe();

        cafe.restockMilk(NO_BEANS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mustRestockMilk()
    {
        Cafe cafe = new Cafe();

        cafe.restockMilk(NO_MILK);
    }

    public void withBeans()
    {
        cafe.restockBeans(ESPRESSO_BEANS);
    }
}
