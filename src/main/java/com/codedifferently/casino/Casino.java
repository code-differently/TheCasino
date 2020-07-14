package com.codedifferently.casino;

import java.util.Scanner;

public class Casino{
    int input;
    Scanner objSC;
    String yourName;
    String opponentsName;

    public Casino() {
        this.input = 0;
        this.objSC = new Scanner(System.in);
        this.yourName = "";
        this.opponentsName = "";
    }

    public static void main(String[] args) {
        Casino cas = new Casino();
        cas.titleBorder();
        cas.askForNames();
        cas.mainMenu();
    }

    // border around title to make it look kinda cool
    public void titleBorder() {
        String welcomeMessage = "Welcome to the West Side Green Team Casino";
        int wmLength = welcomeMessage.length() + 1;
        String menuMessage = "You are now at the main menu";
        for (int i = 0; i < 5; i++) {
            System.out.print('*');
            for (int j = 0; j < wmLength; j++) {
                if (i == 0) {
                    System.out.print('*');
                }
                if (i > 0 && i < 4 && i !=2 && j < wmLength - 1) {
                    System.out.print(" ");
                }
                if (i == 2 && j == 2) {
                    System.out.print(welcomeMessage + "*");
                }

                if (i == 4) {
                    System.out.print('*');
                }
            }
            if (i > 0 && i < 4 && i !=2) {
                System.out.print('*');
            }
            System.out.println();

        }
        System.out.println();
    }

    public void askForNames() {
        String askForPlayerName = "Please enter your name.";

        System.out.println(askForPlayerName);
        yourName = objSC.nextLine().trim();
        String askForOpponentName = "Please enter your opponents name.";
        System.out.println(askForOpponentName);
        opponentsName = objSC.nextLine().trim();
        System.out.println();
    }

    // menu that is going to show all games
    public void mainMenu() {
        String menuMessage = "You are at the main menu for our casino";
        String chooseGame = "Please select a game from the options below";
        System.out.println(menuMessage);
        System.out.println(chooseGame);
        displayGames();
    }

    // displays a list of all games available
    public void displayGames() {
        String gameList = "1) War\n2) Dice Roll game\n3) Go Fish\n4) Craps\n5) Blackjack\n6) Guess a Card\n7) Exit";
        System.out.println(gameList);
        input = objSC.nextInt();
        gotoGame(input);
    }

    // takes in the input from the scanner object and selects the appropriate game
    public void gotoGame(int choice) {
        String wrongChoice = "You have chosen a number not on the list of options below";
        switch (choice) {
            case 1:
                new WarGame(this.yourName, this.opponentsName).startGame();
                mainMenu();
            case 2:
                new DiceGame().startGame();
                mainMenu();
            case 3:
                new GoFish(this.yourName, this.opponentsName).startGame();
                mainMenu();
            case 4:
                new Craps(this.yourName).startGame();
                mainMenu();
            case 5:
                new BlackJack(this.yourName).startGame();
                mainMenu();
            case 6:
                new GuessCard(this.yourName).startGame();
                mainMenu();
            case 7:
                objSC.close();
                System.exit(0);
                break;
            default:
                System.out.println(wrongChoice);
                mainMenu();
        }
    }
}
