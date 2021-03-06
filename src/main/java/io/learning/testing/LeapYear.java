package io.learning.testing;

public class LeapYear {

    public static boolean isLeapYear(final int year)
    {
        return isDivisible(year, 4) && (!isDivisible(year, 100) || isDivisible(year, 400) );
    }

    public static boolean isDivisible(final int year, final int denominator)
    {
        return year % denominator == 0;
    }
}
