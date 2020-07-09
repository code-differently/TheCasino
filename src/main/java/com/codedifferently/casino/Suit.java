package com.codedifferently.casino;

public enum Suit {

    HEARTS("HEARTS"), SPADES("SPADES"), DIAMONDS("DIAMONDS"), CLUBS("CLUBS");

    public String suit;

    Suit(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return this.suit;
    }

}
