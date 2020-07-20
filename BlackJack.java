package com.codedifferently.casino.games;

import java.util.ArrayList;
import java.util.HashMap;

import com.codedifferently.casino.intereface.Gamble;
import com.codedifferently.casino.utilities.Card;
import com.codedifferently.casino.utilities.Dealer;
import com.codedifferently.casino.utilities.Player;
/**
 * @author Aldo Almeida
 */

public class BlackJack extends CardGame implements Gamble {
    private HashMap<Player,Double> bets;
    private ArrayList<Player> notBustedPlayers;
    private Dealer dealer;

    public BlackJack(){
        super("Black Jack", 11, 1);
        this.bets=new HashMap<Player,Double>();
        this.dealer=new Dealer();
        this.notBustedPlayers=new ArrayList<Player>();
    }

    public int getBetCount(){
        return this.bets.size();
    }
    
    public Dealer getDealer(){
        return this.dealer;
    }

    public ArrayList<Player> getNotBustedPlayers() {
        return this.notBustedPlayers;
    }

    public void bet(Player player,double money) {
        money=player.gamble(money);
        this.bets.put(player, money);
    }
    
    public String betLog(){
        String output="\\---------- BETS ----------/\n";
        for (Player player : this.bets.keySet()) {
            output+= "\t"+player.getName() +": "+bets.get(player)+"\n";
        }
        return output;
    }

    public String outcomeLog(){
        String output="\\---------- RESULTS ----------/\n";
        for (Player player : this.bets.keySet()) {
            output+= "\t"+player.getName() +": "+bets.get(player)+"\n";
        }
        return output;
    }

    public void resetGame(){
        this.bets.clear();
        this.dealer=new Dealer();
        this.notBustedPlayers.clear();
        for (Player player : getPlayerList()) {
            player.emptyHand();
        }
    }

    public void addStandingPlayer(Player player){
        this.notBustedPlayers.add(player);
    }

    public void hit(Player player){
        this.dealer.dealCard(player);
    }

    public void win(Player player) {
        double winnings=this.bets.get(player)*2;
        player.giveMoney(winnings);
        this.bets.replace(player, winnings);
    }

    public void lose(Player player) {
        double lose=this.bets.get(player);
        this.bets.replace(player, -lose);
    }

    public void doubleMove(Player player){
        this.dealer.dealCard(player);
        double moneyDoubled=this.bets.get(player);
        player.giveMoney(moneyDoubled);
        moneyDoubled=player.gamble(moneyDoubled*2);
        this.bets.replace(player, moneyDoubled);
    }

    public void insurance(Player player){

    }

    public boolean checkIfValid(Player player){
        return player.getMoney()>=2 && player.getAge()>=21;
    }
    
    
    public void setUp(){
        if(startGame()){
            shuffleDeck();
            dealCards(2);
            this.dealer.checkCards().add(pullFromDeck());
            this.dealer.checkCards().add(pullFromDeck());
        }
    }

    public boolean checkIfBusted(Player player){
        return convertToNumber(player) >= 22 || convertToNumber(player) == 0 ;
    }

    public int convertToNumber(Player player){
        int total=0;
        for (Card card : player.checkCards()) {
            total+=card.getRank().returnRank();
        }
        return total;
    }

    public ArrayList<Integer> convertWithAces(Player player){
        ArrayList<Integer> results=new ArrayList<Integer>();
        int total=0;
        int acesFound=0;

        for (Card card : player.checkCards()) {
            total+=card.getRank().returnRank();
            if(card.getRank().returnRank()==1)
                acesFound++;
        }
        results.add(total);

        if(acesFound>=1){
            if(total+10 <= 21)
                results.add(total+10);
        }
        
        return results;

    }

    public void calculateWinner(){
       for(Player player: this.notBustedPlayers){
           if(checkForAce(player)){
               int bestNum=0;
               for (int value: convertWithAces(player)){
                   if(value>bestNum)
                    bestNum=value;
               }
               if(this.dealer.compareToDealer(bestNum)){
                   win(player);
               }
               else{
                   lose(player);
               }
            }
           else{
               if(this.dealer.compareToDealer(convertToNumber(player))){
                   win(player);
               }
               else{
                   lose(player);
               }
           }
       }
    }

    public boolean checkForAce(Player player){
        for (Card card : player.checkCards()) {
            if(card.getRank().returnRank()==1)
                return true;
        }
        return false;
    }

    public String showFirstDealerCard(){
        Card card=this.dealer.checkCards().get(0);
        String output="---------- DEALER'S HAND ----------\n";
        String output1=String.format("%s %s %s\n",card.getColor(),card.getRank(),card.getSuit());
        String output2=String.format("Current total: %d\n", card.getRank().returnRank());
        return output+output1+output2;
    }

    public String showDealersCards(){
        String output="------ DEALER'S Hand -----\n";
        for (Card card : this.dealer.checkCards()) {
            output+=String.format("%s %s %s\n",card.getColor(),card.getRank(),card.getSuit());
        }
        if(this.dealer.checkForAce()){
            int bestNum=0;
            for (int value: this.dealer.convertWithAces()){
                if(value>bestNum)
                 bestNum=value;
            }
            output+=String.format("Current total: %d\n",bestNum);
         }
        else{
            output+=String.format("Current total: %d\n",this.dealer.convertToNumber());
        }
        return output;

    }

    public String showPlayersCards(Player player){
        String output=String.format("------ %s's Hand -----\n", player.getName());
        for (Card card : player.checkCards()) {
            output+=String.format("%s %s %s\n",card.getColor(),card.getRank(),card.getSuit());
        }
        output+=String.format("Current total: %s\n", convertToNumber(player));
        return output;
    }



    
}

