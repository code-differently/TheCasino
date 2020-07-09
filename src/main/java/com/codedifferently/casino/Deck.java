package com.codedifferently.casino;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> deck;
    private int numCards;

    public Deck(){
        deck = new ArrayList<Card>();
        numCards = 0;
    }

    public void addCard(Card x) {
        deck.add(x);
        numCards++;
    }

    public void removeCard() {
        Random rand = new Random();
        int n = rand.nextInt(numCards);
        //doesn't need to be set to a variable
        deck.remove(n);
        numCards--;
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public int getNumCards(){
        return numCards;
    }

    public ArrayList<Card> getDeck(){
        return deck;
    }
}
