package base;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

import abilities.Abilities;

public abstract class Race implements Dice, Abilities, Languages
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
  protected String size;
  protected int baseSpeed;
  protected double height;
  protected double weight;

  protected int abilityScoreBonusToSpend;
  protected boolean canLearnLang;

  protected HashMap<String, Integer> abilityBonuses = new LinkedHashMap<String, Integer>(6);
  protected ArrayList<String> languages = new ArrayList<String>();
  protected ArrayList<String> languagesToLearn = new ArrayList<String>();
  protected HashMap<String, String> racialTraits = new LinkedHashMap<String, String>();

  public Race()
  {
    abilityScoreBonusToSpend = 0;
    canLearnLang = false;

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
    if (!ability.equals(STR) && !ability.equals(DEX) && !ability.equals(CON) && !ability.equals(INT)
        && !ability.equals(WIS) && !ability.equals(CHA))
    {
      int a = new Random().nextInt(6);

      switch (a)
      {
        case 0:
          ability = STR;
          break;
        case 1:
          ability = DEX;
          break;
        case 2:
          ability = CON;
          break;
        case 3:
          ability = INT;
          break;
        case 4:
          ability = WIS;
          break;
        case 5:
          ability = CHA;
          break;
      }
    }
    
    abilityBonuses.put(ability, abilityBonuses.get(ability) + score);
  }

  /**
   * If the player's character has a high enough INT, they can learn a new language. This determines
   * whether or not that condition is true.
   * 
   * @param b
   *          condition
   */
  public void setCanLearnLang(boolean b)
  {
    canLearnLang = b;
  }

  /**
   * Sets the racial traits of the player's characters.
   * 
   * @param trait
   *          The racial trait
   * @param desc
   *          The description of the trait
   */
  public void setRacialTraits(String trait, String desc)
  {
    racialTraits.put(trait, desc);
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
   * Returns whether or not the player's character can learn a new language or not.
   * 
   * @return canLearnLang
   */
  public boolean getCanLearnLang()
  {
    return canLearnLang;
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
      return (int) height + " ft. " + FORMAT.format((height % 1) * 12) + " in.";
  }
  
  public int getFeet()
  {
    if (Math.round((height % 1) * 12) == 12)
      return (int) (height + 1);
    else
      return (int) height;
  }
  
  public int getInches()
  {
    return (int) ((height % 1) * 12);
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
   * Returns the list of languages the player's character can learn.
   * 
   * @return languagesToLearn.
   */
  public ArrayList<String> getLanguagesToLearn()
  {
    return languagesToLearn;
  }

  /**
   * Returns a formatted String listing all of the Races.
   * 
   * @return allRaces
   */
  public static String getAllRaces()
  {
    return String.format("\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n", DWARF, ELF, GNOME, HALFELF,
        HALFORC, HALFLING, HUMAN);
  }
  
  public static String[] getRaces()
  {
	  return new String[]{DWARF, ELF, GNOME, HALFELF, HALFORC, HALFLING, HUMAN};
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

  public int getAge()
  {
    return age;
  }
  
  /**
   * Retrieves the number to which the player's character's age is modified based on their Race and
   * Class.
   * 
   * @param cclass
   *          The String representation of the Class of the player's character
   * @return ageModifier
   */
  public abstract void setAge(String cclass);

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
   * Sets the weight and height of the player's character. These are determined by the player's
   * character's Race and gender.
   */
  public abstract void setHeight(String gender);

  public abstract void setWeight(String gender);
}
