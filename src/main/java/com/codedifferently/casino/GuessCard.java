package com.codedifferently.casino;

import java.util.*;
public class GuessCard extends Game {


    public static void main(String[] args){

        GuessCard x = new GuessCard();
        x.startGame();

    }


    Deck deck;
    private Card randomCard;
    private int count;
    private int guess;
    private boolean end;
    private String message;

    public GuessCard() {

        super.playerOne = new Player("Mom", 500.00, 0, null);
        initDeckCard();
        guess = 0;
        end = false;

    }


    public void startGame() {

        message = "This is Guess the Card! The range for Numbers is between 1 - 11 but you can enter any number.";
        System.out.println(message);
        count = 1;

        final int CHANCES = 6;

        while ((count <= CHANCES)) {

            System.out.print("What is your Guess: ");
            Scanner in = new Scanner(System.in);
            guess = in.nextInt();
            setGuess(guess);
            System.out.println(" ");

            checkStandings();

            if(end == true) {
                break;
            }
            setCount(count++);
        }

    }

    public void checkStandings() {
        //stan.nextInstruction();
        if(getGuess() < getRandCardVal() && getCount() != 5){

            message = "Your guess was too low: Guess a number higher than " + guess;
            System.out.println(message);

        } else if (getGuess() > getRandCardVal() && getCount() != 5) {
            message = "Your guess was too high: Guess a number lower than " + guess;
            System.out.println(message);
        }
        //the guess is the same as the rand card value
        else if (getGuess() == getRandCardVal()) {

            super.playerOne.setScore(super.playerOne.getScore() + 1);
            message = super.winnerMessage(super.playerOne);
            System.out.println(message);
            end = true;

        }
        //at most 5 times
        else if(count == 5){

            message = super.losingMessage(super.playerOne);
            System.out.println(message);
            end = true;

        }

    }

    private void initDeckCard() {
        deck = new Deck();
        deck.generateSpecificSizedDeck(13);
        deck.shuffle();
        randomCard = deck.dealRandomCard();
    }


    public void resetGame() {

        startGame();

    }

    public void tieMessage() {

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





