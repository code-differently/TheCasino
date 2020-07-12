package com.codedifferently.casino;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class GoFish extends Game {
    //track each individual card value i.e. 1, 2, 3, 4, etc. and its number of occurences in the hand
    private HashMap<Player, HashMap<Integer, ArrayList<Card>>> playerHands;
    private Deck deck;
    private boolean playerOneTurn = true;

    public static void main(String [] args) {
        new GoFish("bob", "paul").startGame();
    }

    public GoFish(String playerName, String opponentName) {
        playerHands = new HashMap<Player, HashMap<Integer, ArrayList<Card>>>();
        super.playerOne = new Player(playerName, 0.0, 0, new ArrayList<Card>());
        super.playerTwo = new Player(opponentName, 0.0, 0, new ArrayList<Card>());
        //need to put these there, otherwise it will be referencing null which isn't good
        playerHands.put(super.playerOne, new HashMap<Integer, ArrayList<Card>>());
        playerHands.put(super.playerTwo, new HashMap<Integer, ArrayList<Card>>());
        //there are 14 values a card can have, need to make sure it is not null when access it
        for(int i = 0; i < 14; i++) {
            playerHands.get(super.playerOne).put(i, new ArrayList<Card>());
            playerHands.get(super.playerTwo).put(i, new ArrayList<Card>());
        }
        deck = new Deck();
        playerOneTurn = true;
    }

    public void startGame() {
        //keeps track if its the first time entering the while loop or not
        int count = 0;
        //initializing this here to have it accessible to the rest of the method
        //used to get the integer value or quit
        String userChoice = "";
        //it's 56 because we have an enum for 1 and an enum for Ace, making it 14 * 4, not 13 * 4
        this.deck.generateNonRandomizedSpecificSizedDeck(56);

        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please enter your name: ");
//
//        //scans until the next line, trims anything before and after
//        super.playerOne.setName(scanner.nextLine().trim());

        //each player will get 7 cards
        for(int i = 0; i < 14; i++) {
            Card card = this.deck.dealRandomCard();
            int valueOfCard = card.getValue().getValue();
            //first player gets 7 cards
            if(i < 7) {
                playerHands.get(playerOne).get(valueOfCard).add(card);
            }
            //second player also gets 7 cards
            else {
                playerHands.get(playerTwo).get(valueOfCard).add(card);
            }
        }

        System.out.println("Welcome to Go Fish " + playerOne.getName() + "! Each player will get 7 cards");
        System.out.println("The game will end when the deck is out of cards (The deck at this moment has " + this.deck.getNumCards() + " cards).");
        System.out.println("A twist to this version is that you get points if you guess a card value correctly, and the other player gets a point if you guess incorectly.");
        System.out.println("If you guess correctly, then you'll get to go again, but beware " + playerTwo.getName() + " can do the same thing!");
        System.out.println("The goal is to get the most number of points by the time the deck runs out of cards. If you quit, then you are assessed based off of what score you had before ending.");
        System.out.println("And of course, you'll have to go fish if you guess incorrectly. Good luck!");

        System.out.println(printOutCardValues(playerOne));

        //go until there are no cards left!
        while(deck.getNumCards() != 0) {
            if(playerOneTurn) {
                if(count > 0) {
                    System.out.println(printOutCardValues(playerOne));
                }
                count++;
                System.out.println();
                System.out.println("Now that you know which cards you have, which card value would you like to ask for? Please enter an int between 0 and 13, inclusive");
                System.out.println("You can quit as well if you want. Just type in 'quit'");
                userChoice = scanner.next().toLowerCase().trim();
                if(userChoice.equals("quit")) {
                    checkStandings();
                    break;
                }
                int guess = Integer.parseInt(userChoice);
                if(guess < 0 || guess > 13) {
                    guess = changeInputError(guess);
                }
                //notice how I switch who is the asker and who is the answerer
                //the two values at the end are for testing purposes, giving a controlled value and indicating whether its for the test or not
                initiateTradeSequence(playerOne, playerTwo, guess, false);
            }
            else {
                initiateTradeSequence(playerTwo, playerOne,0, false);
            }
            //every deletion of 10 cards results in this print statement
            if(this.deck.getNumCards() % 10 == 0) {
                System.out.println("There are " + this.deck.getNumCards() + " cards remaining in the deck.");
            }
        }

        //only print this if user does not enter quit
        if(!userChoice.equals("quit")) {
            System.out.println();
            System.out.println("Since the deck is out of cards, it's time to see the final score...");
            System.out.println();

            checkStandings();
        }
    }

    public HashMap<Player, HashMap<Integer, ArrayList<Card>>> getPlayerHands() {
        return this.playerHands;
    }

    public Deck getDeck() {
        return this.deck;
    }

    //checks whether it is player one's turn or not
    public boolean getPlayerOneTurn() {
        return this.playerOneTurn;
    }

    //made the signature like this because I can test it now
    public void goFish(Player player, Card goFishCard) {
        int cardValue = goFishCard.getValue().getValue();
        playerHands.get(player).get(cardValue).add(goFishCard);
    }

    //will use this in the game itself, I don't think its testable, that's why I made the method above
    public void goFish(Player player) {
        Card goFishCard = this.deck.dealRandomCard();
        int cardValue = goFishCard.getValue().getValue();
        playerHands.get(player).get(cardValue).add(goFishCard);
    }

    public ArrayList<Card> getCardsForSpecificValueInHand(Player player, int value) {
        return this.playerHands.get(player).get(value);
    }

    public void resetCardsForParticularValue(Player player, int value) {
        //using.clear because it takes O(n) time instead of O(n^2)
        this.playerHands.get(player).get(value).clear();
    }

    public void setArrayListInPlayerHand(Player player, int value, ArrayList<Card> cards) {
        this.playerHands.get(player).put(value, cards);
    }

    public void setPlayerOneTurn(boolean playersTurn) {
        this.playerOneTurn = playersTurn;
    }

    public boolean doesPlayerHaveCardAtValue(Player player, int value) {
        return this.playerHands.get(player).get(value).size() > 0;
    }

    public void initiateTradeSequence(Player asker, Player answerer, int guessForTesting, boolean isThisForTesting) {
        System.out.println();
        System.out.printf("%s is guessing a card that could be in %s's hand", asker.getName(), answerer.getName());
        System.out.println();
        Random random = new Random();
        int randomGuess;
        if(isThisForTesting) {
            randomGuess = guessForTesting;
        }
        else {
            //returns 0 to 13, 14 is not included
            randomGuess = random.nextInt(14);
        }
        //player chooses random card to guess whether the other player has it
        if(doesPlayerHaveCardAtValue(answerer, randomGuess)) {
            //trade card sequence
            //gets all of the cards for the player
            ArrayList<Card> cardsToExchange = playerHands.get(answerer).get(randomGuess);
            //using add all and remove all instead of a for each loop because of concurrency issues
            //playerHands.get(asker).get(randomGuess).addAll(cardsToExchange);
            //just remove the cards, its faster in the long run
            playerHands.get(answerer).get(randomGuess).removeAll(cardsToExchange);
            asker.setScore(asker.getScore() + 1);
            System.out.println("Great job " + asker.getName() + "! Your score is now: " + asker.getScore());
        }
        else {
            answerer.setScore(answerer.getScore() + 1);
            System.out.println("Unfortunately " + asker.getName() + ", you'll have to go fish. And " + answerer.getName() + " now has " + answerer.getScore() + " point because you guessed incorrectly.");
            //the other player can go
            this.setPlayerOneTurn(!this.playerOneTurn);
            goFish(asker);
        }
    }

    public String printOutCardValues(Player player) {
        System.out.println();
        System.out.println("Here are your card values " + player.getName() + ":");
        System.out.println();

        StringBuilder str = new StringBuilder();
        //goes from 0 to 13
        for(int whichValue = 0; whichValue < 14; whichValue++) {
            //only does the this for loop if the player has cards at that value
            if(doesPlayerHaveCardAtValue(player, whichValue)) {
                //use size because it's an arrayList of cards
                str.append("You have " + this.getPlayerHands().get(player).get(whichValue).size() + " cards of value " + whichValue + "\n");
            }
        }
        return str.toString().trim();
    }

    public int changeInputError(int guess) {
        Random random = new Random();
        int newGuessValue = 0;
        //0 to 13
        newGuessValue = random.nextInt(14);
        System.out.println("Invalid Input, please enter a number between 0 and 13 next time. Setting guess to " + newGuessValue);
        return newGuessValue;
    }

    public void resetGame() {
        super.playerOne = new Player();
        super.playerTwo = new Player();
    }

    public void tieMessage() {
        System.out.println("Ya'll tied, Play again and try to win!");
    }

    public void checkStandings() {
        if(super.playerOne.getScore() > super.playerTwo.getScore())
        {
            System.out.println(super.winnerMessage(super.playerOne));
            System.out.println(super.losingMessage(super.playerTwo));
        }
        else if(super.playerTwo.getScore() > super.playerOne.getScore())
        {
            System.out.println(super.winnerMessage(super.playerTwo));
            System.out.println(super.losingMessage(super.playerOne));
        }
        else
        {
            tieMessage();
        }
        System.out.println();
    }
}
