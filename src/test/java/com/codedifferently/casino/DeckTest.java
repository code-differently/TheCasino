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
        testCard = new Card(Suit.DIAMONDS, Value.JACK);
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
    public void dealRandomCardTest() {
        testDeck.addCard(new Card(Suit.DIAMONDS, Value.JACK));

        Card actualCard = testDeck.dealRandomCard();
        Assert.assertEquals("deal random card test", testCard.toString(), actualCard.toString());
    }

    @Test
    public void dealSpecifiedCardTest(){

        // Given
        testDeck.addCard(testCard);

        // When
        Card actualCard = testDeck.dealSpecificCard(testCard);

        // Then
        Assert.assertEquals("This is dealSpecificCardTest", testCard.toString(), actualCard.toString());
    }

    @Test
    public void dealMultipleCardTest(){

        // Given
        ArrayList<Card> cardCheck = new ArrayList<Card>();
        Card oneOfSpades = new Card(Suit.SPADES, Value.ONE);
        cardCheck.add(testCard);
        cardCheck.add(oneOfSpades);

        testDeck.addCard(testCard);
        testDeck.addCard(oneOfSpades);

        // When
<<<<<<< HEAD
        //its random so sometimes the order will not be the same
=======
        //it deals randomly so sometimes the order will not be the same
>>>>>>> f2239dee8bbbaa0890c58e5621a2cb3b88849e46
        ArrayList<Card> actualCards = testDeck.dealMultipleCards(2);

        // Then
        for(int i = 0; i < actualCards.size(); i++) {
            Assert.assertEquals(cardCheck.get(i).toString(), actualCards.get(i).toString());
        }
    }

    @Test
    public void generateSpecificSizedDeckTest() {
        int expectedSize = 3;

        testDeck.generateSpecificSizedDeck(3);
        int actualSize = testDeck.getNumCards();

        Assert.assertEquals(expectedSize, actualSize);
<<<<<<< HEAD
=======
    }

    @Test
    public void generateNonRandomizedSpecificSizedDeckTest() {
        int expectedSize = 3;

        testDeck.generateNonRandomizedSpecificSizedDeck(3);
        int actualSize = testDeck.getNumCards();

        Assert.assertEquals(expectedSize, actualSize);
>>>>>>> f2239dee8bbbaa0890c58e5621a2cb3b88849e46
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
    public void getNumCardsTest() {
        int expected = 0;

        int actual = testDeck.getNumCards();

        Assert.assertEquals(expected, actual);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> f2239dee8bbbaa0890c58e5621a2cb3b88849e46
