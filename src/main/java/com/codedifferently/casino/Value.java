package com.codedifferently.casino;

public enum Value {
    ACEVALUEOF1(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8
    ), NINE(9), TEN(10),ACEVALUEOF11(11);


    private int cardNum;



    Value(int value) {
        this.cardNum = value;
    }

    public int getValue(){
        return this.cardNum;
    }




}
