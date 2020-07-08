public class Craps implements Game {
 //we need two die to play craps
  private Dice firstDice;
  private Dice secondDice; 
  private static String gameName; 
  /* No longer needed this variable: 
   keeping track of the playerpoints
   */
  private int points; 

  public Craps(){
    this.points = 0;
    gameName = "Craps";  
  }

  public String getGameName(){
    return gameName; 
  }
  
  public void play(){
    System.out.print("Hello welcome to the Craps Simulation!");
    System.out.println("Enjoy the game!");
  }

  //method checking the sum of the two die 
  public static int sumOfDie(){
    int x = Dice.firstDice.roll().getSide();
    int y = Dice.secondDice.roll().getSide();
    return x + y; 
  }

  /* Note we can definetly change this method:
  */

  //method determines if game is won
  public boolean isGameWon() {
    int sum = sumOfDie();
    if(sum == 7 || sum == 11){ //automatic win 
      return true; 
    } 
    if(sum == 2 || sum == 3 || sum == 12){ //automatic loss
      return false;
    }
    //Otherwise keep rolling 
    while(true){
      int sum2 = sumOfDie();
      if(sum2 == 7){
        return false; 
      }
      if(sum == sum2){
        return true;
      }
    }
  }


  
}