package base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import abilities.Abilities;
import abilities.AbilityScores;

/**
 * The creation of a Pathfinder character.
 * 
 * The user enters information into a GUI, which is passed to this class.
 * 
 * @author Cayleigh
 *
 */
public class Character implements Abilities
{
  public static final int MAX = 6;
  public static final int MIN = 1;

  private String player;

  private String height;
  private String weight;
  private int age;
  private int level;
  private String size;
  private String alignment;
  private String charName;
  private String diety;
  private String eyeColor;
  private String gender;
  private String hairColor;
  private String homeland;

  private Race charRace;

  private Classification charClass; // HP, starting wealth, skills, and skill ranks, base attack
                                    // bonus, fort save, ref save, and will save are determined by
                                    // class

  private HashMap<String, Integer> abilityScores = new LinkedHashMap<String, Integer>(6);
  private HashMap<String, Integer> abilityMods = new LinkedHashMap<String, Integer>(6);

  AbilityScores abilities;
  
  private ArrayList<String> languages;

  /**
   * Creates a new Pathfinder character based on user input. If a user omits information, details
   * are either randomly generated or left blank.
   * 
   * @param player
   *          The name of the player
   * @param charName
   *          The name of the player's character
   * @param gend
   *          The gender of the player's character
   * @param align
   *          The alignment of the player's character
   * @param race
   *          The Race of the player's character
   * @param cclass
   *          The Classification of the player's character
   */
  public Character(String player, String charName, String gend, String align, String race,
      String cclass, String hairColor, String eyeColor, int age, String diety, String home,
      int level, AbilityScores as)
  {
    this.player = player;
    this.charName = charName;
    alignment = align;
    this.age = age;
    this.diety = diety;
    this.homeland = home;
    this.level = level;

    abilities = as;
    
    gender = Generator.genGender(gend);

    // Gets the Race of the character based on user input.
    // If none, a Race is randomly generated.
    charRace = Generator.genRace(race);
    charRace.setHeight(gend);
    charRace.setWeight(gend);
    
    height = charRace.getHeight();
    weight = charRace.getWeight();

    charClass = Generator.genClass(cclass, abilities.getAbilityMods(), level);
    charClass.setSkillTotals();

    setAppearance(hairColor, eyeColor);
  }
  
  public Character(String player, String charName, String gend, String align, Race race,
      Classification cclass, String hairColor, String eyeColor, String height, String weight, int age, String diety, String home,
      int level)
  {
    this.player = player;
    this.charName = charName;
    alignment = align;
    this.age = age;
    this.diety = diety;
    this.homeland = home;
    this.level = level;

    gender = Generator.genGender(gend);

    // Gets the Race of the character based on user input.
    // If none, a Race is randomly generated.
    charRace = race;
    this.height = height;
    this.weight = weight;

    charClass = cclass;
    charClass.setSkillTotals();

    setAppearance(hairColor, eyeColor);
  }

  /********************************************************************************************************/
  /*
   * BELOW ARE THE SETTERS/GENERATORS FOR APPLYING DETAILS TO THE PLAYER'S CHARACTER.
   */
  /********************************************************************************************************/

  /**
   * Sets the player's character's appearance.
   * 
   * @param hairColor
   *          Color of character's hair
   * @param eyeColor
   *          Color of character's eyes
   */
  public void setAppearance(String hairColor, String eyeColor)
  {
    if (hairColor != null)
      this.hairColor = hairColor;
    else
      this.hairColor = "";

    if (eyeColor != null)
      this.eyeColor = eyeColor;
    else
      this.eyeColor = "";
  }

  /**
   * Generate random scores for the six abilities: Strength, Dexterity, Constitution, Intelligence,
   * Wisdom, and Charisma.
   */
  public void genAbilityScores()
  {
    Generator.genAbilityScores(abilities.getAbilityScores());
  }

  /**
   * Generate the ability modifiers of the six abilities: Strength, Dexterity, Constitution,
   * Intelligence, Wisdom, and Charisma.
   */
  public void genAbilityMods()
  {
    Generator.genAbilityMods(abilities.getAbilityScores(), abilities.getAbilityMods(), charRace);

    if (abilityMods.get(INT) > 0)
      charRace.setCanLearnLang(true);
    else
      charRace.setCanLearnLang(false);
  }

