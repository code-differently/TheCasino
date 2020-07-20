package com.codedifferently.casino.games;

import com.codedifferently.casino.utilities.Card;
import com.codedifferently.casino.utilities.Deck;
import com.codedifferently.casino.utilities.Player;

public class CardGame extends Games {
    protected Deck deck;

    public CardGame(String name,int max, int min){
        super(name, max, min);
        this.deck=new Deck();
    }

    public Card pullFromDeck(){
        if(this.deck.getDeckSize()!=0){
            return this.deck.pullFromDeck();
        }
        else{
            this.deck=new Deck();
            return this.deck.pullFromDeck();
        }
    }

    public void shuffleDeck(){
        this.deck.shuffle();
    }

    public void dealCards(int num){
        if(super.startGame()){
            for (Player player : super.getPlayerList()) {
                for(int i=0;i<num;i++)
                    player.giveCard(this.deck.pullFromDeck());
            }
        }
    }
}
