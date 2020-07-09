package com.codedifferently.casino;
import java.util.Random;
public class Die {
    private int value;

    public Die(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int val) {
        if(val < 0 || val > 6) {
            System.out.println("Can't put in a negative value or a value greater than 6. The value of the die will not be changed");
        }
        else {
            this.value = val;
        }
    }

    public int rollDice() {
        //won't use this elsewhere so we declare it as a local variable
        Random random = new Random();
        //returns an integer in between 1 and 6, (without the plus 1 it would be in the range 0 to 5)
        //6 because it is a 6 sided die
        return random.nextInt(6) + 1;
    }
}
