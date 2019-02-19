package base;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Race implements Dice, Abilities
{
  protected final DecimalFormat FORMAT = new DecimalFormat("#");

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

  protected HashMap<String, Integer> abilityBonuses = new HashMap<String, Integer>(6);
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
  
  /***********************************************************************************************/
  /*
   * BELOW ARE THE SETTERS FOR APPYING DETAILS ABOUT THE PLAYER'S CHARACTER'S.
   */
  /***********************************************************************************************/

  /**
   * Applies the Ability Score Bonus Modifier score to an Ability Score that the player has a bonus
   * for.
   * 
   * @param ability
   *          Ability to modify
   * @param score
   *          Score to modify ability by
   */
  public void setAbilityBonuses(String ability, int score)
  {
    abilityBonuses.put(ability, abilityBonuses.get(ability) + score);
  }

  /***********************************************************************************************/
  /*
   * BELOW ARE THE GETTERS FOR RETREIVING DETAILS ABOUT THE PLAYER'S CHARACTER'S.
   */
  /***********************************************************************************************/

  /**
   * Retrieves the Ability Scores and their Bonus Modifiers available to the player.
   * 
   * @return abilityBonuses
   */
  public HashMap<String, Integer> getAbilityBonuses()
  {
    return abilityBonuses;
  }

  /**
   * Retrieves the Ability Score Bonus Modifier available for the player to spend on any ability of
   * their choice.
   * 
   * @return abilityScoreBonusToSpend
   */
  public int getAbilityScoreBonusToSpend()
  {
    return abilityScoreBonusToSpend;
  }

  /**
   * Returns a String representation of the height of the player's character.
   * 
   * @return height
   */
  public String getHeight()
  {
    if (Math.round((height % 1) * 12) == 12)
      return (int) (height + 1) + "ft.";
    else
      return (int) height + "ft. " + FORMAT.format((height % 1) * 12) + " in.";
  }

  /**
   * Returns the list of languages the player's character knows.
   * 
   * @return languages.
   */
  public ArrayList<String> getLanguages()
  {
    return languages;
  }

  /**
   * Returns the size of the player's character.
   * 
   * @return size
   */
  public String getSize()
  {
    return size;
  }

  /**
   * Returns the speed of the player's character.
   * 
   * @return speed.
   */
  public String getSpeed()
  {
    return baseSpeed + " ft.";
  }

  /**
   * Returns the weight of the player's character.
   * 
   * @return weight
   */
  public String getWeight()
  {
    return FORMAT.format(weight) + " lbs.";
  }

  /**
   * Returns whether the class of the player's character is an Intuitive-learned class.
   * 
   * @param cclass
   *          The String representation of the Class of the player's character
   * @return boolean
   */
  public boolean isIntuitiveClass(String cclass)
  {
    return cclass.equals(Classification.BARBARIAN) || cclass.equals(Classification.ROGUE)
        || cclass.equals(Classification.SORCERER);
  }

  /**
   * Returns whether the class of the player's character is an Self-Taught class.
   * 
   * @param cclass
   *          The String representation of the Class of the player's character
   * @return boolean
   */
  public boolean isSelfTaughtClass(String cclass)
  {
    return cclass.equals(Classification.BARD) || cclass.equals(Classification.FIGHTER)
        || cclass.equals(Classification.PALADIN) || cclass.equals(Classification.RANGER);
  }

  /**
   * Returns whether the class of the player's character is an Trained class.
   * 
   * @param cclass
   *          The String representation of the Class of the player's character
   * @return boolean
   */
  public boolean isTrainedClass(String cclass)
  {
    return cclass.equals(Classification.CLERIC) || cclass.equals(Classification.DRUID)
        || cclass.equals(Classification.MONK) || cclass.equals(Classification.WIZARD);
  }

  /***********************************************************************************************/
  /*
   * BELOW ARE THE ABSTRACT METHODS OF THE RACE CLASS. RACES IMPLEMENT THESE METHODS DIFFERENTLY.
   */
  /***********************************************************************************************/

  /**
   * Retrieves the default alignment of the player's character's Race.
   * 
   * @return alignment
   */
  public abstract String getAlignment();

  /**
   * Retrieves the number to which the player's character's age is modified based on their Race and
   * Class.
   * 
   * @param cclass
   *          The String representation of the Class of the player's character
   * @return ageModifier
   */
  public abstract int getAgeModifier(String cclass);

  /**
   * Retrieves the default age of the player's character's Race.
   * 
   * @return baseAge
   */
  public abstract int getBaseAge();

  /**
   * Retrieves a description of the player's character's Race.
   * 
   * @return description
   */
  public abstract String getDesc();

  /**
   * Sets the list of languages the player's character knows by default because of their Race.
   */
  public abstract void setLanguages();

  /**
   * Returns a String representation of the player's character's Race.
   * 
   * @return
   */
  public abstract String getRace();

  /**
   * Sets the weight and height of the player's character. These are determined by the player's
   * character's Race and gender.
   */
  public abstract void setWeightAndHeight();
}
