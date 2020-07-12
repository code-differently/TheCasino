package com.codedifferently.casino;

import org.junit.Assert;
import org.junit.Test;

public class DieTest {
    @Test
    public void rollDiceTest() {
        //Given
        Die die = new Die();

        //when
        int value = die.rollDice();

        //then
        //tests to see that the value of the die is between 1 and 6
        Assert.assertTrue("testing if roll dice returns a valid number", value >= 1 && value <= 6);
    }
}