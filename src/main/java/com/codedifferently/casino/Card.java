package com.codedifferently.casino;

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
