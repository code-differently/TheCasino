package com.codedifferently.casino.utilities;

import java.util.ArrayList;

/**
 * @author Juliana Paul
 */
public class Dealer {

    private Deck deck = new Deck();
    private ArrayList<Card> hand;

    public Dealer(){
        this.hand = new ArrayList<Card>();
    }

    public ArrayList<Card> checkCards(){
        return this.hand;
    }

    public int getHandSize(){
        return this.hand.size();
    }

    public boolean checkForAce(){
        for (Card card : checkCards()) {
            if(card.getRank().returnRank()==1)
                return true;
        }
        return false;
    }

    public void dealCard(Player player){
         Card removedCard = deck.pullFromDeck();
         player.giveCard(removedCard);
     }

     public int convertToNumber(){
        int total = 0;
        for (Card card : checkCards()) {
            total += card.getRank().returnRank();
        }
        return total;
    }

    public ArrayList<Integer> convertWithAces(){
        ArrayList<Integer> results=new ArrayList<Integer>();
        int total = 0;
        int acesFound = 0;

        for (Card card : checkCards()) {
            total += card.getRank().returnRank();
            if(card.getRank().returnRank() == 1)
                acesFound++;
        }
        results.add(total);

        if(acesFound>=1){
            if(total+10 <= 21)
                results.add(total+10);
        }
        return results;
    }

    public boolean compareToDealer(int PlayerNum){
        int dealersNum = 0;
        if(checkForAce()){
            convertWithAces();
            for (int value: convertWithAces()){
                if(value>  dealersNum) {
                    dealersNum = value;
                }
        }
    }
        else dealersNum = convertToNumber();
        
        if(PlayerNum >= dealersNum){
            return true;
        } 
        if(PlayerNum == 21){
            return true;
        } 
        else {
            return false;
        }
    }

}



