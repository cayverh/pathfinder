package races;

import java.util.ArrayList;
import java.util.HashMap;

import base.Abilities;
import dice.Die;

public class CoreRace implements Abilities
{
  protected Die die;
  
  protected int age;
  protected String gender;
  protected String size;
  protected int baseSpeed;
  protected double baseHeight;
  protected double baseWeight;
  protected double height;
  protected double weight;
  
  protected HashMap<String, Integer> abilityBonuses;
  protected ArrayList<String> languages;

  public CoreRace()
  {
    age = 0;
    gender = "";
    size = "";
    baseSpeed = 0;
    baseHeight = 0;
    baseWeight = 0;
    height = 0;
    weight = 0;
    
    abilityBonuses = new HashMap<String, Integer>(6);
    languages = new ArrayList<String>();
    
    abilityBonuses.put(STR, 0);
    abilityBonuses.put(DEX, 0);
    abilityBonuses.put(CON, 0);
    abilityBonuses.put(INT, 0);
    abilityBonuses.put(WIS, 0);
    abilityBonuses.put(CHA, 0);
  }
  
  public HashMap<String, Integer> getAbilityBonuses()
  {
    return abilityBonuses;
  }
  
  public int getStrBonus()
  {
    return abilityBonuses.get(STR);
  }
  
  public int getDexBonus()
  {
    return abilityBonuses.get(DEX);
  }
  
  public int getConBonus()
  {
    return abilityBonuses.get(CON);
  }
  
  public int getIntBonus()
  {
    return abilityBonuses.get(INT);
  }
  
  public int getWisBonus()
  {
    return abilityBonuses.get(WIS);
  }
  
  public int getChaBonus()
  {
    return abilityBonuses.get(CHA);
  }

  /*
   * public abstract void genReligion(); public abstract void genAlignemnt(); public abstract void
   * genPhysicalDesc(); public abstract void genHistory();
   */
}
