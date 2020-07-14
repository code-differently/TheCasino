package com.codedifferently.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CrapsTest {
    Craps craps;
    @Before
    public void initialize() {
        craps = new Craps("Angelina");
    }

    @Test
    public void setMinBet(){
        //Then
        craps.setMinBet(5);

        //When
        Assert.assertEquals(5, craps.getMinBet());
    }
  
    @Test
    public void getMinBet(){
        //Then
        craps.setMinBet(5);

        //When
        Assert.assertEquals(craps.getMinBet(),5);
    }

    @Test
    public void setMaxBet(){
        //Then
        craps.setMaxBet(5000);

        //When
        Assert.assertEquals(5000, craps.getMaxBet());
    }
  
    @Test
    public void getMaxBet(){
        //Then
        craps.setMaxBet(5000);

        //When
        Assert.assertEquals(craps.getMaxBet(),5000);

    }
    @Test
    public void rollMultipleDiceTest() {
        //when
        int value = craps.rollMultipleDice();

        //then
        Assert.assertTrue("testing if roll dice returns a valid number", value >= 1 && value <= 12);
    }
}
