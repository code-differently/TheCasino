package com.codedifferently.casino;

public class Player {
    // declaring variables
    private String name;
    private double money;
    private int score;

    // overloading constructor
    public Player() {
        name = "Unknown Name";
        money = 0.00;
        score = 0;
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

    public int getScore()
    {
        return this.score;
    }
    public void setScore(int score)
    {
        this.score = score;
    }
}
