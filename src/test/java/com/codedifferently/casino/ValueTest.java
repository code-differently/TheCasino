package com.codedifferently.casino;

import org.junit.Assert;
import org.junit.Test;

public class ValueTest {
    @Test
    public void ValueConstructorTest(){
        //Given
        String expectedValue = "1234567891011";

        //Then
        Value aceValue = Enum.valueOf(Value.class, "ACEVALUEOF1");
        Value twoValue = Enum.valueOf(Value.class, "TWO");
        Value threeValue = Enum.valueOf(Value.class, "THREE");
        Value fourValue = Enum.valueOf(Value.class, "FOUR");
        Value fiveValue = Enum.valueOf(Value.class, "FIVE");
        Value sixValue = Enum.valueOf(Value.class, "SIX");
        Value sevenValue = Enum.valueOf(Value.class, "SEVEN");
        Value eightValue = Enum.valueOf(Value.class, "EIGHT");
        Value nineValue = Enum.valueOf(Value.class, "NINE");
        Value tenValue = Enum.valueOf(Value.class, "TEN");
        Value aceSecondValue = Enum.valueOf(Value.class, "ACEVALUEOF11");
        String actualValue = String.valueOf(String.format("%s%s%s%s%s%s%s%s%s%s%s", aceValue.getValue(), twoValue.getValue(),threeValue.getValue(),fourValue.getValue(),fiveValue.getValue(), sixValue.getValue(), sevenValue.getValue(), eightValue.getValue(), nineValue.getValue(), tenValue.getValue(), aceSecondValue.getValue()));


        //When
        Assert.assertEquals("Testing constructor",expectedValue, actualValue);

    }
    @Test
    public void getValueTest(){
        //Given
        int expectedAceValue1 = 1;
        int expectedTwoValue = 2;
        int expectedThreeValue = 3;
        int expectedFourValue = 4;
        int expectedFiveValue = 5;
        int expectedSixValue = 6;
        int expectedSevenValue = 7;
        int expectedEightValue = 8;
        int expectedNineValue = 9;
        int expectedTenValue = 10;
        int expectedAceValue11 = 11;

        //Then
        int aceValue1 = Value.ACEVALUEOF1.getValue();
        int twoValue = Value.TWO.getValue();
        int threeValue = Value.THREE.getValue();
        int fourValue = Value.FOUR.getValue();
        int fiveValue = Value.FIVE.getValue();
        int sixValue = Value.SIX.getValue();
        int sevenValue = Value.SEVEN.getValue();
        int eightValue = Value.EIGHT.getValue();
        int nineValue = Value.NINE.getValue();
        int tenValue = Value.TEN.getValue();
        int aceValue11 = Value.ACEVALUEOF11.getValue();


        //When
        Assert.assertEquals("Testing constructor",expectedAceValue1, aceValue1);
        Assert.assertEquals("Testing constructor",expectedTwoValue, twoValue);
        Assert.assertEquals("Testing constructor",expectedThreeValue, threeValue);
        Assert.assertEquals("Testing constructor",expectedFourValue, fourValue);
        Assert.assertEquals("Testing constructor",expectedFiveValue, fiveValue);
        Assert.assertEquals("Testing constructor",expectedSixValue, sixValue);
        Assert.assertEquals("Testing constructor",expectedSevenValue, sevenValue);
        Assert.assertEquals("Testing constructor",expectedEightValue, eightValue);
        Assert.assertEquals("Testing constructor",expectedNineValue, nineValue);
        Assert.assertEquals("Testing constructor",expectedTenValue, tenValue);
        Assert.assertEquals("Testing constructor",expectedAceValue11, aceValue11);


    }

}
