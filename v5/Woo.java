import java.io.*;
import java.util.*;

public class Woo {
  public ArrayList<Plant> farm;
  public String name;
  public int balance = 500;
  public String currentCrop;
  public int temperature = 50;
  public int day = 0;

  public InputStreamReader isr;
  public BufferedReader in;

  public Woo() {
    isr = new InputStreamReader(System.in);
    in = new BufferedReader(isr);
    newFarm();
  }

  public int searchFarm(String cropName){
    int count = 0;
    for (int idx = 0; idx<farm.size();idx++){
      Plant crop = farm.get(idx);
      if (crop._name.equals(cropName)&&crop._growTime==0&&crop._health>0){
        count++;
      }
    }
    return count;
  }

  public void dayMethod(){
    for (int idx = 0; idx<farm.size();idx++){
      Plant crop = farm.get(idx);
      crop.dayMethod(temperature);
    }
  }

  public int cleanFarm(String cropName, int cropsSold){
    int count = 0;
    for (int idx = cropsSold-1; idx>=0;idx--){
      Plant crop = farm.get(idx);
      if (crop._name.equals(cropName)&&crop._growTime==0&&crop._health>0){
        farm.remove(idx);
      }
    }
    return count;
  }

  public boolean buyCrop(String name,int quantity){
    int price = Plant.getSeedPrice(name);
    if (balance>=price*quantity){
      balance-= price*quantity;
      for (int i = 0 ; i<quantity;i++){
        Plant newPlant;
        if (name.equals("wheat")){
          newPlant = new Wheat();
        } else if (name.equals("corn")){
          newPlant = new Corn();
        } else if (name.equals("potato")){
          newPlant = new Potato();
        } else if (name.equals("beans")){
          newPlant = new Beans();
        } else if (name.equals("golden beans")){
          newPlant = new GoldenBeans();
        } else{
          newPlant = new GoldenBeans();
        }
        farm.add(newPlant);
      }
      return true;
    } else {
      return false;
    }
  }


  public void newFarm() {
    farm = new ArrayList<Plant>();
    String s= "Welcome to Adventure Farm. What would you like your farm to be called?";
    System.out.print(s);
    try {
      name = in.readLine();
    }catch(IOException e){System.out.println(e);}
    s = "Welcome, " + name;
    System.out.println(s);
  }

  public void playTurn() {
    System.out.println("==========================================");
    day += 1;
    dayMethod();
    farmReport();
    System.out.println("Choose the crop you want to farm today:");
    System.out.println("-wheat");
    System.out.println("-corn");
    System.out.println("-potato");
    System.out.println("-beans");
    System.out.println("-golden beans\n");
    try {
	    currentCrop =  in.readLine() ;
    }
    catch ( IOException e ) { }
    System.out.println("You can buy "+(balance/Plant.getSeedPrice(currentCrop))+" "+currentCrop+" seeds");
    System.out.println("How many "+currentCrop+" seeds do you want to buy today?\n");
    int quantity = 0;
    try {
	    quantity =  Integer.parseInt(in.readLine()) ;
    }
    catch ( IOException e ) {System.out.println("too broke, no crops bought");}

    buyCrop(currentCrop,quantity);
    System.out.println("You have "+balance+" coins remaining");
    int availableCrops = searchFarm(currentCrop);
    System.out.println("You have "+availableCrops+" "+currentCrop+" available to sell today. How many would you like to sell?");
    try {
	    quantity =  Integer.parseInt(in.readLine()) ;
    }
    catch ( IOException e ) {System.out.println("not an integer");}
    System.out.println("You made "+quantity*Plant.getSellPrice(currentCrop)+" coins from sale of "+currentCrop);
    cleanFarm(currentCrop,quantity);
    balance+=quantity*Plant.getSellPrice(currentCrop);
    //maybe tell them how many were sold
  }

  public void farmReport() {
    Plant.updatePrices();
    System.out.println("Today is day "+day);
    System.out.println("You have "+balance+" coins\n");
    System.out.println("Today wheat sells for " +Wheat.price);
    System.out.println("Today corn sells for " +Corn.price);
    System.out.println("Today potato sells for " +Potato.price);
    System.out.println("Today beans sells for " +Beans.price);
    System.out.println("Today golden beans sells for " +GoldenBeans.price);
    temperature = (int) (Math.random()*80)+10;
    System.out.println("Your Crops:");
    for (int idx = 0; idx<farm.size();idx++){
      Plant crop = farm.get(idx);
      System.out.println(crop._name+":"+crop._health);
    }
    Greenhouse();
    System.out.println("\nToday's temperature is "+temperature+ " degrees");
  }

  public void Greenhouse() {
    String z = "";
    if (balance >= 800){
      //change to rent instead of buy
      System.out.println("You have "+balance+" coins, which is enough to rent a greenhouse, allowing you to control temperature today. Do you want to rent it? (yes or no)");
      try {z = in.readLine();
      }catch ( IOException e) {}
        if (z.equals ("yes")) {
        System.out.println("What do you want to set the temperature to?");
        try {
          temperature = Integer.parseInt(in.readLine());
        }catch ( IOException e ) {System.out.println(e);}
        balance-=2000;
      }
    }
  }

  public static void main(String[] args) {
    Woo Farm = new Woo();
    while (true){
      Farm.playTurn();
    }
  }
}
