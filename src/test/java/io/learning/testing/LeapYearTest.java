package io.learning.testing;

import org.junit.Assert;
import org.junit.Test;

public class LeapYearTest {

    //A leap year is one which is divisible by both 4 and 400 but isn't divisible by 100

    @Test
    public void leapYearIsBeDivisibleByFour()
    {
        Assert.assertTrue(LeapYear.isLeapYear(2016));
    }

    @Test
    public void normalYearIsNotDivisibleByFour()
    {
        Assert.assertFalse(LeapYear.isLeapYear(2017));
    }

    @Test
    public void leapYearIsNotDivisibleByOneHundred()
    {
        Assert.assertFalse(LeapYear.isLeapYear(1900));
    }

    @Test
    public void leapYearIsDivisibleByFourHundred()
    {
        Assert.assertTrue(LeapYear.isLeapYear(2000));
    }

}
