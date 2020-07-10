package com.codedifferently.casino;

public abstract class Gamble extends Game
{
    private String moneyType;
    private String prize;

    public double wageMoney(Player p, double d)
    {
        p.setMoney(p.getMoney() - d);
        return d;
    }

    public String getMoneyType()
    {
        return moneyType;
    }
    public void setMoneyType(String moneyType)
    {
        this.moneyType = moneyType;
    }

    public String getPrize()
    {
        return prize;
    }

    public void setPrize(String prize)
    {
        this.prize = prize;
    }
}
