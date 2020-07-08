package com.codedifferently.casino;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> deck = new ArrayList<Card>();
    private int numCards = 0;

    public void  addCard(Card x) {

        deck.add(x);
        numCards++;
    }

    public Card removeCard(){

        Random rand = new Random();
        int n = rand.nextInt(numCards);
        Card temp = deck.remove(n);
        numCards--;
        return temp;
    }

    public void shuffle(){

        Collections.shuffle(deck);

    }

    public int getNumCards(){

        return numCards;
    }

    public ArrayList getDeck(){

        return deck;
    }

}
