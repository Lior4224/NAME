public class Beans extends Plant{
  public static int price = 0;
  public Beans(){
    super("beans",15,100,80);
  }

  public static void updatePrice(){
    price = 185 + (int)(30*Math.random());
  }
}
