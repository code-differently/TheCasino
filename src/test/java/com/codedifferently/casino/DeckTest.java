package com.codedifferently.casino;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;


public class DeckTest {
    Deck testDeck;
    Card testCard;

    @Before
    public void initialize() {
        testDeck = new Deck();
        testCard = new Card();
    }

    @Test
    public void constructorTest() {
        int expectedNumCards = 0;

        int actualNumCards = testDeck.getNumCards();

        Assert.assertEquals(expectedNumCards, actualNumCards);
    }

    @Test
    public void addCardTest() {

        // Given
        int expected = 1;

        // When
        testDeck.addCard(testCard);
        int actual = testDeck.getNumCards();

        // Then
        Assert.assertEquals("This is addCardTest", expected, actual);

    }

    @Test
    public void removeCardRandomlyTest(){

        // Given
        testDeck.addCard(testCard);
        int expected = 0;

        // When
        testDeck.removeCard();
        int actual = testDeck.getNumCards();

        // Then
        Assert.assertEquals("This is removeCardTest", expected, actual);
    }

    @Test
    public void removeSpecificCardTest(){

        // Given
        Card expectedCard = new Card(Suit.HEARTS, Value.EIGHT);
        String expectedString = expectedCard.toString();

        // When
        testDeck.addCard(expectedCard);
        Card actualCard = testDeck.removeCard(expectedCard);
        String actualString = actualCard.toString();

        // Then
        Assert.assertEquals("This is removeCardTest", expectedString, actualString);
    }

    @Test
    public void shuffleTest(){

        // Given
        Card testCard2 = new Card();
        Card testCard3 = new Card();
        testDeck.addCard(testCard);
        testDeck.addCard(testCard2);
        testDeck.addCard(testCard3);
        ArrayList<Card> original = new ArrayList<Card>(testDeck.getDeck());

        // When
        testDeck.shuffle();

        // Then
        Assert.assertNotEquals(original, testDeck.getDeck());
    }

    @Test
    public void correctDeckGenerator()
    {
        Deck d = new Deck();
        int correctSize = 3;

        ArrayList<Card> cards = d.generateDeck(3);

        int realSize = cards.size();

        Assert.assertEquals(correctSize, realSize);
    }

}
