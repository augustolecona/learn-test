package io.learning.testing;

import org.junit.Assert;

public class LeapYearTest {

    //A leap year is one which is divisible by both 4 and 400 but isn't divisible by 100

    public void leapYearsShouldBeDivisibleByFour()
    {
        Assert.assertTrue(LeapYear.isLeap(2016));
    }

}
