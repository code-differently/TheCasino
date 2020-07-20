package com.codedifferently.casino.utilities;

import java.util.Random;

public class BallResults {
    public RouletteBall generate() {

        RouletteBall ball = new RouletteBall();
        
        //Generates a number between 0 - 36.
        Random rand = new Random();
        int ballNumber = rand.nextInt(36);
        ball.setNumber(ballNumber);
        ball.setColor(determineColor(ballNumber));
        ball.setEven(oddOrEven(ballNumber));
    return ball;
}


private String determineColor(int numberLandedOn) {
    String color;
    // If the ball number is 0, assign it green.
    if (numberLandedOn == 0) {
        color = ("green " + numberLandedOn);
    }


    // If the ball number is even, assign it black.
    else if (numberLandedOn % 2 == 0) {
        color = ("black " + numberLandedOn);
    }

    // If the ball number is odd, assign it red.
    else {
        color = ("red " + numberLandedOn);

    }
    return color;
}


private boolean oddOrEven(int numberLandedOn) {
    boolean even = false;
    if (numberLandedOn == 0){
        even = true;
    }

    if (numberLandedOn % 2 == 0){
        even = true;
    }

    if (numberLandedOn % 2 == 1){
        even = false;
    }
    return even;
}

}