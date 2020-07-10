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

    public ArrayList<Card> generateDeck(int numberOfCardsInDeck)
    {
        Value[] cardNumbers =
                {
                        Value.ONE,
                        Value.TWO,
                        Value.THREE,
                        Value.FOUR,
                        Value.FIVE,
                        Value.SIX,
                        Value.SEVEN,
                        Value.EIGHT,
                        Value.NINE,
                        Value.TEN,
                        Value.JACK,
                        Value.QUEEN,
                        Value.KING,
                        Value.ACE
                };
        Suit[] cardFaces =
                {
                        Suit.SPADES,
                        Suit.HEARTS,
                        Suit.DIAMONDS,
                        Suit.CLUBS
                };
        ArrayList<Card> allCards = new ArrayList<Card>();

        for(int i = 0; i < cardNumbers.length; i++)
        {
            for(int j = 0; j < cardFaces.length; j++)
            {
                allCards.add(new Card(cardFaces[j], cardNumbers[i]));
            }
        }

        for(int i = 1; i <= numberOfCardsInDeck; i++)
        {
            int r = (int) (Math.random() * (52 - 1));
            deck.add(allCards.get(r));
        }

        return deck;
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