  /**
   * Applies an Ability Score Bonus Modifier to an ability of the player's choice. If the player has
   * a Modifier to spend, the Ability Modifiers are regenerated in order to account for the change
   * in Ability Score.
   * 
   * @param ability
   *          Ability to spend bonus on
   */
  public void setAbilityScoreMod(String ability)
  {
    int toSpend = charRace.getAbilityScoreBonusToSpend();

    abilityScores.put(ability, abilities.getAbilityScores().get(ability) + toSpend);

    if (toSpend != 0)
      genAbilityMods();
  }

  /**
   * Adds a language to the list of languages known to the player's character.
   * 
   * @param language
   *          A language the player's character knows.
   */
  public void addLanguage(String language)
  {
    languages.add(language);
  }

  /**
   * Sets the list of languages known to the player's character.
   */
  public void setLanguages()
  {
    languages = getLanguages();
  }

  /********************************************************************************************************/
  /*
   * BELOW ARE THE GETTERS FOR RETREIVING DETAILS ABOUT THE PLAYER'S CHARACTER.
   */
  /********************************************************************************************************/

  /**
   * Creates a formatted String representing the Ability Scores and Modifiers of the player's
   * character.
   * 
   * @return abilityInfo
   */
  public String getAbilityInfo()
  {
    String abilityInfo = "";

    for (String ability : abilities.getAbilityScores().keySet())
    {
      abilityInfo += String.format("\t%s: %s, Mod: %s\n", ability, abilities.getAbilityScores().get(ability),
          abilities.getAbilityMods().get(ability));
    }

    return abilityInfo;
  }

  /**
   * Returns the age of the player's character. If the player doesn't enter a desired age, the age
   * is generated based on Race and Class.
   * 
   * @return age
   */
  public int getAge()
  {
    if (age == 0)
      return charRace.getAge();
    else
      return age;
  }

  /**
   * Returns the character's alignment. If an alignment isn't provided by the user, the alignment is
   * set as the character's Race default alignment.
   * 
   * @return alignment
   */
  public String getAlignment()
  {
    if (alignment.isEmpty())
      alignment = charRace.getAlignment();

    return alignment;
  }

  /**
   * Creates a formatted String representing the general information about the player's character.
   * 
   * @return charInfo
   */
  public String getGeneralCharInfo()
  {
    String charInfo = "";

    charInfo += String.format("   Player Name: %-20.20s\n", player);
    charInfo += String.format("     Character: %s\t\t\t      Age: %d\n", charName, getAge(),
        charRace.getBaseAge());
    charInfo += String.format("\tGender: %-20.20s\t     Size: %s\n", gender, getSize());
    charInfo +=
        String.format("\tHeight: %-20.20s\t   Weight: %-20.10s\n", getHeight(), getWeight());
    charInfo += String.format("    Hair Color: %-20.20s\tEye Color: %s\n", hairColor, eyeColor);

    charInfo += "\n";

    charInfo +=
        String.format("\t  Race: %-20.20s\t    Class: %s\n", getRace().toString(), getClassification().toString());
    charInfo += String.format("     Alignment: %-20.20s\t    Diety: %s\n", alignment, diety);
    charInfo += String.format("      Homeland: %-20.20s\n\n", homeland);

    return charInfo;
  }

  public String getSkillInfo()
  {
    String abilityInfo = "";

    abilityInfo += String.format("%21s    %s\t   %s    %s\n", "Skill", "Total", "Mod", "Ranks");
    abilityInfo += String.format("%21s    %s\t  %s   %s\n", "-----", "-----", "-----", "-----");
    abilityInfo += String.format("%s", charClass.getSkills());

    return abilityInfo;
  }

  /**
   * Generates, sets, and returns a new race for the player's character.
   * 
   * @return new Race
   */
  public void genNewClass()
  {
    charClass = Generator.genClass("", abilities.getAbilityMods(), 1);
  }

  /**
   * Returns the Class of the player's character.
   * 
   * @return classification
   */
  public Classification getClassification()
  {
    return charClass;
  }

  public ArrayList<String> getLanguages()
  {
    return charRace.getLanguages();
  }

  /**
   * Generates, sets, and returns a new race for the player's character.
   * 
   * @return new Race
   */
  public void genNewRace()
  {
    charRace = Generator.genRace("");
    size = charRace.getSize();
  }

