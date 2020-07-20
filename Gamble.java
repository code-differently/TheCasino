package com.codedifferently.casino.intereface;

import com.codedifferently.casino.utilities.Player;

public interface Gamble {
    public void win(Player player);
    public void lose(Player player);
    public void bet(Player player,double money);
}