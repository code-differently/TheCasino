package com.codedifferently.casino.utilities.cardenums;

public enum Suit{

    CLUBS("Clubs"), DIAMONDS("Diamonds"), 
    HEARTS("Hearts"), SPADES("Spades");

    private final String suitString;

    private Suit(String suitString) {
        this.suitString = suitString;
    }

    public String returnSuit(){
        return suitString;
    }
}
