import java.util.ArrayList;

public interface Game {

  public static String gameName; 
  ArrayList<Player> players = new ArrayList<Player>(); 

  //returning the name of the Game
  public static String getGameName() {
    return gameName;
  }
  //Checking to see if the game is won
  public boolean isGameWon(); 

  //not sure what this does
  public void play(); 

  //returns a list of the players
  public ArrayList<Player> getPlayers(); 

  //setting the GameName to a new game
  public static String changeGameName(String name){
    return gameName = name;
  }


  
}