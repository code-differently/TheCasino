package com.codedifferently.casino;

import java.util.ArrayList;
import java.util.HashMap;

public class WarGame extends Game
{
    //have the players hand in a hash map
    //ex. Player 1 -> ACE of SPADES, 8 of DIAMONDS
    HashMap<Player, Deck> playersHand;

    public void startGame()
    {
        System.out.println("Welcome to the Card Game War!");
        System.out.println("There are 2 players for this game.");
        playersHand = new HashMap<Player, Deck>();
        Player p1 = new Player("Bill");
        Player p2 = new Player("Mandy");


    }

    public void resetGame() {

    }

    public int getMaxPlayers() {
        return 0;
    }

    public String losingMessage(ArrayList<Player> player) {
        return null;
    }

    public String tieMessage(ArrayList<Player> players) {
        return null;
    }

    public boolean checkIfWon(Player p) {
        return false;
    }

    public boolean checkIfLost(Player p) {
        return false;
    }

    public int checkScore(ArrayList<Player> p) {
        return 0;
    }
}
