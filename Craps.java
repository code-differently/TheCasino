package com.codedifferently.casino.games;
/**
 * @author Taia WilliamsRivera
 */
import java.util.HashMap;
import com.codedifferently.casino.utilities.Dice;
import com.codedifferently.casino.utilities.Player;
import java.util.Scanner;
import com.codedifferently.casino.utilities.Rules;

public class Craps
{ 
    public static final String Assert = null;
    private HashMap<Player,Double> bets;
    static Player player = new Player("Player", 22, 100);
    static Scanner scan = new Scanner(System.in);
    private static double bet;
    private static int winnings;
    private static int losses;
    private Dice dice = new Dice();
    private static Craps ob = new Craps();
    
    static double gameMoney = 100;

    public Craps() {
        this.bets = new HashMap<Player, Double>();
    }

    public Craps(Player player) {
        Craps.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }

    public static double getBet() {
        return bet;
    }

    public int getBetCount() {
        return this.bets.size();
    }

    public void clearBets() {
        this.bets.clear();
    }
    public static boolean getGameStatus()
    {
        return gameStatus;
    }
    public static double getGameMoney()
    {
        return gameMoney;
    }

    static int rollSum = Dice.getRollTotal();
    static boolean gameStatus = true;

    public static boolean playCraps() {
        if (rollSum == 2 || rollSum == 3 || rollSum == 12) {
            System.out.println(" Craps You loss with: " + rollSum);
            losses++;
        } else if (rollSum == 7 || rollSum == 11) {
            System.out.println("You win with: " + rollSum);
            winnings++;
            return true;
        } else {
            int point = rollSum; // numbers such as 4, 5, 6, 8, 9, or 10
            System.out.println("Point: " + point);
            while (true) // roll again
            {
                System.out.println("\nNew roll: " + rollSum);
                if (rollSum == point) {
                    System.out.println("Matched point, won");
                    winnings++;
                    return true;
                }
                if (rollSum == 7) {
                    System.out.println("Sorry you lost with 7");
                    losses++;
                } else
                    System.out.println("No help you still lose");
                losses++;
            }

        }
        System.out.println("Winnings: " + winnings + "\nLosses: " + losses);
        return false;
    }

    public static void win() // gives back two times the bet
    {
        if (playCraps() == true) {

           gameMoney = gameMoney + bet + bet; // adds wagerMoney*2 to player money
            System.out.println("Your game money is now, $" + (Craps.getGameMoney() + bet + bet));
        } else {
            System.out.println("Sorry, you lose the bet"); // player lost
        }
    }

    public static void lose() {
        // does give bet back bet
        System.out.println("Sorry, you lose the bet");
    }

    public static void bet() {
        System.out.println(bet);
        System.out.println(gameMoney);
    }
    
    public static void makeBet() {
        if (getGameMoney() == 0) {
            System.out.println("You don't have any game money");
            System.out.println();
            System.exit(0);
        } else if (getGameMoney() >= bet && bet != 0) {
            gameMoney = getGameMoney() - bet;
            System.out.println("You have chosen to bet, $" + bet + ", goodluck.");
        } /*else if (bet == 0) {
            System.out.println("Input a number to make a bet");
            System.out.println("You only have $" + getGameMoney() + " left, how much would you like to bet?");
            bet = scan.nextInt();
            gameMoney = getGameMoney() - bet;
        }*/ else {
            System.out.println("You don't have enough money, make a smaller bet");
            System.out.println("You only have $" + getGameMoney() + " left, how much would you like to bet?");
            bet = scan.nextInt();
            gameMoney = getGameMoney() - bet;
        }

    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello\nWelcome to the Craps Game!!");
        System.out.println("Have you played before? Y/N.");
        String ans = scan.nextLine();

        // Removes invalid inputs.
        while (!(ans.equalsIgnoreCase("Y")) && !(ans.equalsIgnoreCase("N"))) // used from Roulette
        {
            System.out.println("Incorrect, please type Y/N.");
            ans = scan.nextLine();
        }

        if (ans.equalsIgnoreCase("Y")) {
            System.out.println("Good luck!");
        }

        if (ans.equalsIgnoreCase("N")) {
            System.out.println(Rules.crapsRules());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Let's begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        System.out.println("You have, $" + player.getMoney());

        while (gameStatus == true)
        {
        System.out.println("How much would you like to bet?");
        bet = scan.nextInt();
        System.out.println("You want to bet $" + bet);

        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

        Craps.makeBet();

        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

        System.out.println("You now have, $" + gameMoney + " left");
        System.out.println("Rolling ....");

        try
        {
            Thread.sleep(2000);
        } catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

        Craps.playCraps();
        
        Craps.win();
        
    }
}
}
