package com.codedifferently.casino;

import org.junit.Assert;
import org.junit.Test;

public class CrapsTest {

    @Test
    public void setMinBet(){
        Craps craps= new Craps();
        //Given

        //Then
        craps.setMinBet(5);

        //When
        Assert.assertEquals(5, craps.getMinBet());
    }
  
    @Test
    public void getMinBet(){
        //Given
        Craps craps= new Craps();

        //Then
        craps.setMinBet(5);

        //When
        Assert.assertEquals(craps.getMinBet(),5);
    }

    @Test
    public void setMaxBet(){
        Craps craps= new Craps();
        //Given

        //Then
        craps.setMaxBet(5000);

        //When
        Assert.assertEquals(5000, craps.getMaxBet());
    }
  
    @Test
    public void getMaxBet(){
        //Given
        Craps craps= new Craps();

        //Then
        craps.setMaxBet(5000);

        //When
        Assert.assertEquals(craps.getMaxBet(),5000);

    }
    @Test
    public void rollMultipleDiceTest() {
        //Given
        Craps craps = new Craps();

        //when
        int value = craps.rollMultipleDice();

        //then
        Assert.assertTrue("testing if roll dice returns a valid number", value >= 1 && value <= 12);
    }
}
