package base;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

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
  public static void genAbilityMods(HashMap<String, Integer> abilityScores, HashMap<String, Integer> abilityMods, Race charRace)
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
  
  public static Classification genClass()
  {
    Classification charClass;
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
       * Rogue(); break; case 9: charClass = new Sorcerer(); break;
       */
      default:
        charClass = new Wizard();
        break;
    }
    
    return charClass;
  }
  
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
  
  public static Race genRace(String gender)
  {
    Race charRace;
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
      default:
        charRace = new Human(gender);
        break;
    }
    
    return charRace;
  }
}
