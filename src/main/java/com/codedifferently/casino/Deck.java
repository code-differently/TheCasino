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

    //deals a random card
    public Card dealRandomCard() {
        Random rand = new Random();
        int n = rand.nextInt(deck.size());
        //doesn't need to be set to a variable
        return deck.remove(n);
    }

    public Card dealSpecificCard(Card card) {
        //gets the index of the card and returns it
        return deck.remove(deck.indexOf(card));
    }

    public ArrayList<Card> dealMultipleCards(int numCards) {
        ArrayList<Card> removedCards = new ArrayList<Card>();
        if(numCards > this.getDeck().size()) {

        }
        Random rand = new Random();
        for(int i = 0; i < numCards; i++) {
            int n = rand.nextInt(deck.size());
            Card cardToBeDistributed = deck.remove(n);
            removedCards.add(cardToBeDistributed);
        }
        return removedCards;
    }

    /**
     *
     * @param numberOfCardsInDeck
     * the deck is initialized to a specific number of cards
     */
    public void generateSpecificSizedDeck(int numberOfCardsInDeck)
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
    }

    /**
     *
     * @param numberOfCardsInDeck
     * the deck is initialized to a specific number of cards
     */
    public void generateNonRandomizedSpecificSizedDeck(int numberOfCardsInDeck)
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
        for(int i = 0; i < numberOfCardsInDeck; i++)
        {
            deck.add(allCards.get(i));
        }
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
