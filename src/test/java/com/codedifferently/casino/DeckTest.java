package com.codedifferently.casino;

import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;


public class DeckTest {

    @Test
    public void  addCardTest() {

        // Given
        Deck testDeck = new Deck();
        Card testCard = new Card();
        int expected = 1;

        // When
        testDeck.addCard(testCard);
        int actual = testDeck.getNumCards();

        // Then
        Assert.assertEquals("This is addCardTest", expected, actual);

    }

    @Test
    public void removeCardTest(){

        // Given
        Deck testDeck = new Deck();
        Card testCard1 = new Card();
        Card testCard2 = new Card();
        Card testCard3 = new Card();
        testDeck.addCard(testCard1);
        testDeck.addCard(testCard2);
        testDeck.addCard(testCard3);
        int expected = 2;

        // When
        testDeck.removeCard();
        int actual = testDeck.getNumCards();

        // Then
        Assert.assertEquals("This is addCardTest", expected, actual);

    }

    @Test
    public void suffleTest(){

        // Given
        Deck testDeck = new Deck();
        Card testCard1 = new Card();
        Card testCard2 = new Card();
        Card testCard3 = new Card();
        testDeck.addCard(testCard1);
        testDeck.addCard(testCard2);
        testDeck.addCard(testCard3);
        ArrayList<Card> Temp = new ArrayList<Card>(testDeck.getDeck());

        // When
        testDeck.shuffle();

        // Then

        Assert.assertNotEquals(Temp, testDeck.getDeck());
    }

}
