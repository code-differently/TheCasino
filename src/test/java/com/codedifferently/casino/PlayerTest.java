package com.codedifferently.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class PlayerTest {
    Player defaultPlayer;

    @Before
    public void initialize() {
        defaultPlayer = new Player();
    }

    @Test
    public void constructorDefaultTest() {
        String expectedString = "Players name is: Unknown Name, Players money is: 0.0, Players score is: 0, Players cards are: No cards available at this time. Add a card to show the suit and value of each individual card";

        String actualString = defaultPlayer.toString();

        Assert.assertEquals(expectedString, actualString);
    }


    @Test
    public void constructorFourArgsTest() {
        //need to have this to pass in an arrayList of cards
        String expectedValue = "Players name is: Bobby Buckets, Players money is: 502.5, Players score is: 25, Players cards are: NINE of HEARTS ";
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(Suit.HEARTS, Value.NINE));

        // will only use this once, so declared it here instead of at before
        Player p2 = new Player("Bobby Buckets", 502.5, 25, cards);
        String actualValue = p2.toString();

        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getNameTest() {
        String expectedName = "Unknown Name";

        String actualName = defaultPlayer.getName();

        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void getMoneyTest() {
        double expectedMoney = 0.0;

        double actualMoney = defaultPlayer.getMoney();

        Assert.assertEquals(expectedMoney, actualMoney, 0.0);
    }

    @Test
    public void getScoreTest() {
        int expectedScore = 0;

        int actualScore = defaultPlayer.getScore();

        Assert.assertEquals(expectedScore, actualScore, 0.0);
    }

    @Test
    public void getCardsTest() {
        int expectedSize = 0;

        int actualSize = defaultPlayer.getCards().size();

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void setNameTest() {
        String expectedName = "Curry";

        defaultPlayer.setName("Curry");
        String actualName = defaultPlayer.getName();

        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void setMoneyTest() {
        double expectedMoney = 50.25;

        defaultPlayer.setMoney(50.25);
        double actualMoney = defaultPlayer.getMoney();

        Assert.assertEquals(expectedMoney, actualMoney, 0.0);
    }

    @Test
    public void setScoreTest() {
        double expectedScore = 45;

        defaultPlayer.setScore(45);
        int actualScore = defaultPlayer.getScore();

        Assert.assertEquals(expectedScore, actualScore, 0.0);
    }

    @Test
    public void setCardsTest() {
        String expectedCardValue = "FIVE of DIAMONDS ";
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(Suit.DIAMONDS, Value.FIVE));

        defaultPlayer.setCards(cards);
        String actualCardValue = defaultPlayer.printOutCards();


        Assert.assertEquals(expectedCardValue, actualCardValue);
    }

    @Test
    public void setOneCardTest() {
        String expectedCardValue = "FIVE of DIAMONDS ";
        Card card = new Card(Suit.DIAMONDS, Value.FIVE);

        defaultPlayer.setOneCard(card);
        String actualCardValue = defaultPlayer.printOutCards();

        Assert.assertEquals(expectedCardValue, actualCardValue);
    }

    @Test
    public void toStringTest() {
        String expectedString = "Players name is: Unknown Name, Players money is: 0.0, Players score is: 0, Players cards are: No cards available at this time. Add a card to show the suit and value of each individual card";

        String actualString = defaultPlayer.toString();

        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void printOutCardsTest() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(Suit.CLUBS, Value.SEVEN));
        defaultPlayer = new Player("Bob", 12.5, 45, cards);

        String expected = "SEVEN of CLUBS ";
        String actual = defaultPlayer.printOutCards();

        Assert.assertEquals(expected, actual);
    }

}

