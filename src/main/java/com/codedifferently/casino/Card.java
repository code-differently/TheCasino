package com.codedifferently.casino;

enum Suit {
    HEARTS("HEARTS"), SPADES("SPADES"), DIAMONDS("DIAMONDS"), CLUBS("CLUBS");
    public String suit;

    Suit(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return this.suit;
    }
}

enum Value {
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

public class Card {
    // enum types of suit and value
    private Suit suit;
    private Value value;

    // overloaded constructor
    public Card() {
        this.suit = null;
        this.value = null;
    }

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    // getters and setters
    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    // overridng to string
    // examples
    // "TWO of HEARTS"
    // "THREE of DIAMONDS"
    // "FOUR of SPADES"
    @Override
    public String toString() {
        return value + " of " + suit;
    }

}
