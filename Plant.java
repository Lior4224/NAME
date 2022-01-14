public class Plant {
  public String _name;
  public int _growTime;
  //public int _survivability;
  public int _health;
  public int _idealTemperature;

  public Plant(String name, int growTime, int survivability, int health) {
    _name = name;
    _growTime = growTime;
  //  _survivability = survivability;
    _health = health;
  }

  public void dayMethod(int temp) {
    _growTime --;
    _health+=20-Math.abs(temp-_idealTemperature);
  }
}
