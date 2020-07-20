package com.codedifferently.casino.utilities;

import java.util.ArrayList;

/**
 * @author Aldo Almeida
 */

public class Player {
    private String name;
    private int age;
    private double money;
    private ArrayList<Card> hand;

    public Player(String name, int age, double money){
        this.name=name;
        this.age=age;
        this.money=money;
        this.hand= new ArrayList<Card>();
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public double getMoney(){
        return this.money;
    }

    public int getHandSize(){
        return this.hand.size();
    }

    public void giveCard(Card card){
        this.hand.add(card);
    }

    public void emptyHand(){
        this.hand.clear();
    }

    public ArrayList<Card> checkCards(){
        return this.hand;
    }

    public void giveMoney(double money){
        this.money+=money;
    }
    
    public double gamble(double bet){
        if(this.money-bet<0){
            double temp=this.money;
            this.money=0;
            return temp;
        }
        else
            this.money-=bet;
        return bet;
    }
}