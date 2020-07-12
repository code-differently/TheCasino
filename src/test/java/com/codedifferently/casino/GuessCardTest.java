package com.codedifferently.casino;

import org.junit.Assert;
import org.junit.Test;


public class GuessCardTest {

    @Test
    public void CheckStandingTestTooLow() {

        // Given
        GuessCard test = new GuessCard("Bowser");
        test.getRandCardVal();
        test.setGuess(test.getRandCardVal() - 1);
        String expected = "Your guess was too low: Guess a number higher than " + test.getGuess();

        // When
        test.checkStandings();
        String actual = test.getMessage();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void CheckStandingTestTooHigh() {

        // Given
        GuessCard test = new GuessCard("Bowser");
        test.getRandCardVal();
        test.setGuess(test.getRandCardVal() + 1);
        String expected = "Your guess was too high: Guess a number lower than " + test.getGuess();

        // When
        test.checkStandings();
        String actual = test.getMessage();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void CheckStandingTestJustRight() {

        // Given
        GuessCard test = new GuessCard("Bowser");
        test.getRandCardVal();
        test.setGuess(test.getRandCardVal());
        String expected = "Wow! "+ test.playerOne.getName() + " great job, you've won the game with a score of 1";

        // When
        test.checkStandings();
        String actual = test.getMessage();

        // Then
        Assert.assertEquals(expected, actual);
    }
}
