package com.codedifferently.casino;

import java.util.Scanner;

public class DiceGame extends Game
{
    public int userGuess;
    public int correctRole;
    @Override
    public void startGame() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the dice game!");
        System.out.println("Guess a number from 1 to 6, and see if you guess the correct dice roll!");
        userGuess = scan.nextInt();

        //a six sided dice
        Die d = new Die();
        correctRole = d.rollDice();

        checkStandings();
    }

    @Override
    public void resetGame() {
        startGame();
    }

    @Override
    public void tieMessage() {/*no implementation for dice game tie message */}

    @Override
    public void checkStandings() {
        if(userGuess != correctRole)
        {
            System.out.println("Awwww, sorry! Your guess was " + Math.abs(correctRole - userGuess) + " away from the correct role of " + correctRole);
        }
        else
        {
            System.out.println("Ayeee, you guessed the correct role! Good job");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new DiceGame().startGame();
    }
}
