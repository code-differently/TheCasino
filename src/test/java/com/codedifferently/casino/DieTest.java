package com.codedifferently.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DieTest {
    Die die;

    @Before
    public void initialize() {
        die = new Die(3);
    }

    @Test
    public void testDieConstructor() {
        //given
        int expectedValue = 3;

        //when
        int actualValue = die.getValue();

        //then
        Assert.assertEquals("testing dice constructor", expectedValue, actualValue);
    }

    @Test
    public void getDieTest() {
        //given
        int expectedValue = 3;

        //when
        int actualValue = die.getValue();

        //then
        Assert.assertEquals("testing get die test", expectedValue, actualValue);
    }

    @Test
    public void setDieTest() {
        //given
        int expectedValue = 6;
        //its 6 because that's what I set the die to in the test below, and the code should return the latest value of the die
        int errorValueExpected = 6;

        //when
        die.setValue(6);

        //then
        Assert.assertEquals("testing dice constructor", expectedValue, die.getValue());

        die.setValue(-4);
        int errorValueActual = die.getValue();
        Assert.assertEquals("testing if value returned is what it was set to after the first set die.", errorValueExpected ,errorValueActual);
    }

    @Test
    public void rollDiceTest() {
        //when
        int value = die.rollDice();

        //then
        //tests to see that the value of the die is between 1 and 6
        Assert.assertTrue("testing if roll dice returns a valid number", value >= 1 && value <= 6);
    }
}
