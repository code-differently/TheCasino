package com.codedifferently.casino;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WarGame extends Game
{
    private Deck deck;

    public WarGame(String yourName, String opponentsName) {
        deck = new Deck();
        super.playerOne = new Player();
        super.playerTwo = new Player();
        super.playerOne.setName(yourName);
        super.playerTwo.setName(opponentsName);
        deck.generateSpecificSizedDeck(56);
        super.playerOne.setCards(deck.dealMultipleCards(5));
        super.playerTwo.setCards(deck.dealMultipleCards(5));
    }

    public static void main(String[] args) {
        new WarGame("Pie", "Cookie").startGame();
    }

    public void startGame()
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the Card Game War!");

        int score1 = 0;
        int score2 = 0;

        //playing 5 times
        for(int i = 0; i < super.playerOne.getCards().size(); i++)
        {
            System.out.println(super.playerOne.getName() + " your card is a " + super.playerOne.getCards().get(i));
            System.out.println(super.playerTwo.getName() + " your card is a " +super.playerTwo.getCards().get(i));

            //first getValue gets the enums value, second getValue gets the int value of the enum
            int playerOneCardValue = super.playerOne.getCards().get(i).getValue().getValue();
            int playerTwoCardValue = super.playerTwo.getCards().get(i).getValue().getValue();

            score1 = super.playerOne.getScore();
            score2 = super.playerTwo.getScore();

            checkScore(playerOneCardValue, playerTwoCardValue, score1, score2);

            System.out.println();
        }

        checkStandings();
    }

    public void checkScore(int playerOneCardValue, int playerTwoCardValue, int score1, int score2)
    {
        if(playerOneCardValue > playerTwoCardValue)
        {
            System.out.println("Nice! " + super.playerOne.getName() + " you won this round.");
            //increment score first, then add it
            super.playerOne.setScore(++score1);
        }
        if(playerOneCardValue < playerTwoCardValue)
        {
            System.out.println("Nice! " + super.playerTwo.getName() + " you won this round.");
            //increment score first, then add it
            super.playerTwo.setScore(++score2);
        }
        if(playerOneCardValue == playerTwoCardValue)
        {
            System.out.println("issa tie");
        }
    }

    @Override
    public void resetGame()
    {
        super.playerOne = new Player();
        super.playerTwo = new Player();
    }

    @Override
    public void tieMessage()
    {
        System.out.println("Looks like there is a tie, we have chosen your tie breaking cards");
        if(deck.getNumCards() == 0) {
            deck.generateSpecificSizedDeck(25);
        }
        playerOne.setOneCard(deck.dealRandomCard());
        System.out.println(super.playerOne.getName() + " your card's value is " + playerOne.getCards().get(0).getValue() + " better hope "
                + super.playerTwo.getName() + " doesn't have a higher card");

        super.playerOne.setScore(playerOne.getCards().get(0).getValue().getValue());
        System.out.println(super.playerTwo.getName() + " we have selected your card, to keep it suspenseful, we wont tell you your card...");
        playerTwo.setOneCard(deck.dealRandomCard());
        super.playerTwo.setScore(playerTwo.getCards().get(0).getValue().getValue());
        System.out.println();
        checkStandings();
    }


    public void checkStandings()
    {
        if(super.playerOne.getScore() > super.playerTwo.getScore())
        {
            System.out.println(super.winnerMessage(super.playerOne));
            System.out.println(super.losingMessage(super.playerTwo));
            System.out.println();
        }
        else if(super.playerTwo.getScore() > super.playerOne.getScore())
        {
            System.out.println(super.winnerMessage(super.playerTwo));
            System.out.println(super.losingMessage(super.playerOne));
            System.out.println();
        }
        else
        {
            tieMessage();
        }
    }
}