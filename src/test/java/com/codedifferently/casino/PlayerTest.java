package com.codedifferently.casino;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {
    Player p1;

    @Test
    public void constructorDefaultTest() {
        p1 = new Player();

        String expectedName = "Unknown Name";
        double expectedMoney = 0.00;
        boolean expectedHasWon = false;
        String actualName = p1.getName();
        double actualMoney = p1.getMoney();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedMoney, actualMoney, 0.001);
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

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedMoney, actualMoney, 0.00);
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

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedMoney, actualMoney, 0.00);
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

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedMoney, actualMoney, 0.00);
    }

    @Test
    public void getNameTest() {
        String name = "Curry";
        p1 = new Player(name);

        String expectedName = name ;
        String actualName = p1.getName();

        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void getMoneyTest() {
        double money = 50.25;
        p1 = new Player(money);

        double expectedMoney = money ;
        double actualMoney = p1.getMoney();

        Assert.assertEquals(expectedMoney, actualMoney, 0.00);
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

}

