<<<<<<< HEAD
package com.codedifferently.casino;

import java.util.ArrayList;
public class Player {
    // declaring variables
    private String name;
    private double money;
    private int score;
    private ArrayList<Card> cards;

    // overloading constructor
    public Player() {
        name = "Unknown Name";
        money = 0.0;
        score = 0;
        cards = new ArrayList<Card>();
    }

    public Player(String name, double money, int score, ArrayList<Card> cards) {
        this.name = name;
        this.money = money;
        this.score = score;
        this.cards = cards;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getScore()
    {
        return this.score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void setOneCard(Card deckCard) {this.cards.add(deckCard);}

    public String toString() {
        return "Players name is: " + this.name + ", Players money is: " + this.money + ", Players score is: " + this.getScore() + ", Players cards are: " + this.printOutCards();
    }

    public String printOutCards() {
        StringBuilder stringOfCards = new StringBuilder();
        if(this.getCards().size() > 0) {
            for (Card card: this.getCards()) {
                //System.out.println("here");
                stringOfCards.append(card.toString() + " ");
            }
        }
        //there are no cards in the arrayList
        else {
            stringOfCards.append("No cards available at this time. Add a card to show the suit and value of each individual card");
        }

        return stringOfCards.toString();
    }
}
=======
package com.codedifferently.casino;

import java.util.ArrayList;
public class Player {
    // declaring variables
    private String name;
    private double money;
    private int score;
    private ArrayList<Card> cards;

    // overloading constructor
    public Player() {
        name = "Unknown Name";
        money = 0.0;
        score = 0;
        cards = new ArrayList<Card>();
    }

    public Player(String name, double money, int score, ArrayList<Card> cards) {
        this.name = name;
        this.money = money;
        this.score = score;
        this.cards = cards;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getScore()
    {
        return this.score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void setOneCard(Card deckCard) {this.cards.add(deckCard);}

    public String toString() {
        return "Players name is: " + this.name + ", Players money is: " + this.money + ", Players score is: " + this.getScore() + ", Players cards are: " + this.printOutCards();
    }

    public String printOutCards() {
        StringBuilder stringOfCards = new StringBuilder();
        if(this.getCards().size() > 0) {
            for (Card card: this.getCards()) {
                //System.out.println("here");
                stringOfCards.append(card.toString() + " ");
            }
        }
        //there are no cards in the arrayList
        else {
            stringOfCards.append("No cards available at this time. Add a card to show the suit and value of each individual card");
        }

        return stringOfCards.toString();
    }
}
>>>>>>> f2239dee8bbbaa0890c58e5621a2cb3b88849e46
