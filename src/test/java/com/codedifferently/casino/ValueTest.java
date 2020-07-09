package com.codedifferently.casino;

import org.junit.Assert;
import org.junit.Test;

import java.util.EnumSet;

public class ValueTest {
    @Test
    public void ValueConstructorTest(){
        // Given
        String expectedValue = "1234567891011111213";
        StringBuilder actualValue = new StringBuilder();

        // Then
        EnumSet.allOf(Value.class).forEach(value -> actualValue.append(value.getValue()));

        // When
        Assert.assertEquals("Testing constructor", expectedValue, actualValue.toString());

    }
    @Test
    public void getOneValue(){
        //Given
        int expectedOneValue = 1;

        //Then
        int oneValue = Value.ONE.getValue();

        //When
        Assert.assertEquals("Testing constructor",expectedOneValue, oneValue);

    }
    @Test
    public void getTwoValue(){
        //Given
        int expectedTwoValue = 2;

        //Then
        int twoValue = Value.TWO.getValue();

        //When
        Assert.assertEquals("Testing constructor",expectedTwoValue, twoValue);

    }
    @Test
    public void getThreeValue(){
        //Given
        int expectedThreeValue = 3;

        //Then
        int threeValue = Value.THREE.getValue();

        //When
        Assert.assertEquals("Testing constructor",expectedThreeValue, threeValue);

    }
    @Test
    public void getFourValue(){
        //Given
        int expectedFourValue = 4;

        //Then
        int fourValue = Value.FOUR.getValue();

        //When
        Assert.assertEquals("Testing constructor",expectedFourValue, fourValue);

    }
    @Test
    public void getFiveValue(){
        //Given
        int expectedFiveValue = 5;

        //Then
        int fiveValue = Value.FIVE.getValue();

        //When
        Assert.assertEquals("Testing constructor",expectedFiveValue, fiveValue);

    }
    @Test
    public void getSixValue(){
        //Given
        int expectedSixValue = 6;

        //Then
        int sixValue = Value.SIX.getValue();

        //When
        Assert.assertEquals("Testing constructor",expectedSixValue, sixValue);

    }
    @Test
    public void getSevenValue(){
        //Given
        int expectedSevenValue = 7;

        //Then
        int sevenValue = Value.SEVEN.getValue();

        //When
        Assert.assertEquals("Testing constructor",expectedSevenValue, sevenValue);

    }
    @Test
    public void getEightValue(){
        //Given
        int expectedEightValue = 8;

        //Then
        int eightValue = Value.EIGHT.getValue();

        //When
        Assert.assertEquals("Testing constructor",expectedEightValue, eightValue);

    }
    @Test
    public void getNineValue(){
        //Given
        int expectedNineValue = 9;

        //Then
        int nineValue = Value.NINE.getValue();

        //When
        Assert.assertEquals("Testing constructor",expectedNineValue, nineValue);

    }
    @Test
    public void getTenValue(){
        //Given
        int expectedTenValue = 10;

        //Then
        int tenValue = Value.TEN.getValue();

        //When
        Assert.assertEquals("Testing constructor",expectedTenValue, tenValue);

    }
    @Test
    public void getAceValue(){
        //Given
        int expectedAceValue = 11;

        //Then
        int aceValue1 = Value.ACE.getValue();

        //When
        Assert.assertEquals("Testing constructor",expectedAceValue, aceValue1);

    }

    @Test
    public void getJackValue(){
        //Given
        int expectedJackValue = 11;

        //Then
        int jackValue = Value.JACK.getValue();

        //When
        Assert.assertEquals("Testing constructor",expectedJackValue, jackValue);

    }

    @Test
    public void getQueenValue(){
        //Given
        int expectedQueenValue = 12;

        //Then
        int queenValue = Value.QUEEN.getValue();

        //When
        Assert.assertEquals("Testing constructor",expectedQueenValue, queenValue);

    }

    @Test
    public void getKingValue(){
        //Given
        int expectedKingValue = 13;

        //Then
        int kingValue = Value.KING.getValue();

        //When
        Assert.assertEquals("Testing constructor",expectedKingValue, kingValue);

    }

}