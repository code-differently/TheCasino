package com.codedifferently.casino;

import org.junit.Assert;
import org.junit.Test;

public class SuitTest {

    @Test
    public void HeartsTest() {
        // Given
        Suit s = Suit.HEARTS;

        // When
        String expected = "HEARTS";
        String actual = s.name();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void SpadesTest() {
        // Given
        Suit s = Suit.SPADES;

        // When
        String expected = "SPADES";
        String actual = s.name();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void DiamondsTest() {
        // Given
        Suit s = Suit.DIAMONDS;

        // When
        String expected = "DIAMONDS";
        String actual = s.name();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void ClubsTest() {
        // Given
        Suit s = Suit.CLUBS;

        // When
        String expected = "CLUBS";
        String actual = s.name();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getSuitTest() {
        // Given
        Suit s = Suit.HEARTS;

        // When
        String expected = "HEARTS";
        String actual = s.getSuit();

        // Then
        Assert.assertEquals(expected, actual);
    }

}
