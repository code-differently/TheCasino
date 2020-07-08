package com.codedifferently.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
    Player p1;
    @Before
    public void setup() {
        //p1 = new Player();
    }


    @Test
    public void constructorDefaultTest() {
        p1 = new Player();

        String expectedName = "Unknown Name";
        double expectedMoney = 0.00;
        boolean expectedHasWon = false;
        String actualName = p1.getName();
        double actualMoney = p1.getMoney();
        boolean actualHasWon = p1.getHasWon();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedMoney, actualMoney, 0.001);
        Assert.assertEquals(expectedHasWon, actualHasWon);
    }

    @Test
    public void constructorOnlyNameTest() {
        String name = "Bobby Buckets";
        p1 = new Player(name);

        String expectedName = name;
        double expectedMoney = 0.00;
        boolean expectedHasWon = false;
        String actualName = p1.getName();
        double actualMoney = p1.getMoney();
        boolean actualHasWon = p1.getHasWon();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedMoney, actualMoney, 0.00);
        Assert.assertEquals(expectedHasWon, actualHasWon);
    }

    @Test
    public void constructorOnlyMoneyTest() {
        double money = 502.50;
        p1 = new Player(money);

        String expectedName = "Unknown Name";
        double expectedMoney = money;
        boolean expectedHasWon = false;
        String actualName = p1.getName();
        double actualMoney = p1.getMoney();
        boolean actualHasWon = p1.getHasWon();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedMoney, actualMoney, 0.00);
        Assert.assertEquals(expectedHasWon, actualHasWon);
    }

    @Test
    public void constructorAllArgsTest() {
        String name = "Bobby Buckets";
        double money = 502.50;
        p1 = new Player(name, money);

        String expectedName = name;
        double expectedMoney = money;
        boolean expectedHasWon = false;
        String actualName = p1.getName();
        double actualMoney = p1.getMoney();
        boolean actualHasWon = p1.getHasWon();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedMoney, actualMoney, 0.00);
        Assert.assertEquals(expectedHasWon, actualHasWon);
    }

    @Test
    public void setNameTest() {
        String name = "Curry";
        p1 = new Player();

        String expectedName = name ;
        p1.setName("Curry");
        String actualName = p1.getName();

        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void setMoneyTest() {
        double money = 50.25;
        p1 = new Player();

        double expectedMoney = money ;
        p1.setMoney(money);
        double actualMoney = p1.getMoney();

        Assert.assertEquals(expectedMoney, actualMoney, 0.00);
    }

    @Test
    public void setHasWonTest() {
        boolean hasWon = true;
        p1 = new Player();

        boolean expectedHasWon = hasWon ;
        p1.setHasWon(hasWon);
        boolean actualHasWon = p1.getHasWon();

        Assert.assertEquals(expectedHasWon, actualHasWon);
    }

}
