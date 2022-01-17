import java.io.*;
import java.util.*;

public class Woo {
  public Plant[] farm;
  public String name;
  public int balance = 1000;
  public int day;
  public int stamina;

  public InputStreamReader isr;
  public BufferedReader in;

  public Woo() {
    isr = new InputStreamReader(System.in);
    in = new BufferedReader(isr);
    newFarm()
  }

  public void newFarm() {
    String s;
    s += "Welcome to Adventure Farm. What would you like your farm to be called?";
    System.out.print(s);
    try {
      name = in.readLine();
    }
    s = "Welcome, " + name;
    System.out.println(s);
  }

  public void playTurn() {
    day += 1;
    System.out.println("");

  }

  public String farmReport() {

  }

  public static void main(String[] args) {
    Woo Farm = new Woo;
  }
}
