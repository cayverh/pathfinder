package base;

import java.util.*;
import classes.*;
import classes.Class;
import classes.*;
import races.*;

public class Character implements Abilities
{
  public static final int NUM_CLASSES = 11;
  public static final int NUM_ABILITY_SCORES = 6;
  public static final int MAX = 6;
  public static final int MIN = 1;

  private String charName;
  private String alignment;
  private String player;
  private int charLevel;
  private String diety;
  private String homeland;
  private CoreRace charRace; // Size, gender, age, height, weight, and speed are all determined by
                             // race
  private String hairColor;
  private String eyeColor;

  private Class charClass; // HP is determined by class

  private HashMap<String, Integer> abilityScores;
  private HashMap<String, Integer> abilityMods;

  public Character(String player, String charName, String gender, String align, String race,
      String cclass)
  {
    this.player = player;
    this.charName = charName;
    alignment = align;

    abilityScores = new HashMap<String, Integer>();
    abilityMods = new HashMap<String, Integer>();

    if (race.equals("Dwarf"))
      charRace = new Dwarf(gender);
    else if (race.equals("Elf"))
      charRace = new Elf();
    else if (race.equals("Gnome"))
      charRace = new Gnome();
    else if (race.equals("Half-Elf"))
      charRace = new HalfElf();
    else if (race.equals("Halfling"))
      charRace = new Halfling();
    else if (race.equals("Half-Orc"))
      charRace = new HalfOrc();
    else if (race.equals("Human"))
      charRace = new Human();
    else
    {
      charRace = null;
      // Randomly choose a race.
    }
  }

  public void genCoreClass()
  {
    int classIdentifier = new Random().nextInt(NUM_CLASSES);

    switch (classIdentifier)
    {
      case 0:
        charClass = new Barbarian();
        break;
      case 1:
        charClass = new Bard();
        break;
      /*
       * case 2: charClass = new Cleric(); break; case 3: charClass = new Druid(); break; case 4:
       * charClass = new Fighter(); break; case 5: charClass = new Monk(); break; case 6: charClass
       * = new Paladin(); break; case 7: charClass = new Ranger(); break; case 8: charClass = new
       * Rogue(); break; case 9: charClass = new Sorcerer(); break; case 10: charClass = new
       * Wizard(); break;
       */
      default:
        break;
    }
  }

  /**
   * Generate random scores for the six abilities: Strength, Dexterity, Constitution, Intelligence,
   * Wisdom, and Charisma.
   */
  public void genAbilityScores()
  {
    int[] randNum = new int[4];
    int lowestScore;
    int totalScore;
    abilityScores = new HashMap<>();

    // Randomly generate an ability score for each ability.
    for (int i = 0; i < NUM_ABILITY_SCORES; i++)
    {
      // Set/reset
      lowestScore = 0;
      totalScore = 0;

      // Generate and store four random numbers between 1 and 6.
      // Also record the lowest number.
      for (int j = 0; j < 4; j++)
      {
        randNum[j] = new Random().nextInt(MAX) + MIN;

        if (j == 0)
        {
          lowestScore = randNum[j];
        }
        else if (randNum[j] <= lowestScore)
        {
          lowestScore = randNum[j];
        }
      }

      // Add the three highest "rolls" together.
      for (int k = 0; k < 4; k++)
      {
        totalScore += randNum[k];
      }

      // Subtract the lowest "roll" from the total score.
      totalScore -= lowestScore;

      // Associate the random generated score to an ability score on each iteration.
      switch (i)
      {
        case 0:
          abilityScores.put(STR, totalScore);
          break;

        case 1:
          abilityScores.put(DEX, totalScore);
          break;

        case 2:
          abilityScores.put(CON, totalScore);
          break;

        case 3:
          abilityScores.put(INT, totalScore);
          break;

        case 4:
          abilityScores.put(WIS, totalScore);
          break;

        case 5:
          abilityScores.put(CHA, totalScore);
          break;
      }
    }
  }

  /**
   * Generate the ability modifiers of the six abilities: Strength, Dexterity, Constitution,
   * Intelligence, Wisdom, and Charisma.
   */
  public void genAbilityMods()
  {
    abilityMods = new HashMap<>();

    int mod;

    for (String key : abilityScores.keySet())
    {
      int score = abilityScores.get(key);

      if (score <= 3)
        mod = -4;
      else if (score <= 5)
        mod = -3;
      else if (score <= 7)
        mod = -2;
      else if (score <= 9)
        mod = -1;
      else if (score <= 11)
        mod = 0;
      else if (score <= 13)
        mod = 1;
      else if (score <= 15)
        mod = 2;
      else if (score <= 17)
        mod = 3;
      else
        mod = 4;

      abilityMods.put(key, mod + charRace.getAbilityBonuses().get(key));
    }
  }

  /**
   * 
   * @return Strength
   */
  public int getStr()
  {
    return abilityScores.get(STR);
  }

  public int getStrMod()
  {
    return abilityMods.get(STR);
  }

  /**
   * 
   * @return Dexterity
   */
  public int getDex()
  {
    return abilityScores.get(DEX);
  }

  public int getDexMod()
  {
    return abilityMods.get(DEX);
  }

  /**
   * 
   * @return Constitution
   */
  public int getCon()
  {
    return abilityScores.get(CON);
  }

  public int getConMod()
  {
    return abilityMods.get(CON);
  }

  /**
   * 
   * @return Intelligence
   */
  public int getInt()
  {
    return abilityScores.get(INT);
  }

  public int getIntMod()
  {
    return abilityMods.get(INT);
  }

  /**
   * 
   * @return Wisdom
   */
  public int getWis()
  {
    return abilityScores.get(WIS);
  }

  public int getWisMod()
  {
    return abilityMods.get(WIS);
  }

  /**
   * 
   * @return Charisma
   */
  public int getCha()
  {
    return abilityScores.get(CHA);
  }

  public int getChaMod()
  {
    return abilityMods.get(CHA);
  }
}
