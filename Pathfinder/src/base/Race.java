package base;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public abstract class Race implements Dice, Abilities
{
  protected final DecimalFormat FORMAT = new DecimalFormat("#.##");
  
  public static final String DWARF = "Dwarf";
  public static final String ELF = "Elf";
  public static final String GNOME = "Gnome";
  public static final String HALFELF = "Half-Elf";
  public static final String HALFLING = "Halfling";
  public static final String HALFORC = "Half-Orc";
  public static final String HUMAN = "Human";
  
  protected int age;
  protected String gender;
  protected String size;
  protected int baseSpeed;
  protected double height;
  protected double weight;

  protected int abilityScoreBonusToSpend;

  protected HashMap<String, Integer> abilityBonuses =
      new HashMap<String, Integer>(6);
  protected ArrayList<String> languages = new ArrayList<String>();

  public Race(String gender)
  {
    // Set the gender of the player's character
    this.gender = gender;

    abilityScoreBonusToSpend = 0;

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

  public void setAbilityBonuses(String ability, int score)
  {
    abilityBonuses.put(ability, abilityBonuses.get(ability) + score);
  }
  
  public int getAbilityScoreBonusToSpend()
  {
    return abilityScoreBonusToSpend;
  }
  
  public int getAge()
  {
    return age;
  }
  
  public String getHeight()
  {
    return (int) height + "ft. " + FORMAT.format((height % 1) * 12) + " in.";
  }
  
  public String getSize()
  {
    return size;
  }
  
  public String getSpeed()
  {
    return baseSpeed + " ft.";
  }
  
  public String getWeight()
  {
    return FORMAT.format(weight) + " lbs.";
  }

  public abstract int getBaseAge();

  public abstract void setLanguages();

  public abstract String getPhysicalDesc();
  
  public abstract String getRace();

  public abstract void setWeightAndHeight();
}