  /**
   * Returns the Race of the player's character.
   * 
   * @return race
   */
  public Race getRace()
  {
    return charRace;
  }

  /**
   * Gets the size of the character's race.
   * 
   * @return size
   */
  public String getSize()
  {
    return charRace.getSize();
  }

  /**
   * Gets the speed of the character's race.
   * 
   * @return speed
   */
  public String getSpeed()
  {
    return charRace.getSpeed();
  }
  
  /**
   * Returns the height of the player's character.
   * 
   * @return
   */
  public String getHeight()
  {
    return charRace.getHeight();
  }
  
  public String getGender()
  {
    return gender;
  }

  /**
   * Gets the String representation of the character's weight.
   * 
   * @return weight
   */
  public String getWeight()
  {
    return charRace.getWeight();
  }
  
  public void setPlayerName(String pn)
  {
    player = pn;
  }
  
  public void setCharName(String cn)
  {
    charName = cn;
  }
  
  public void setGender(String g)
  {
    gender = g;
  }
  
  public void setAge(int i)
  {
    age = i;
  }
  
  public void setAlignment(String a)
  {
    alignment = a;
  }
  
  public void setDiety(String d)
  {
    diety = d;
  }
  
  public void setHomeland(String h)
  {
    homeland = h;
  }
  
  public void setHairColor(String h)
  {
    hairColor = h;
  }
  
  public void setEyeColor(String e)
  {
    eyeColor = e;
  }
  
  public void setSize(String s)
  {
    size = s;
  }
  
  public void setLevel(int l)
  {
    level = l;
  }
  
  public void setRace(String r)
  {
    charRace = Generator.genRace(r);
  }
  
  public void setClass(String c)
  {
    charClass = Generator.genClass(c, abilities.getAbilityMods(), level);
  }

  /********************************************************************************************************/
  /*
   * BELOW ARE THE GETTERS AND SETTERS FOR THE ABILITY SCORES AND MODIFIERS. MAY NOT EVER BE USED.
   */
  /********************************************************************************************************/

  /**
   * Returns the Ability Score for STRENGTH.
   * 
   * @return strength score
   */
  public int getStr()
  {
    return abilityScores.get(STR);
  }

  /**
   * Returns the Ability Modifier for STRENGTH.
   * 
   * @return strength mod
   */
  public int getStrMod()
  {
    return abilityMods.get(STR);
  }

  /**
   * Returns the Ability Score for DEXTERITY.
   * 
   * @return dexterity score
   */
  public int getDex()
  {
    return abilityScores.get(DEX);
  }

  /**
   * Returns the Ability Modifier for DEXTERITY.
   * 
   * @return dexterity mod
   */
  public int getDexMod()
  {
    return abilityMods.get(DEX);
  }

  /**
   * Returns the Ability Score for CONSTITUTION.
   * 
   * @return constitution score
   */
  public int getCon()
  {
    return abilityScores.get(CON);
  }

  /**
   * Returns the Ability Modifier for CONSTITUTION.
   * 
   * @return constitution mod
   */
  public int getConMod()
  {
    return abilityMods.get(CON);
  }

  /**
   * Returns the Ability Score for INTELLIGENCE.
   * 
   * @return intelligence score
   */
  public int getInt()
  {
    return abilityScores.get(INT);
  }

  /**
   * Returns the Ability Mod for INTELLIGENCE.
   * 
   * @return intelligence mod
   */
  public int getIntMod()
  {
    return abilityMods.get(INT);
  }

  /**
   * Returns the Ability Score for WISDOM.
   * 
   * @return wisdom score
   */
  public int getWis()
  {
    return abilityScores.get(WIS);
  }

  /**
   * Returns the Ability Modifier for WISDOM.
   * 
   * @return wisdom mod
   */
  public int getWisMod()
  {
    return abilityMods.get(WIS);
  }

  /**
   * Returns the Ability Score for CHARISMA.
   * 
   * @return charisma score
   */
  public int getCha()
  {
    return abilityScores.get(CHA);
  }

  /**
   * Returns the Ability Modifier for CHARISMA.
   * 
   * @return charisma mod
   */
  public int getChaMod()
  {
    return abilityMods.get(CHA);
  }
}
