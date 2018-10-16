package application;

import java.util.*;
import classes.*;

public class Character
{
  private static final int NUM_CLASSES = 11;
  private static final int NUM_ABILITY_SCORES = 6;
  private static final int MAX_6D = 6;
  private static final int MIN_6D = 1;
  private static final String STR = "Str";
  private static final String DEX = "Dex";
  private static final String CON = "Con";
  private static final String INT = "Int";
  private static final String WIS = "Wis";
  private static final String CHA = "Cha";
  
  private String player;
  private String charName;
  
  private HashMap<String, Integer> abilityScores;
  private HashMap<String, Integer> abilityMods;
  
  public Character(String player, String charName)
  {
    this.player = player;
    this.charName = charName;
  }
  
  public void genClass()
  {
    int classIdentifier = new Random().nextInt(NUM_CLASSES);
    
    switch(classIdentifier)
    {
      case 0:
        
    }
  }
  
  /**
   * Generate random scores for the six abilities: Strength, Dexterity, Constitution, Intelligence,
   * Wisdom, and Charisma.
   */
  protected void genAbilityScores()
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
        randNum[j] = new Random().nextInt(MAX_6D) + MIN_6D;

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
  protected void genAbilityMods()
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

      abilityMods.put(key, mod);
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
