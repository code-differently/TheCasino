package com.codedifferently.casino;

import org.junit.Assert;
import org.junit.Test;

public class CardTest {
    Card testCard = new Card(Suit.SPADES, Value.SEVEN);

    @Test
    public void constructorTest() {
        Suit expectedSuit = Suit.SPADES;
        Value expectedValue = Value.SEVEN;
        Suit actualSuit = testCard.getSuit();
        Value actualValue = testCard.getValue();

        Assert.assertEquals(expectedSuit, actualSuit);
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getSuitTest() {
        Suit expectedSuit = Suit.SPADES;
        Suit actualSuit = testCard.getSuit();

        Assert.assertEquals(expectedSuit, actualSuit);
    }

    @Test
    public void getValueTest() {
        Value expectedValue = Value.SEVEN;
        Value actualValue = testCard.getValue();

        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void setSuitTest() {
        Suit expectedSuit = Suit.DIAMONDS;
        testCard.setSuit(Suit.DIAMONDS);
        Suit actualSuit = testCard.getSuit();

        Assert.assertEquals(expectedSuit, actualSuit);
    }

    @Test
    public void setValueTest() {
        Value expectedValue = Value.ONE;
        testCard.setValue(Value.ONE);
        Value actualValue = testCard.getValue();

        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void toStringTest() {
        String expectedString = "SEVEN of SPADES";
        String actualString = testCard.toString();

        Assert.assertEquals(expectedString, actualString);
    }
}
