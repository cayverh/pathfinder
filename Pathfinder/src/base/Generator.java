package base;

import java.util.HashMap;
import java.util.Random;

import abilities.Abilities;
import classes.*;
import races.*;

public final class Generator implements Abilities
{
  public static final int NUM_CLASSES = 11;
  public static final int NUM_RACES = 7;
  public static final int NUM_ABILITY_SCORES = 6;
  public static final int MAX = 6;
  public static final int MIN = 1;

  /**
   * Generate random scores for the six abilities: Strength, Dexterity, Constitution, Intelligence,
   * Wisdom, and Charisma.
   */
  public static void genAbilityScores(HashMap<String, Integer> abilityScores)
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
  public static void genAbilityMods(HashMap<String, Integer> abilityScores,
      HashMap<String, Integer> abilityMods, Race charRace)
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

  /**
   * Generates the Class of the player's character based on user input. If the user input is invalid
   * or missing, the Class is randomly chosen.
   * 
   * @param cclass
   *          The desired Class of the player's character
   * @return Class
   */
  public static Classification genClass(String cclass, HashMap<String, Integer> mods, int level)
  {
    Classification charClass;

    if (cclass.equals(Classification.BARBARIAN))
      charClass = new Barbarian(mods, level);
    else if (cclass.equals(Classification.BARD))
      charClass = new Bard(mods, level);
    else if (cclass.equals(Classification.CLERIC))
      charClass = new Cleric(mods, level);
    else if (cclass.equals(Classification.DRUID))
      charClass = new Druid(mods, level);
    else if (cclass.equals(Classification.FIGHTER))
      charClass = new Fighter(mods, level);
    else if (cclass.equals(Classification.MONK))
      charClass = new Monk(mods, level);
    else if (cclass.equals(Classification.PALADIN))
      charClass = new Paladin(mods, level);
    else if (cclass.equals(Classification.RANGER))
      charClass = new Ranger(mods, level);
    else if (cclass.equals(Classification.ROGUE))
      charClass = new Rogue(mods, level);
    else if (cclass.equals(Classification.SORCERER))
      charClass = new Sorcerer(mods, level);
    else if (cclass.equals(Classification.WIZARD))
      charClass = new Wizard(mods, level);
    else
    {
      int classIdentifier = new Random().nextInt(NUM_CLASSES);

      switch (classIdentifier)
      {
        case 0:
          charClass = new Barbarian(mods, level);
          break;
        case 1:
          charClass = new Bard(mods, level);
          break;
        case 2:
          charClass = new Cleric(mods, level);
          break;
        case 3:
          charClass = new Druid(mods, level);
          break;
        case 4:
          charClass = new Fighter(mods, level);
          break;
        case 5:
          charClass = new Monk(mods, level);
          break;
        case 6:
          charClass = new Paladin(mods, level);
          break;
        case 7:
          charClass = new Ranger(mods, level);
          break;
        case 8:
          charClass = new Rogue(mods, level);
          break;
        case 9:
          charClass = new Sorcerer(mods, level);
          break;
        default:
          charClass = new Wizard(mods, level);
          break;
      }
    }

    return charClass;
  }

  /**
   * Generates the gender of the player's character based on user input. If the user input is
   * invalid or missing, the gender is randomly chosen.
   * 
   * @param gender
   *          The desired gender of the player's character
   * @return gender
   */
  public static String genGender(String gender)
  {
    String g = "";

    int genPer = new Random().nextInt(100);

    if (!gender.equals("Male") && !gender.equals("Female") && !gender.equals("Non-Binary"))
    {
      if (genPer < 35)
        g = "Male";
      else if (genPer < 65)
        g = "Non-Binary";
      else
        g = "Female";
    }
    else
      g = gender;

    return g;
  }

  /**
   * Generates the Race of the player's character based on user input. If the user input is invalid
   * or missing, the Race is randomly chosen.
   * 
   * @param gender
   *          The desired gender of the player's character
   * @param race
   *          The desired Race of the player's character
   * @return Race
   */
  public static Race genRace(String race)
  {
    Race charRace;

    if (race.equals(Race.DWARF))
      charRace = new Dwarf();
    else if (race.equals(Race.ELF))
      charRace = new Elf();
    else if (race.equals(Race.GNOME))
      charRace = new Gnome();
    else if (race.equals(Race.HALFELF))
      charRace = new HalfElf();
    else if (race.equals(Race.HALFLING))
      charRace = new Halfling();
    else if (race.equals(Race.HALFORC))
      charRace = new HalfOrc();
    else if (race.equals(Race.HUMAN))
      charRace = new Human();
    else
    {
      int raceIdentifier = new Random().nextInt(NUM_RACES);

      switch (raceIdentifier)
      {
        case 0:
          charRace = new Dwarf();
          break;
        case 1:
          charRace = new Elf();
          break;
        case 2:
          charRace = new Gnome();
          break;
        case 3:
          charRace = new HalfElf();
          break;
        case 4:
          charRace = new Halfling();
          break;
        case 5:
          charRace = new HalfOrc();
          break;
        default:
          charRace = new Human();
          break;
      }
    }

    return charRace;
  }
}
