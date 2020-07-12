package com.codedifferently.casino;
import java.util.Random;
public class Die {

    public int rollDice() {
        DieValue value = DieValue.roll();
        return value.getValue();
    }
    private enum DieValue{
        ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6);
        private int value;

        public int getValue(){
            return value;
        }
        private DieValue(int value){
            this.value = value;
        }
        public static DieValue roll(){
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }
}
