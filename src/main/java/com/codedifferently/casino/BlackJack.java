package com.codedifferently.casino;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack extends Gamble {
    // declared variables
    private final int MAX_SCORE;
    private Deck gameDeck;
    private Scanner objScanner;
    private int input;
    private double moneyWaged;
    private boolean gameOver;

    public BlackJack(String yourName) {
        this.MAX_SCORE = 21;
        this.gameDeck = new Deck();
        this.objScanner = new Scanner(System.in);
        this.input = 0;
        this.moneyWaged = 0.0;
        this.gameOver = false;
        // created a player and a dealer
        playerOne = new Player(yourName, 1200, 0, new ArrayList<>());
        playerTwo = new Player("Dealer", 0, 0, new ArrayList<>());
    }

    public static void main(String[] args)
    {
        new BlackJack("WWE").startGame();
    }

    // game logic
    public void startGame() {
        // generating and shuffling deck
        createRealDeck(gameDeck);
        gameDeck.shuffle();

        // welcome statements
        System.out.println("Welcome to the BlackJack table");
        System.out.println("This BlackJack game consists of 1 player and a dealer");
        System.out.println("How much chicken we talking?");
        // gets user wage amount
        moneyWaged = objScanner.nextDouble();
        // calls method to wage money from player
        wageMoney(Game.playerOne, moneyWaged);


        System.out.println("Dealer has dealt two cards to " + playerOne.getName() + " and himself \n");
        // deals cards to dealer and player 1
        dealCards(gameDeck);
        checkStandings();
        while (!gameOver) {
            // checks hands to see if anybody has won
            System.out.println(playerOne.getName() + " what you tryna do playa?");
            // lets user decide to draw or to stay
            displayOptions();

        }
        if (gameOver) {
            resetGame();
        }
    }
  
    @Override
    public void resetGame() {
        playerOne = new Player();
        playerTwo = new Player();
        gameOver = false;
    }

    @Override
    public void tieMessage() {
        playerOne.setMoney(playerOne.getMoney() + moneyWaged);
        System.out.println(playerOne.getName() + " has tied with " + playerTwo.getName());
    }

    // shows current hand value of player and dealer, and exits if game is over
    @Override
    public void checkStandings() {
        int playerOneHandValue = 0;
        int playerTwoHandValue = 0;
        for (Card card : playerOne.getCards()) {
            playerOne.setScore(playerOneHandValue += card.getValue().getValue());
        }

        for (Card card : playerTwo.getCards()) {
            playerTwo.setScore(playerTwoHandValue += card.getValue().getValue());
        }

        System.out.println(playerOne.getName() + " hand value is: " + playerOne.getScore());
        System.out.println(playerTwo.getName() + " hand value is: " + playerTwo.getScore() + "\n");

        if (playerOne.getScore() == 21) {
            System.out.println(winnerMessage(playerOne));
            gameOver = true;

        } else if (playerOne.getScore() > MAX_SCORE) {
            System.out.println(losingMessage(playerOne));
            gameOver = true;

        } else if (playerTwo.getScore() == MAX_SCORE) {
            System.out.println(losingMessage(playerOne));
            gameOver = true;

        } else if (playerTwo.getScore() > MAX_SCORE) {
            System.out.println(winnerMessage(playerOne));
            gameOver = true;

        }
    }

    // deals two cards to each player in the game
    public void dealCards(Deck deck) {
        // calls the drawCard() twice for the player and the dealer
        for (int i = 0; i < 2; i++) {
            drawCard(deck, playerOne);
            drawCard(deck, playerTwo);
        }
    }

    // method to draw a card
    public void drawCard(Deck deck, Player player) {
        // gets the first card from the deck and adds it to the player's hand
        player.getCards().add(deck.getDeck().get(0));
        // removes that card from the front of the deck
        deck.getDeck().remove(0);
    }

    public String viewCards() {
        // shows the hand of each player, mainly for debugging
        return playerOne.getCards() + "\n" + playerTwo.getCards() + "\n";
    }

    // creates real deck of 52 cards, no duplicates to be used in game
    public void createRealDeck(Deck gameDeck) {
        for (int i = 0; i < Suit.values().length; i++) {
            for (int j = 0; j < Value.values().length; j++) {
                gameDeck.addCard(new Card(Suit.values()[i], Value.values()[j]));
            }
        }
    }

    // displays options for user
    public void displayOptions() {
        System.out.println("1) Draw a card");
        System.out.println("2) Stay your hand");
        System.out.println("3) See cards of each hand");
        System.out.println("4) Exit");
        input = objScanner.nextInt();
        if (input == 1) {
            // adds the first card on top of the shuffled deck to the player's hand
            // removes that first card from the shuffled deck
            drawCard(gameDeck, playerOne);
            System.out.println(playerOne.getName() + " has drawn a "
                    + playerOne.getCards().get(playerOne.getCards().size() - 1) + "\n");
            // updates and shows scores
            // if the dealer has a score less than 17, it is mandatory they draw a card
            checkStandings();
            if (playerTwo.getScore() < 17) {
                drawCard(gameDeck, playerTwo);
                System.out.println("Dealer has drawn a "
                        + playerTwo.getCards().get(playerTwo.getCards().size() - 1) + "\n");
                checkStandings();
            }
        } else if (input == 2) {
            // player has decided to stay
            // if the dealer has a score less than 17, it is mandatory they draw a card
            if (playerTwo.getScore() < 17) {
                System.out.println("Dealer has drawn a "
                        + playerTwo.getCards().get(playerTwo.getCards().size() - 1) + "\n");
                drawCard(gameDeck, playerTwo);
            } else {
                if (playerOne.getScore() > playerTwo.getScore()) {
                    System.out.println(winnerMessage(playerOne));
                    gameOver = true;
                } else if (playerOne.getScore() == playerTwo.getScore()) {
                    tieMessage();
                    gameOver = true;
                } else {
                    System.out.println(losingMessage(playerOne));
                    gameOver = true;
                }
            }
            checkStandings();
        } else if (input == 3) {
            System.out.println(viewCards());
            displayOptions();
        } else if (input == 4) {
            System.exit(0);
        } else {
            System.out.println("You've selected a number not listed, please retry your selection");
            displayOptions();
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    @Override
    public double wageMoney(Player p, double d) {
        playerOne.setMoney(playerOne.getMoney() - d);
        while (playerOne.getMoney() < 0) {
            System.out.println("You don't have enough money to wage your suggested bet");
            System.out.println("Returning your money");
            playerOne.setMoney(playerOne.getMoney() + d);
            System.out.println("Please enter an amount of money you can actually wage");
            d = objScanner.nextDouble();
            playerOne.setMoney(playerOne.getMoney() - d);
        }
        return d;
    }

    @Override
    public String winnerMessage(Player p) {
        playerOne.setMoney(playerOne.getMoney() + moneyWaged * 2);
        return "Game Results: " + viewCards() + "Wow! " + p.getName()
                + " great job, you've won the game with a score of " + p.getScore()
                + "\nYou've also won $" + moneyWaged + "\nYour new balance is: $" + playerOne.getMoney();
    }

    @Override
    public String losingMessage(Player p) {
        return "Game Results: " + viewCards() + "\nDang, " + p.getName()
                + " you lost, with a score of " + p.getScore()
                + "\nYou lost your wager of $" + moneyWaged + "\nYour new balance is $" + playerOne.getMoney();
    }
}