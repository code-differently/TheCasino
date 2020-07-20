package com.codedifferently.casino.games;

import com.codedifferently.casino.intereface.Gamble;
import com.codedifferently.casino.utilities.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class SevenFreeSlots implements Gamble {

    private int numberPresses;
    private String slot1;
    private String slot2;
    private String slot3;


    final static ArrayList<String> slots = new ArrayList<String>(20);

    public SevenFreeSlots(){

        numberPresses = 0;

        slots.add("BAR");
        slots.add("BAR"); 
        slots.add("BAR");
        slots.add("WILD");
        slots.add("WILD");
        slots.add("WILD");
        slots.add("WILD");
        slots.add("WILD");
        slots.add("7RED");
        slots.add("7RED");
        slots.add("7RED");
        slots.add("7BLUE");
        slots.add("7BLUE");
        slots.add("7BLUE");
        slots.add("7WHITE");
        slots.add("CHERRY");
        slots.add("CHERRY");
        slots.add("CHERRY");
        slots.add("CHERRY");
        slots.add("BLANK");
        slots.add("BLANK");

    }

    public String getSlot(){
        this.slot1 = slot1;
        this.slot2 = slot2;
        this.slot3 = slot3;

        return slot1 + slot2 + slot3;

        //use to string to format it nicely
    }

    // Game buttons
    public void spinReels(Player player) {
        player.gamble(3);

        slot1 =  slots.get((int)Math.random() * 50 +1);
        slot2 =  slots.get((int)Math.random() * 50 +1);
        slot3 =  slots.get((int)Math.random() * 50 +1);
        for (int i = 0; i < slots.size(); i++) {
            System.out.println(slots.get(i));
        }
    }
    
    public void betMax(Player player) {
        player.gamble(3);

        slot1 =  slots.get((int)Math.random() * 50 +1);
        slot2 =  slots.get((int)Math.random() * 50 +1);
        slot3 =  slots.get((int)Math.random() * 50 +1);
    }

    public void betOne(Player player) {
        player.gamble(1);

        slot1 =  slots.get((int)Math.random() * 50 +1);
        slot2 =  slots.get((int)Math.random() * 50 +1);
        slot3 =  slots.get((int)Math.random() * 50 +1);


        // TODO: Push a button marked "Bet One" until you've reached the number of coins you wish to play

        // TODO: Then when spin reels is pressed deduct that amount of coins from player money, max is still 3
    }

    // Stats
    public void win(Player player) {
        // TODO: calculate winnings for current bet and update money

        // TODO: report if Gambler won or lost

        // TODO: Check to see if they still have money left
    }

    public void lose(Player player) {


    }

    public void bet(Player player, double money ) {

    }

    public static void main(String[] args) {
        SevenFreeSlots sevenFreeSlots = new SevenFreeSlots();
        Player player = new Player("jon", 19, 9);
        Scanner scan = new Scanner(System.in);
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
}