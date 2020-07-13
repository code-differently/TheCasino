package com.codedifferently.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class GoFishTest {
    GoFish goFish;
    //creating player here to test because I don't have access to super.player in this test class
    Player player;
    //creating playerTwoHere even though I only use it once just to do the for loop in the initializer once
    //used for the exchange function
    Player playerTwo;

    @Before
    public void initialize() {
        goFish = new GoFish("donatello", "raphael");

        player = new Player("Bowser", 0.0, 0, new ArrayList<Card>());
        playerTwo = new Player("Peach", 0.0, 0, new ArrayList<Card>());
        goFish.getPlayerHands().put(player, new HashMap<Integer, ArrayList<Card>>());
        goFish.getPlayerHands().put(playerTwo, new HashMap<Integer, ArrayList<Card>>());
        for(int i = 0; i < 14; i++) {
            goFish.getPlayerHands().get(player).put(i, new ArrayList<Card>());
            goFish.getPlayerHands().get(playerTwo).put(i, new ArrayList<Card>());
        }
    }

    @Test
    public void constructorTest() {
        //there should be four people in the hashmap based on the constructor and adding the two new players in the initializer
        Assert.assertTrue(goFish.getPlayerHands().size() == 4);
        Assert.assertTrue(goFish.getDeck().getNumCards() == 0);
        Assert.assertTrue(goFish.getPlayerOneTurn() == true);
    }

    @Test
    public void dealPlayerHandsTest() {
        goFish.getDeck().generateSpecificSizedDeck(56);

        goFish.dealPlayerHands();

        Assert.assertTrue(goFish.getDeck().getNumCards() == 42);
    }

    @Test
    public void instructionsTest() {
        String expected = "Welcome to Go Fish donatello! Each player will get 7 cards.\n" +
                           "The game will end when the deck is out of cards (The deck at this moment has 0 cards).\n" +
                           "A twist to this version is that you get points if you guess a card value correctly, and the other player gets a point if you guess incorrectly.\n" +
                           "If you guess correctly, then you'll get to go again, but beware raphael can do the same thing!\n" +
                           "The goal is to get the most number of points by the time the deck runs out of cards. If you quit, then you are assessed based off of what score you had before ending.\n" +
                           "And of course, you'll have to go fish if you guess incorrectly. Good luck!";

        String actual = goFish.instructions();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPlayerHandsTest() {
        //there should be four people in the hashmap based on the constructor and adding the two new players in the initializer
        Assert.assertTrue(goFish.getPlayerHands().size() == 4);
    }

    @Test
    public void getDeckTest() {
        Assert.assertTrue(goFish.getDeck().getNumCards() == 0);
    }

    @Test
    public void getPlayerOneTurnTest() {
        Assert.assertTrue(goFish.getPlayerOneTurn() == true);
    }

    @Test
    public void goFishTest() {
        //creating a version of passing in a deck card
        Deck deck = new Deck();
        //this will always return the same card since its generate non randomized specific sized deck of size 1
        deck.generateNonRandomizedSpecificSizedDeck(1);
        Card goFishCard = deck.dealRandomCard();
        int value = goFishCard.getValue().getValue();

        goFish.goFish(player, goFishCard);

        Assert.assertEquals(goFish.getPlayerHands().get(player).get(value).size(), 1);
    }

    @Test
    public void getCardsForSpecificValueInHandTest() {
        ArrayList<Card> card = new ArrayList<Card>();
        card.add(new Card(Suit.CLUBS, Value.FOUR));
        int expectedCardsInHand = 1;

        goFish.setArrayListInPlayerHand(player, 4, card);
        int actualCardsInHand = goFish.getCardsForSpecificValueInHand(player, 4).size();

        Assert.assertEquals(expectedCardsInHand, actualCardsInHand);
    }

    @Test
    public void resetCardsForParticularValueTest() {
        ArrayList<Card> card = new ArrayList<Card>();
        card.add(new Card(Suit.CLUBS, Value.FOUR));
        int expectedCardsInHand = 0;

        goFish.setArrayListInPlayerHand(player, 4, card);
        goFish.resetCardsForParticularValue(player, 4);

        int actualCardsInHand = goFish.getCardsForSpecificValueInHand(player, 4).size();
        Assert.assertEquals(expectedCardsInHand, actualCardsInHand);
    }

    @Test
    public void setArrayListInPlayerHandTest() {
        ArrayList<Card> cardList = new ArrayList<Card>();
        cardList.add(new Card(Suit.DIAMONDS, Value.ONE));

        goFish.setArrayListInPlayerHand(player, 1, cardList);
    }

    @Test
    public void setPlayerOneTurnTest() {
        goFish.setPlayerOneTurn(false);
        boolean actual = goFish.getPlayerOneTurn();

        Assert.assertFalse(actual);
    }

    @Test
    public void yesPlayerHasCardTest() {
        goFish.getPlayerHands().get(player).get(3).add(new Card(Suit.HEARTS, Value.JACK));
        Assert.assertTrue(goFish.doesPlayerHaveCardAtValue(player, 3));
    }

    @Test
    public void playerDoesntHaveCardTest() {
        goFish.getPlayerHands().get(player).get(2).add(new Card(Suit.HEARTS, Value.JACK));
        Assert.assertFalse(goFish.doesPlayerHaveCardAtValue(player, 3));
    }

    @Test
    public void initiateTradeSequenceSuccessTest() {
        //adding cards with the same value and different suits so that the test can pass
        Card card1 = new Card(Suit.SPADES, Value.KING);
        Card card2 = new Card(Suit.HEARTS, Value.KING);
        int valueToTest = card1.getValue().getValue();
        goFish.getPlayerHands().get(player).get(valueToTest).add(card1);
        goFish.getPlayerHands().get(playerTwo).get(valueToTest).add(card2);

        //player is the asker, playerTwo is the answerer, at the end player should have one cards and playerTwo should only have zero cards
        goFish.initiateTradeSequence(player, playerTwo, valueToTest, true);

        Assert.assertTrue("checking to see whether the player gets two cards", goFish.getPlayerHands().get(player).get(valueToTest).size() == 1);
        Assert.assertTrue("checking to see whether playerTwo has zero cards",goFish.getPlayerHands().get(playerTwo).get(valueToTest).size() == 0);
        Assert.assertTrue("checking to see whether player's score increases by one",player.getScore() == 1);
    }

    @Test
    public void initiateTradeSequenceFailGoFishTest() {
        //adding cards with the different value and different suits so that the players do not exchange cards
        Card card1 = new Card(Suit.SPADES, Value.ACE);
        Card card2 = new Card(Suit.HEARTS, Value.KING);
        int value1 = card1.getValue().getValue();
        int value2 = card2.getValue().getValue();

        goFish.getPlayerHands().get(player).get(value1).add(card1);
        goFish.getPlayerHands().get(playerTwo).get(value2).add(card2);
        goFish.getDeck().generateNonRandomizedSpecificSizedDeck(3);

        //player is the asker, playerTwo is the answerer, at the player1 will have two cards and player2 will only have one card since player2 does not have the specified card value
        goFish.initiateTradeSequence(player, playerTwo, value1, true);

        //player1 should have one more card then player2 (because player1 has to go fish), and the score for player 2 should be 1
        boolean hasMoreThanOneCard = false;
        for(int i = 0; i < 14; i++) {
            if(i != value1 || (i == value1 && goFish.getPlayerHands().get(player).get(i).size() > 1)) {
                hasMoreThanOneCard = true;
            }
        }
        Assert.assertTrue("checking to see whether the player has more than one card", hasMoreThanOneCard);
        Assert.assertTrue("checking to see whether the first player's score stays the same",player.getScore() == 0);
        Assert.assertTrue("checking to see whether the second player's goes up",playerTwo.getScore() == 1);
        Assert.assertTrue("check to see that the deck is set to a size of 2, initially had it at 3",goFish.getDeck().getNumCards() == 2);
    }

    @Test
    public void printOutCardsTest() {
        String expected = "You have 1 cards of value 1";
        Card card = new Card(Suit.SPADES, Value.ONE);
        int value = card.getValue().getValue();
        goFish.getPlayerHands().get(player).get(value).add(card);

        String actual = goFish.printOutCardValues(player);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void changeInputBecauseOfErrorTest() {
        int returnedGuess = goFish.changeInputBecauseOfError(45);
        Assert.assertTrue(returnedGuess >= 0 && returnedGuess < 14);
    }
}
