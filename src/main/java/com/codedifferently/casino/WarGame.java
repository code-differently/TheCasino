package com.codedifferently.casino;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WarGame extends Game
{
    //have the players hand in a hash map
    //ex. Player 1 -> ACE of SPADES, 8 of DIAMONDS
    //ex. Player 2 -> ...
    HashMap<Player, ArrayList<Card>> playersHand;

    public void startGame()
    {
        System.out.println("Welcome to the Card Game War!");
        System.out.println("There are 2 players for this game.");
        playersHand = new HashMap<Player, ArrayList<Card>>();
        super.playerOne = new Player("Bill");
        super.playerTwo = new Player("Mandy");



        playersHand.put(super.playerOne, new Deck().generateDeck(5));
        playersHand.put(super.playerTwo, new Deck().generateDeck(5));
        int score1 = 0;
        int score2 = 0;
        for(Map.Entry<Player, ArrayList<Card>> playerCardEntry : playersHand.entrySet())
        {
            for(Card c : playerCardEntry.getValue())
            {
                Player p = playerCardEntry.getKey();

                int playerOneValue = 0;
                int playerTwoValue = 0;
                if(p.getName().equals(super.playerOne.getName()))
                {
                    System.out.println(p.getName() + " you've layed down a " + c.toString());
                    //the first getValue calls the method from card, then it calls the one from value
                    playerOneValue = c.getValue().getValue();
                }
                if(p.getName().equals(super.playerTwo.getName()))
                {
                    System.out.println(p.getName() + " you've layed down a " + c.toString());
                    playerTwoValue = c.getValue().getValue();

                }
                if(playerOneValue > playerTwoValue)
                {
                    System.out.println("Ha! Player One has won this round of war");
                    super.playerOne.setScore(score1++);
                }
                else if(playerTwoValue > playerOneValue)
                {
                    System.out.println("Ha! Player Two has won this round of war");
                    super.playerTwo.setScore(score2++);
                }
            }
        }
        checkStandings();
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
        ArrayList<Card> playerOnesTie = new Deck().generateDeck(1);
        System.out.println(super.playerOne.getName() + " your card's value is " + playerOnesTie.get(0).getValue() + " better hope "
                + super.playerTwo.getName() + " doesn't have a higher card");

        super.playerOne.setScore(playerOnesTie.get(0).getValue().getValue());
        System.out.println(super.playerTwo.getName() + " we have selected your card, to keep it suspenseful, we wont tell you your card...");
        ArrayList<Card> playerTwoTie = new Deck().generateDeck(1);
        super.playerTwo.setScore(playerTwoTie.get(0).getValue().getValue());
        checkStandings();

    }

    @Override
    public void checkStandings()
    {
        if(super.playerOne.getScore() > super.playerTwo.getScore())
        {
            super.winnerMessage(super.playerOne);
            super.losingMessage(super.playerTwo);
        }
        else if(super.playerTwo.getScore() > super.playerOne.getScore())
        {
            super.winnerMessage(super.playerTwo);
            super.losingMessage(super.playerOne);
        }
        else
        {
            tieMessage();
        }
    }

    public static void main(String[] args)
    {
        new WarGame().startGame();
    }
}
