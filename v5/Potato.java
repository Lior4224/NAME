public class Potato extends Plant{
  public static int price = 0;
  public Potato(){
    super("potato",5,100,40);
  }
  public static void updatePrice(){
    price = 140 + (int)(20*Math.random());
  }
}
