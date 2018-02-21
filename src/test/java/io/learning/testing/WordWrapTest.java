package io.learning.testing;

import org.junit.Assert;
import org.junit.Test;

public class WordWrapTest {

    public static final int LINE_LENGTH = 5;

    // a method which breaks words on specified space with new line like a word processor would

    @Test
    public void lineShouldWrapIfOverLineLength()
    {
        String result = WordWrap.wrap("The Sleepy", LINE_LENGTH);
        Assert.assertEquals("The S\nleepy", result);
    }

    @Test
    public void shortLinesShouldNotWrap()
    {
        String result = WordWrap.wrap("The", LINE_LENGTH);
        Assert.assertEquals("The", result);
    }

    @Test
    public void longerLineShouldWrapTwice()
    {
        String result = WordWrap.wrap("The Sleepy Brow", LINE_LENGTH);
        Assert.assertEquals("The S\nleepy\n Brow", result);
    }

    @Test
    public void evenLongerLinesShouldWrapThrice()
    {
        String result = WordWrap.wrap("The Sleepy Brown Fox", LINE_LENGTH);
        Assert.assertEquals("The S\nleepy\n Brow\nn Fox", result);
    }

    @Test
    public void longLinesDoNotHaveToBeMultiplesOfLineLength()
    {
        String result = WordWrap.wrap("The Sleepy Brown Fox.!", LINE_LENGTH);
        Assert.assertEquals("The S\nleepy\n Brow\nn Fox\n.!", result);
    }
}
