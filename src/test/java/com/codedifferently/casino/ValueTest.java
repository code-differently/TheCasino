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
        String actualValue = String.format("%s%s", aceValue.getValue(), twoValue.getValue(),threeValue.getValue(),);


        //When
        Assert.assertEquals("Testing constructor",expectedValue, actualValue);

    }
}
