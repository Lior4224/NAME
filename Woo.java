import java.io.*;
import java.util.*;

public class Woo {
  public ArrayList<Plant> farm;
  public String name;
  public int balance = 500;
  public int day;
  public int stamina;
  public String currentCrop;

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

  public int cleanFarm(String cropName){
    int count = 0;
    for (int idx = farm.size()-1; idx>=0;idx--){
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
        newPlant = new Wheat();
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
    day += 1;
    System.out.println("Choose the crop you want to farm today");
    System.out.println("-wheat");
    System.out.println("-corn");
    System.out.println("-potato");
    System.out.println("-beans");
    System.out.println("-golden beans");
    try {
	    currentCrop =  in.readLine() ;
    }
    catch ( IOException e ) { }
    System.out.println("You can buy"+(balance/Plant.getSeedPrice(currentCrop))+currentCrop);
    System.out.println("How many "+currentCrop+" do you want to buy today");
    int quantity = 0;
    try {
	    quantity =  Integer.parseInt(in.readLine()) ;
    }
    catch ( IOException e ) {System.out.println("too broke, no crops bought");}
    buyCrop(currentCrop,quantity);
    System.out.println("You have "+balance+" coins remaining");
    int availableCrops = searchFarm(currentCrop);
    System.out.println("You made "+availableCrops*Plant.getSellPrice(currentCrop)+" coins from sale of crops");
    balance+=availableCrops*Plant.getSellPrice(currentCrop);
    //maybe tell them how many were sold
  }

  // public String farmReport() {
  //
  // }

  public static void main(String[] args) {
    Woo Farm = new Woo();
    while (true){
      Farm.playTurn();
    }
  }
}
