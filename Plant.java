public class Plant {
  public String _name;
  public int _growTime;
  public int _health;
  public int _idealTemperature;

  public Plant(String name, int growTime, int health) {
    _name = name;
    _growTime = growTime;
    _health = health;
  }


  public void dayMethod(int temp) {
    if (health>0){
      _growTime --;
      _health+=20-Math.abs(temp-_idealTemperature);
    }
  }

  public static int getSeedPrice(String plantName){
    if (plantName.equals("wheat")){
      return 20;
    }
    if (plantName.equals("corn")){
      return 40;
    }
    if (plantName.equals("potato")){
      return 70;
    }
    if (plantName.equals("beans")){
      return 100;
    }
    if (plantName.equals("golden beans")){
      return 700;
    }
  }

  public static int getSellPrice(String plantName){
    if (plantName.equals("wheat")){
      return 40;
    }
    if (plantName.equals("corn")){
      return 50;
    }
    if (plantName.equals("potato")){
      return 100;
    }
    if (plantName.equals("beans")){
      return 150;
    }
    if (plantName.equals("golden beans")){
      return 1000;
    }
  }
}
