package com.codedifferently.casino;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class BlackJackTest {
    BlackJack bj = new BlackJack();
    Deck gameDeck = new Deck();

    @Test
    public void resetGameTest() {
        String expected = "Unknown Name";
        Game.playerOne = new Player("George", 12, 0 , new ArrayList<>());
        bj.resetGame();
        String actual = Game.playerOne.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkStandingsTest() {
        Game.playerOne = new Player("Big Drip", 200, 0 , new ArrayList<>());
        Game.playerTwo = new Player("Big Chips", 800, 0 , new ArrayList<>());

        Game.playerOne.setScore(21);
        Game.playerTwo.setScore(13);
        bj.checkStandings();
        boolean expected = true;
        boolean actual = bj.gameOver;

        Assert.assertEquals(expected, actual);
        bj.resetGame();
    }

    @Test
    public void dealCardsTest() {
        Game.playerOne = new Player("Big Drip", 200, 0 , new ArrayList<>());
        Game.playerTwo = new Player("Big Chips", 800, 0 , new ArrayList<>());

        bj.createRealDeck(gameDeck);
        bj.dealCards(gameDeck);
        int expected = 2;
        int actual1 = Game.playerOne.getCards().size();
        int actual2 = Game.playerTwo.getCards().size();


        Assert.assertEquals(expected, actual1);
        Assert.assertEquals(expected, actual2);
        bj.resetGame();
    }

    @Test
    public void drawCardTest() {
        Game.playerOne = new Player("Big Drip", 200, 0 , new ArrayList<>());

        bj.createRealDeck(gameDeck);
        bj.drawCard(gameDeck, Game.playerOne);
        int expected = 1;
        int actual = Game.playerOne.getCards().size();


        Assert.assertEquals(expected, actual);
        bj.resetGame();
    }

    @Test
    public void viewCardsTest() {
        Game.playerOne = new Player("Big Drip", 200, 0 , new ArrayList<>());
        Game.playerTwo = new Player("Big Drip", 200, 0 , new ArrayList<>());
        Card c1 = new Card(Suit.SPADES, Value.SEVEN);
        Card c2 = new Card(Suit.DIAMONDS, Value.TEN);
        Card c3 = new Card(Suit.HEARTS, Value.TWO);
        Card c4 = new Card(Suit.CLUBS, Value.FIVE);

        Game.playerOne.getCards().add(c1);
        Game.playerOne.getCards().add(c2);
        Game.playerTwo.getCards().add(c3);
        Game.playerTwo.getCards().add(c4);
        bj.viewCards();
        String expected = Game.playerOne.getCards().toString() + "\n" + Game.playerTwo.getCards().toString() + "\n";
        String actual = bj.viewCards();


        Assert.assertEquals(expected, actual);
        bj.resetGame();
    }

    @Test
    public void createRealDeckTest() {
        bj.createRealDeck(gameDeck);

        // extra copy of Aces in each suit
        int expected = 56;
        int actual = gameDeck.getDeck().size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void wageMoneyTest() {
        double moneyWaged = 50;
        Game.playerOne = new Player("Big Drip", 200, 0 , new ArrayList<>());

        // extra copy of Aces in each suit
        bj.wageMoney(Game.playerOne, moneyWaged);

        double expected = 150;
        double actual = Game.playerOne.getMoney();

        Assert.assertEquals(expected, actual, 0.00);
        bj.resetGame();
    }
}