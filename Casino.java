package com.codedifferently.casino;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.codedifferently.casino.games.BlackJack;
import com.codedifferently.casino.games.GoFish;
import com.codedifferently.casino.games.Roulette;
import com.codedifferently.casino.games.SevenFreeSlots;
import com.codedifferently.casino.utilities.Player;
import com.codedifferently.casino.utilities.Rules;
import com.codedifferently.casino.utilities.cardenums.Rank;

public class Casino {
    public static void main(String[] args){
        // For testing
        boolean gamePlaying=false;
        Scanner scan=new Scanner(System.in);
        Player bob=new Player("Bob",20,2030.00);
        Player bill=new Player("Bill",25,3400.00);
        Player jill=new Player("Jill",20,8000.00);
        Player lil=new Player("Lil",19,1000.00);
        Player john=new Player("John",21,900.00);
        Queue<Player> queue=new LinkedList<Player>();
        queue.add(bob);
        queue.add(jill);
        queue.add(bill);
        queue.add(lil);
        queue.add(john);

        System.out.printf("\nWhat would you like to play? \n (Go Fish) (Black Jack) (Craps) (Roulette)(Seven Free slots)\n");
        String gameChoice=scan.nextLine();


        if(gameChoice.equalsIgnoreCase("Black Jack")){
            BlackJack blackjack = new BlackJack();
            while(!queue.isEmpty()){
                // Checking if they are able to enter a casino and gamble
                Player currentPlayer=queue.poll();
                if(blackjack.checkIfValid(currentPlayer)){
                    if(blackjack.addPlayer(currentPlayer))
                        System.out.printf("%s has joined the game %s\n",currentPlayer.getName(),blackjack.getGameName());
                }
                else{
                    System.out.printf("%s could not join the game %s\n",currentPlayer.getName(),blackjack.getGameName());
                }
            }
            System.out.printf("Do you want to read the rules of Black Jack? Yes/No \n");
            gameChoice=scan.nextLine();
            if(gameChoice.equalsIgnoreCase("yes"))
                System.out.println("\n"+Rules.blackJackRules()+"\n");
            if(blackjack.startGame()){
                gamePlaying=true;
                blackjack.setUp();
                while(gamePlaying){
                        System.out.println("SIZE OF PLAYING: "+blackjack.getPlayerList().size());
                        for (Player player : blackjack.getPlayerList()) {
                            Player currentPlayer=player;
                            System.out.printf("%s place your bet: ", currentPlayer.getName());
                            double bet=scan.nextDouble();
                            blackjack.bet(currentPlayer, bet);
                        }
                        System.out.println(blackjack.betLog());
                        // Iterating through players and having them make their choices
                        for (Player player : blackjack.getPlayerList()){
                            Player currentPlayer=player;
                            boolean done=false;
                            
                            // Displays Dealer's first card
                            System.out.println(blackjack.showFirstDealerCard());

                            // Displays current player's hand
                            System.out.println(blackjack.showPlayersCards(currentPlayer));

                            // Checks for Ace
                            if(blackjack.checkForAce(player))
                                System.out.printf("Possible outcomes with aces: %s\n", blackjack.convertWithAces(player).toString());

                            // Asking player until stand or bust
                            System.out.printf("%s, What would you like to do? \n (Hit) (Stand) (Double)\n",currentPlayer.getName());
                            String choice=scan.next();
                            while(!choice.equalsIgnoreCase("Stand") && done==false){
                                // Choosing player decision
                                if(choice.equalsIgnoreCase("Hit"))
                                    blackjack.hit(currentPlayer);
                                else if(choice.equalsIgnoreCase("Double")){
                                    blackjack.doubleMove(currentPlayer); 
                                    System.out.println(blackjack.showPlayersCards(currentPlayer));
                                    done=true;
                                }
                                // Checks if player busted
                                if(blackjack.checkIfBusted(currentPlayer)){
                                    done=true;
                                    System.out.println(blackjack.showPlayersCards(currentPlayer));;
                                    blackjack.lose(currentPlayer);
                                    System.out.println("You have busted, thank you for playing.");
                                }
                                // Makes sure if the user ended their turn without busting
                                if(!done){
                                    if(blackjack.checkForAce(player))
                                        System.out.println(blackjack.convertWithAces(player));
                                    System.out.println(blackjack.showPlayersCards(currentPlayer));
                                    System.out.printf("%s, What would you like to do? \n (Hit) (Stand) (Double)\n",currentPlayer.getName());
                                    choice=scan.next();
                                }
                            }
                            // Checking if player busted and added to standing players waiting for results
                            if(!blackjack.checkIfBusted(currentPlayer))
                                blackjack.addStandingPlayer(currentPlayer);
                        }
                        // Displays Dealer's cards
                        System.out.println(blackjack.showDealersCards());
                        blackjack.calculateWinner();
                        System.out.println(blackjack.outcomeLog());
                        System.out.printf("Do you want to play again?: Yes/No\n");
                        gameChoice=scan.next();
                        if(gameChoice.equalsIgnoreCase("yes")){
                            blackjack.resetGame();
                            blackjack.setUp();
                        }
                        else
                            gamePlaying=false;
                    }
                    scan.close();
                }
            else
                System.out.println("Not enough players to start, add more players.");
        } else if(gameChoice.equalsIgnoreCase("Seven Free Slots")){
            SevenFreeSlots sevenFreeSlots = new SevenFreeSlots();
            Player player = new Player("jon", 19, 9);
            sevenFreeSlots.spinReels(player);
    
            System.out.println("Welcome to 7 Free Slots !");
            System.out.printf("Push a button. \n (Bet One) (Bet Max) (SPIN REELS)\n");
            String buttonSelected = scan.nextLine();
            if (buttonSelected.equalsIgnoreCase("Bet One")) {
                System.out.println("SPINNING!\n");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        } 
        
        else if (gameChoice.equalsIgnoreCase("Roulette")){
            Player player = new Player("Kevin", 21, 1000);
            Roulette.mainRoulette();
        }
        
        else if(gameChoice.equalsIgnoreCase("Go Fish")){
            GoFish goFish = new GoFish();

            System.out.print("\n\nWelcome to the Go Fish game!!!" + "\nDo you know how to play (Y/N)? ");
            String choice = scan.nextLine();

            if(choice.equalsIgnoreCase("y"))
                System.out.println("Awesome! Good Luck!! :)");
            if(choice.equalsIgnoreCase("n"))
                System.out.println("That's okay, here are the rules:\n" + Rules.goFishRules());
            
            System.out.print("\nHow many players will be playing? ");
            int numOfPlayers = scan.nextInt();
            System.out.println(""); //buffer

            if(numOfPlayers >= 2){

                goFish.shuffleDeck();
                
                int playerCount = 0;
                while(playerCount  != numOfPlayers){
                    System.out.print("Enter player's name: ");
                    String playerName = scan.next();

                    System.out.print("Enter the player's age: ");
                    int playerAge = scan.nextInt();

                    goFish.addGoFishPlayer(playerName, playerAge);
                    playerCount++;

                    System.out.println(""); //buffer
                }

                goFish.initializePlayers();
                goFish.setCardNumber();
                goFish.deal();

                System.out.print("Each player has been dealt " + goFish.getCardsPerPerson() + " cards. The game will now begin...\n");

                while(goFish.getTotalBookCount() != 13){
                    ArrayList<Player> players = goFish.getGoFishPlayersList();

                    for(int i = 0; i < players.size(); i++){
                        Player p1 = players.get(i);
                    
                        boolean continuePlayerTurn = false;

                        do{
                            System.out.print("\t\tPlayers: ");
                            goFish.printGoFishPlayerList();

                            System.out.println("\n" + goFish.showHand(p1));

                            System.out.print("\n\t" + p1.getName() + ", who do you want to ask? ");
                            String p2 = scan.next();

                            while(!(goFish.getGoFishPlayersList().contains(goFish.getPlayer(p2)))){
                                System.out.print("I'm sorry, that player is not currently in the game. Enter another name: ");
                                p2 = scan.next();
                            }   

                            if(!(goFish.getPlayer(p2) == null)){
                                System.out.print("\twhat number do you want to ask for? ");
                                String rank = scan.next();

                                Player playerWanted = goFish.getPlayer(p2);
                                Rank rankWanted = goFish.getRankNeeded(rank);

                                if(goFish.playerTurn(p1, playerWanted, rankWanted))
                                    continuePlayerTurn = true;

                                goFish.showHand(p1);
                                goFish.checkDeck();
                            }

                            System.out.println(""); //buffer

                        }while(continuePlayerTurn == true);
                    }
                }
            } 
            else    
                System.out.println("You don't have enough players.");
        }   
    }
}