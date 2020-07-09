package com.codedifferently.casino;

import java.util.ArrayList;

public abstract class Game
{
    private int maxPlayers;
    private ArrayList<Player> players;

    public abstract void startGame();
    public abstract void resetGame();

    public abstract int getMaxPlayers();

    //define the loss message in the seperate game classes for the specific classes's list of players
    public abstract String losingMessage(ArrayList<Player> player);

    public String winnerMessage(Player p)
    {
        return "Wow! " + p.getName() + " great job, you've won the game!";
    }

    //The reason I made this method abstract is because
    //the list passed into the classes using this method will have the contents
    //the abstract class wouldn't have any way to check for players that were tied
    //so each class needs it's own implementation
    //or we can remove this if it isn't necessary
    public abstract String tieMessage(ArrayList<Player> players);

    public abstract boolean checkIfWon(Player p);
    public abstract boolean checkIfLost(Player p);

    public abstract int checkScore(ArrayList<Player> p);
}
