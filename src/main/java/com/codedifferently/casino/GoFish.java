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

    public GoFish() {
        playerHands = new HashMap<Player, HashMap<Integer, ArrayList<Card>>>();
        super.playerOne = new Player("Timon", 0.0, 0, new ArrayList<Card>());
        super.playerTwo = new Player("Pumba", 0.0, 0, new ArrayList<Card>());
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

    public static void main(String [] args) {
        new GoFish().startGame();
    }

    public void startGame() {
        //it's 56 because we have an enum for 1 and an enum for Ace, making it 14 * 4, not 13 * 4
        this.deck.generateNonRandomizedSpecificSizedDeck(56);

        System.out.println("Welcome to Go Fish! Each player will get 7 cards");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name: ");

        //scans until the next line, trims anything before and after
        super.playerOne.setName(scanner.nextLine().trim());

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

        System.out.println("The game will end when the deck is out of cards.");
        System.out.println("Let's start playing!");

        //go until there are no cards left!
        while(deck.getNumCards() != 0) {
            //notice how I switch who is the asker and who is the answerer
            //the two values at the end are for testing purposes, giving a controlled value and indicating whether its for the test or not
            if(playerOneTurn) {
                initiateTradeSequence(playerOne, playerTwo, 0, false);
            }
            else {
                initiateTradeSequence(playerTwo, playerOne,0, false);
            }
            //every deletion of 10 cards results in this print statement
            if(this.deck.getNumCards() % 10 == 0) {
                System.out.println("There are " + this.deck.getNumCards() + " cards remaining in the deck.");
            }
        }

        System.out.println();
        System.out.println("Since the deck is out of cards, it's time to see the final score...");
        System.out.println();

        checkStandings();
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
            playerHands.get(asker).get(randomGuess).addAll(cardsToExchange);
            playerHands.get(answerer).get(randomGuess).removeAll(cardsToExchange);
            asker.setScore(asker.getScore() + 1);
            System.out.println("Great job " + asker.getName() + "! Your score is now: " + asker.getScore());
        }
        else {
            System.out.println("Unfortunately " + asker.getName() + ", you'll have to go fish.");
            //the other player can go
            this.setPlayerOneTurn(!this.playerOneTurn);
            goFish(asker);
        }
    }

//    public String printOutCards(Player player) {
//        //goes from 0 to 13
//        for(int whichValue = 1; whichValue < 14; whichValue++) {
//            for(Card card: this.getPlayerHands().get(player).get(whichValue)) {
//
//            }
//        }
//
//    }

    public void resetGame() {
        super.playerOne = new Player();
        super.playerTwo = new Player();
    }

    public void tieMessage() {
        System.out.println("ya'll tied, Try again later");
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
