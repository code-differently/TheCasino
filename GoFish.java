package com.codedifferently.casino.games;

import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

import com.codedifferently.casino.utilities.Card;
import com.codedifferently.casino.utilities.Player;
import com.codedifferently.casino.utilities.cardenums.Rank;

/**
 * @author Keseana Howard
 */

public class GoFish extends CardGame{
    
    private HashMap<Player, ArrayList<Card>> hmap;
    private ArrayList<Card> stockPile = new ArrayList<Card>();
    private int cardsPerPerson;
    private int totalBookCount = 0;
    private HashMap<Player, ArrayList<Rank>> bookLog = new HashMap<Player, ArrayList<Rank>>();

    public GoFish(){

        super("Go Fish", 6, 2);
        this.hmap = new HashMap<Player, ArrayList<Card>>();
        
    }

    public void setCardNumber(){
        if(hmap.size() == 2 || hmap.size() == 3)
            cardsPerPerson = 7;
        else if(hmap.size() > 3 && hmap.size() <= 6)
            cardsPerPerson = 5;
        else
            cardsPerPerson = 0;
    }

    public void addGoFishPlayer(String name, int age){
        Player player = new Player(name, age, 0);
        addPlayer(player);
    }

    public void initializePlayers(){
        for(Player player :  players){
            hmap.put(player, new ArrayList<Card>());
        }
    }

    public ArrayList<Player> getGoFishPlayersList(){
        return players;
    }

    public int getCardsPerPerson(){
        return cardsPerPerson;
    }

    public boolean checkHand(ArrayList<Card> hand, Rank rankWanted){
        
        for(Card current : hand){
            Rank rank = current.getRank();
            if(rank.equals(rankWanted))
                return true; //rank was found
        }
        return false; //rank NOT found
    }

    public boolean ask(Player playerAsked, Rank rankWanted){
        ArrayList<Card> hand = hmap.get(playerAsked);

        boolean cardFound = checkHand(hand, rankWanted);

        return cardFound;
    }

    public HashMap<Player, ArrayList<Card>> getHashMap(){
        return hmap;
    } 

    public void giveCards(Player playerAsking, Player playerAsked, Rank rankWanted){
        ArrayList<Card> removeCards = hmap.get(playerAsked);
        ArrayList<Card> addCards = hmap.get(playerAsking);
        ArrayList<Card> temp = new ArrayList<Card>();

        for(Card current : removeCards){
            if(current.getRank().equals(rankWanted)){
                temp.add(current);
            }
        }

        for(Card card : temp){
            removeCards.remove(card);
            addCards.add(card);
        }
    }

    public boolean pullFromDeck(Player player, Rank rankWanted){

        ArrayList<Card> hand = hmap.get(player);
        Card newCard = pullFromDeck();

        if(checkHand(hand, rankWanted)){
            hand.add(newCard);
            return true;
        }

        addToStockPile(newCard);
        return false;
    }

    public HashMap<Player, ArrayList<Rank>> getBookLog(){
        return bookLog;
    }

    public void addToBookLog(Player player, Rank rankWon){
        ArrayList<Rank> ranks = new ArrayList<Rank>();
        ranks.add(rankWon);

        bookLog.put(player, ranks);
    }

    public boolean checkForBooks(Player player){

        ArrayList<Card> hand = hmap.get(player);

        for(Card one : hand){
            int count = 0;
            for(Card two : hand){
                if(one.getRank().equals(two.getRank()))
                    count++;
            }

            if(count == 4){
                removeBooks(player, one, hand);
                return true;
            }
        }
        return false;
    }

    public void removeBooks(Player player, Card card2, ArrayList<Card> arrList){
            
        ArrayList<Card> temp = new ArrayList<Card>();
        
        for(Card card : arrList)
            if(card.getRank().equals(card2.getRank()))
                temp.add(card);

        for(Card card : temp)
            arrList.remove(card);
            
        totalBookCount++;
        Rank rankToAdd = card2.getRank();
        addToBookLog(player, rankToAdd);
        showBooks(player);  
    }

    public int getTotalBookCount(){
        return totalBookCount;
    }

