public class Corn extends Plant{
  public static int price = 0;
  public Corn(){
    super("corn",7,100,60);
  }

  public static void updatePrice(){
    price = 40 + (int)(20*Math.random());
  }
}
