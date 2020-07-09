package com.codedifferently.casino;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> deck;

    public Deck(){
        deck = new ArrayList<Card>();
    }

    public void addCard(Card x) {
        deck.add(x);
    }

    public void removeCard() {
        Random rand = new Random();
        int n = rand.nextInt(deck.size());
        //doesn't need to be set to a variable
        deck.remove(n);
    }

    public Card removeCard(Card card) {
        //gets the index of the card and returns it
        return deck.remove(deck.indexOf(card));
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public int getNumCards(){
        return deck.size();
    }

    public ArrayList<Card> getDeck(){
        return deck;
    }

}
