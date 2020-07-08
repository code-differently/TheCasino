public class Player 
{
  private String name;
  private double money;

  //ArrayList<Card> cardHand = new ArrayList<Card>();

  public Player()
  {

  }

  public Player(String name,double money)
  {
    this.name = name;
    this.money = money;
  }

  public String getName()
  {
      return name;
  }

  public void setName(String enter)
  {
    name = enter;
  }

  public double getMoney()
  {
      return money;
  }

  public void setMoney(double enter)
  {
    this.money = enter;
  }
}