public class Wheat extends Plant{
  public static int price = 0;
  public Wheat(){
    super("wheat",5,100,65);
  }

  public static void updatePrice(){
    price = 30 + (int)(20*Math.random());
  }
}
