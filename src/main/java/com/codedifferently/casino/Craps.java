package com.codedifferently.casino;

import java.util.*;

public class Craps extends Gamble{
    private int minBet;
    private int maxBet;
    private ArrayList<Die> dice;
    private int timeGamePlayed;

    public Craps(String yourName){
        dice = new ArrayList<>();
        dice.add(new Die());
        dice.add(new Die());
        this.timeGamePlayed = 5;
        this.minBet = 5;
        this.maxBet = 5000;
        super.playerOne = new Player(yourName, 500.00, 0, new ArrayList<Card>());
    }

    public static void main(String [] args){
        new Craps("Tyler").startGame();
    }

    public void setMinBet(int theMinBet){
        this.minBet = theMinBet;
    }

    public void setMaxBet(int theMaxBet){
        this.maxBet = theMaxBet;
    }

    public int getMinBet(){
        return minBet ;
    }

    public int getMaxBet(){
        return maxBet ;
    }

    public int rollMultipleDice(){
        int sum = 0;
        for(Die die: dice){
            sum += die.rollDice();
        }
        return sum;
    }

    @Override
    public void startGame() {
        System.out.println("Welcome to Craps!");

        super.setMoneyType("dollars");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your amount: ");
        int playerBet = scanner.nextInt();
        while(playerBet <= this.minBet && playerBet >= this.maxBet){
            playerBet = scanner.nextInt();
        }

        super.wageMoney(super.playerOne, playerBet);

        for(int i = 0; i < this.timeGamePlayed; i++){
            int sumOfDiceRolled = rollMultipleDice();
            System.out.println("The sum of dice rolled is: "+ sumOfDiceRolled);
            if(sumOfDiceRolled == 7 || sumOfDiceRolled == 11){
                playerOne.setScore(playerOne.getScore() + 1);
                System.out.println("You won this round!");
                System.out.println();
            }else if(sumOfDiceRolled == 2 || sumOfDiceRolled == 3 || sumOfDiceRolled == 12){
                super.losingMessage(playerOne);
                break;
            }else{
                System.out.println("Rolling again because you didn't roll a unique number!");
                System.out.println();
            }
            System.out.println("Your total number of points is: " + playerOne.getScore());
            System.out.println();
        }
        if(playerOne.getScore() == timeGamePlayed){
            super.setPrize("60");
            int moneyPrize = Integer.parseInt(super.getPrize());

            super.winnerMessage(playerOne);
            playerOne.setMoney(playerOne.getMoney()+ moneyPrize);
            System.out.println("Winnings: " + moneyPrize);
        }else{
            System.out.println("Sorry you lost because you did not win every round played!");
        }
        System.out.println();
    }

    @Override
    public void resetGame()
    {
        super.playerOne = new Player();
    }

    @Override
    public void tieMessage() {
        //Don't need this
    }

    @Override
    public void checkStandings() {
        //Don't need this
    }

}
