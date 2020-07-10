package com.codedifferently.casino;

public abstract class Game
{
    public static Player playerOne;
    public static Player playerTwo;

    public abstract void startGame();
    public abstract void resetGame();


    public String losingMessage(Player p)
    {
        return "Dang, " + p.getName() + " you lost, with a score of " + p.getScore() + ". But guess what, you'll get em next time!";
    }

    public String winnerMessage(Player p)
    {
        return "Wow! " + p.getName() + " great job, you've won the game with a score of " + p.getScore();
    }

    public abstract void tieMessage();

    public abstract void checkStandings();
}
