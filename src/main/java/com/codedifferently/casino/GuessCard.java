package com.codedifferently.casino;

import java.util.*;
public class GuessCard extends Game {

    Deck deck;
    private Card randomCard;
    private int count;
    private int guess;
    private boolean end;
    private String message;
    //before was declaring it over again in the while loop, only have to do it once
    private Scanner in;

    public GuessCard(String yourName) {
        super.playerOne = new Player(yourName, 500.00, 0, null);
        initDeckCard();
        guess = 0;
        end = false;
        in = new Scanner(System.in);
    }

    public static void main(String []args) {
        new GuessCard("bow").startGame();
    }

    public void startGame() {
        count = 0;

        final int NUMTRIES = 5;
        //there are 14 values in the deck, check out the enum class Value for more info
        message = "This is Guess the Card! The range for Numbers is between 1 - 13.\nYou only have " + NUMTRIES + " tries to guess the right value. Good Luck!";
        System.out.println(message);
        System.out.println();

        //you have 6 tries
        while (count < NUMTRIES) {
            System.out.println("Number of tries left: " + (NUMTRIES - count));
            System.out.print("What is your Guess: ");
            guess = in.nextInt();
            if(guess < 1 || guess > 13) {
                System.out.println("Please enter a number between 1 and 13. Letting you try again.");
                System.out.println();
                //does not increment count, lets the user try again
                continue;
            }
            setGuess(guess);

            checkStandings();

            if(end == true) {
                break;
            }
            setCount(++count);
            System.out.println();
        }

        //the player has lost since they exceeded the number of tries alloted
        if(end == false) {
            message = super.losingMessage(super.playerOne);
            System.out.println(message);
            System.out.println("The card value that you had to guess was: " + getRandCardVal());
            System.out.println();
        }
    }

    public void checkStandings() {
        int guess = getGuess();
        //don't need to check whether you have exceeded the number of tries or not because the while loop does it for you
        //just need to check whether the guess is lower, higher, or the same as the card value
        if(getGuess() < getRandCardVal()){
            message = "Your guess was too low: Guess a number higher than " + guess;
            System.out.println(message);

        } else if (getGuess() > getRandCardVal()) {
            message = "Your guess was too high: Guess a number lower than " + guess;
            System.out.println(message);
        }
        //the guess is the same as the rand card value
        else if (getGuess() == getRandCardVal()) {
            super.playerOne.setScore(super.playerOne.getScore() + 1);
            message = super.winnerMessage(super.playerOne);
            System.out.println(message);
            System.out.println();
            end = true;
        }
    }

    private void initDeckCard() {
        deck = new Deck();
        //its 56 because that will include every card, making it truly random (and guaranteeing you can get a number between 1 and 13)
        deck.generateSpecificSizedDeck(56);
        deck.shuffle();
        randomCard = deck.dealRandomCard();
    }

    public void resetGame() {
        startGame();
    }

    public void tieMessage() {
        //only one person is playing
    }

    public int getRandCardVal() {
        return randomCard.getValue().getValue();
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int input) {
        guess = input;
    }

    public void setCount(int c)
    {
        count = c;
    }

    public int getCount()
    {
        return count;
    }


    public String getMessage() {
        return message;
    }




}





