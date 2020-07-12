package com.codedifferently.casino;

import org.junit.Assert;
import org.junit.Test;


public class GuessCardTest {

    @Test
    public void CheckStandingTest1() {

        // Given
        GuessCard test = new GuessCard();
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
    public void CheckStandingTest2() {

        // Given
        GuessCard test = new GuessCard();
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
    public void CheckStandingTest3() {

        // Given
        GuessCard test = new GuessCard();
        test.getRandCardVal();
        test.setGuess(test.getRandCardVal());
        String expected = "Wow! Mom great job, you've won the game with a score of 1";

        // When
        test.checkStandings();
        String actual = test.getMessage();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void CheckStandingTest4() {

        // Given
        GuessCard test = new GuessCard();
        test.getRandCardVal();
        test.setCount(5);
        test.setGuess(test.getRandCardVal()+1);
        String expected = "Dang, Mom you lost, with a score of 0. But guess what, you'll get em next time!";

        // When
        test.checkStandings();
        String actual = test.getMessage();

        // Then
        Assert.assertEquals(expected, actual);
    }




}
