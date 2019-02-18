package base;

import java.util.*;

import base.*;
import classes.*;
import races.*;

/**
 * The creation of a Pathfinder character.
 * 
 * The user enters information into a GUI, which is passed to this class.
 * 
 * @author Cayleigh
 *
 */
public class Character implements Dice, Abilities
{
  public static final int NUM_CLASSES = 11;
  public static final int NUM_RACES = 7;
  public static final int NUM_ABILITY_SCORES = 6;
  public static final int MAX = 6;
  public static final int MIN = 1;

  private String charName;
  private String alignment;
  private String player;
  private int charLevel;
  private String diety;
  private String homeland;

  private String hairColor;
  private String eyeColor;

  private Race charRace; // Size, gender, age, height, weight, and speed are all determined by
                         // race

  private Classification charClass; // HP, starting wealth, skills, and skill ranks, base attack
                                    // bonus, fort
  // save, ref save, and will save are determined by class

  public Character(String player, String charName, String gender, String align,
      String race, String cclass)
  {
    this.player = player;
    this.charName = charName;
    alignment = align;

    if (race.equals("Dwarf"))
      charRace = new Dwarf(gender);
    else if (race.equals("Elf"))
      charRace = new Elf(gender);
    else if (race.equals("Gnome"))
      charRace = new Gnome(gender);
    else if (race.equals("Half-Elf"))
      charRace = new HalfElf(gender);
    else if (race.equals("Halfling"))
      charRace = new Halfling(gender);
    else if (race.equals("Half-Orc"))
      charRace = new HalfOrc(gender);
    else if (race.equals("Human"))
      charRace = new Human(gender);
    else
    {
      genRace(gender);
    }
  }

  public void applyAbilityScoreMod(String ability)
  {
    int toSpend = charRace.getAbilityScoreBonusToSpend();

    abilityScores.put(ability, abilityScores.get(ability) + toSpend);

    if (toSpend != 0)
      genAbilityMods();
  }

  public void genClass()
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

  public String getGeneralCharInfo()
  {
    String charInfo = "";

    charInfo += "   Player Name: " + player + "\tCharacter: " + charName + "\n";

    charInfo +=
        "\t  Race: " + charRace.getRace() + "\t      Age: " + charRace.getAge() + "\n";

    charInfo += "\tHeight: " + charRace.getHeight() + "\t   Weight: "
        + charRace.getWeight() + "\n";

    charInfo += "     Alignment: " + alignment + "\t    Diety: " + diety + "\n";
    
    charInfo += "      Homeland: " + homeland + "\t\t     Size: " + charRace.getSize() + "\n";

    charInfo += "    Hair Color: " + hairColor + "\t\tEye Color: " + eyeColor + "\n";
    
    return charInfo;
  }

  public void genRace(String gender)
  {
    int raceIdentifier = new Random().nextInt(NUM_RACES);

    switch (raceIdentifier)
    {
      case 0:
        charRace = new Dwarf(gender);
        break;
      case 1:
        charRace = new Elf(gender);
        break;
      case 2:
        charRace = new Gnome(gender);
        break;
      case 3:
        charRace = new HalfElf(gender);
        break;
      case 4:
        charRace = new Halfling(gender);
        break;
      case 5:
        charRace = new HalfOrc(gender);
        break;
      case 6:
        charRace = new Human(gender);
        break;
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
    int lowestScore = 0;
    int totalScore = 0;

    // Randomly generate an ability score for each ability.
    for (int i = 0; i < NUM_ABILITY_SCORES; i++)
    {
      // Reset
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

  public String getAbilityInfo()
  {
    String abilityInfo = "";

    for (String ability : abilityScores.keySet())
    {
      abilityInfo += String.format("%s: %s, Mod: %s\n", ability,
          abilityScores.get(ability), abilityMods.get(ability));
    }

    return abilityInfo;
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
