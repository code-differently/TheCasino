package com.codedifferently.casino.intereface;

import java.util.ArrayList;

import com.codedifferently.casino.utilities.Player;
/**
 * @author Aldo Almeida
 * 
 */

public interface Game {
    public boolean startGame();
    public void resetGame();
    public String getGameName();
    public int getMaxPlayers();
    public int getMinPlayers();
    public int getPlayerAmount();
    public boolean addPlayer(Player player);
    public ArrayList<Player> getPlayerList();
}