    public int getSizeOfPlayerHand(Player player){
        return hmap.get(player).size();
    }

    public void addToStockPile(Card card){
       stockPile.add(card);
    }

    public ArrayList<Card> getStockPile(){
        return stockPile;
    }

    public void checkDeck(){
        if(getDeckSize() == 0)
            emptyStockPile();
    }

    public void emptyStockPile(){
        deck.repopulateDeck(stockPile);
        stockPile.clear();
    }

    public Rank getRankNeeded(String rank){
        if(rank.equalsIgnoreCase("ace"))
            return Rank.ACE;
        else if(rank.equalsIgnoreCase("two") || rank.equalsIgnoreCase("deuce"))
            return Rank.DEUCE;
        else if(rank.equalsIgnoreCase("three"))
            return Rank.THREE;
        else if(rank.equalsIgnoreCase("four"))
            return Rank.FOUR;
        else if(rank.equalsIgnoreCase("five"))
            return Rank.FIVE;
        else if(rank.equalsIgnoreCase("six"))
            return Rank.SIX;
        else if(rank.equalsIgnoreCase("seven"))
            return Rank.SEVEN;
        else if(rank.equalsIgnoreCase("eight"))
            return Rank.EIGHT;
        else if(rank.equalsIgnoreCase("nine"))
            return Rank.NINE;
        else if(rank.equalsIgnoreCase("ten"))
            return Rank.TEN;
        else if(rank.equalsIgnoreCase("jack"))
            return Rank.JACK;
        else if(rank.equalsIgnoreCase("queen"))
            return Rank.QUEEN;
        else if(rank.equalsIgnoreCase("king"))
            return Rank.KING;
        return null;
    }

    public Player getPlayer(String name){

        for(Player player : getGoFishPlayersList()){
            String current = player.getName();
            if(current.equalsIgnoreCase(name)){
                return player;
            }
        }

        return null;
    }

    public boolean playerTurn(Player playerAsking, Player playerAsked, Rank rankWanted){
        boolean continueTurn = false;

        if(hmap.get(playerAsking).size() == 0)
            pullFromDeck(playerAsking, rankWanted);
        
        if(hmap.get(playerAsked).size() == 0)
            return false;

        boolean gotCards = ask(playerAsked, rankWanted);

        if(gotCards){
            giveCards(playerAsking, playerAsked, rankWanted);
            continueTurn = true;
        }
        else{
            if(!(pullFromDeck(playerAsking, rankWanted)))
                continueTurn = false;
            else
                continueTurn = true;
        }

        checkForBooks(playerAsking);

        return continueTurn;
    }

    public void deal(){

        for (Player player : getGoFishPlayersList()) {
            for(int i = 0 ;i < getCardsPerPerson(); i++){
                ArrayList<Card> hand = hmap.get(player);
                hand.add(pullFromDeck());
            }
        }
    }

    public int getDeckSize(){
        return deck.getDeckSize();
    }

    public String showBooks(Player player){
        ArrayList<Rank> out = bookLog.get(player);

        String output = String.format("Player: %s  Number of Books: %d  Books: %s", player.getName(), out.size(), out.toString());

        return output;
    }

    public void printAllPlayerBooks(){

        for(Player player : getGoFishPlayersList()){
            if(getBookLog().get(player) == null)
                System.out.println("Player: " + player.getName() + " Number of Books: 0 \tBooks: ");
            else
                System.out.println(showBooks(player));
        }
    }

    public void printGoFishPlayerList(){
        ArrayList<Player> players = getGoFishPlayersList();
        int i;

        System.out.print("  ");
        for(i = 0; i < players.size() - 1; i++)
            System.out.print(players.get(i).getName() + " | ");
        
        System.out.println(players.get(i).getName());
    }

    public String showHand(Player player){
        ArrayList<Card> hand = hmap.get(player);

        String output = String.format("%s's Hand: %s", player.getName(), toString(player, hand));

        return output;
    }

    public String toString(Player player, ArrayList<Card> hand){
        String results = "";

        for(Card c : hand){
            results += c.getRank() + " ";
        }

        return results;
    }
}