package com.codedifferently.casino;

public class Player {
    // declaring variables
    private String name;
    private double money;
    boolean hasWon;

    // overloading constructor
    public Player() {
        name = "Unknown Name";
        money = 0.00;
        hasWon = false;
    }

    public Player(String name) {
        this();
        this.name = name;
    }

    public Player(double money) {
        this();
        this.money = money;
    }

    public Player(String name, double money) {
        this();
        this.name = name;
        this.money = money;
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

    public boolean getHasWon() {
        return hasWon;
    }

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }
}
