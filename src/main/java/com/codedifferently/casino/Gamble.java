package com.codedifferently.casino;

public interface Gamble
{
    //set the default prize to money
    String prize = "Money";
    //set the default moneyType to money
    String moneyType = "Money";

    public void wageMoney(double money);
    public String getMoneyType();
    public void setMoneyType(String moneyType);
    public String getPrize();
    public void setPrize(String prize);
}
