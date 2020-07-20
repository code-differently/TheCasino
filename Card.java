package com.codedifferently.casino.utilities;

import com.codedifferently.casino.utilities.cardenums.Suit;
import com.codedifferently.casino.utilities.cardenums.Rank;
import com.codedifferently.casino.utilities.cardenums.Color;

/**
 * @author Keseana Howard
 */

public class Card {    

    private Suit suit;
    private Rank rank;
    private Color color;

    public Card(Suit suit, Color color, Rank rank){
        this.suit = suit;
        this.color = color;
        this.rank = rank;
    }

    public Suit getSuit(){
        return suit;
    }

    public Rank getRank(){
        return rank;
    }

    public Color getColor(){
        return color;
    }

}

