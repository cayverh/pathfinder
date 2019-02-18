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
  public static final int MAX = 6;
  public static final int MIN = 1;
  
  private String charName;
  private String alignment;
  private String player;
  private int charLevel;
  private String diety;
  private String homeland;
  private String gender;
  private String hairColor;
  private String eyeColor;

  private String race;
  private Race charRace; // Size, gender, age, height, weight, and speed are all determined by
                         // race

  private String classification;
  private Classification charClass; // HP, starting wealth, skills, and skill ranks, base attack
                                    // bonus, fort
  // save, ref save, and will save are determined by class

  public Character(String player, String charName, String gen, String align,
      String race, String cclass)
  {
    this.player = player;
    this.charName = charName;
    alignment = align;
    this.race = race;
    this.classification = cclass;
    
    gender = Generator.genGender(gen);

    if (race.equals(Race.DWARF))
      charRace = new Dwarf(gender);
    else if (race.equals(Race.ELF))
      charRace = new Elf(gender);
    else if (race.equals(Race.GNOME))
      charRace = new Gnome(gender);
    else if (race.equals(Race.HALFELF))
      charRace = new HalfElf(gender);
    else if (race.equals(Race.HALFLING))
      charRace = new Halfling(gender);
    else if (race.equals(Race.HALFORC))
      charRace = new HalfOrc(gender);
    else if (race.equals(Race.HUMAN))
      charRace = new Human(gender);
    else
    {
      charRace = Generator.genRace(gender);
    }

    setAppearance(hairColor, eyeColor);
  }

  public void applyAbilityScoreMod(String ability)
  {
    int toSpend = charRace.getAbilityScoreBonusToSpend();

    abilityScores.put(ability, abilityScores.get(ability) + toSpend);

    if (toSpend != 0)
      genAbilityMods();
  }

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

  public String getGeneralCharInfo()
  {
    String charInfo = "";

    charInfo +=
        String.format("   Player Name: %-20.20s\tCharacter: %s\n",
            player, charName, charRace.getAge());
    charInfo += String.format("\tGender: %-20.20s\t      Age: %d\n", gender, getAge());
    charInfo += String.format("\tHeight: %-20.20s\t   Weight: %-20.10s\tSize: %s\n",
        charRace.getHeight(), charRace.getWeight(), charRace.getSize());
    charInfo += String.format("    Hair Color: %-20.20s\tEye Color: %s\n",
        hairColor, eyeColor);

    charInfo += "\n";
    
    charInfo += String.format("\t  Race: %-20.20s\t    Class: %s\n", getRace(), "");
    charInfo +=
        String.format("     Alignment: %-20.20s\t    Diety: %s\n", alignment, diety);
    charInfo += String.format("      Homeland: %-20.20s\n", homeland);

    return charInfo;
  }

  /**
   * Generate random scores for the six abilities: Strength, Dexterity, Constitution, Intelligence,
   * Wisdom, and Charisma.
   */
  public void genAbilityScores()
  {
    Generator.genAbilityScores(abilityScores);
  }

  /**
   * Generate the ability modifiers of the six abilities: Strength, Dexterity, Constitution,
   * Intelligence, Wisdom, and Charisma.
   */
  public void genAbilityMods()
  {
    Generator.genAbilityMods(abilityScores, abilityMods, charRace);
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
  
  public int getAge()
  {
    return charRace.getAge();
  }
  
  public String getClassification()
  {
    return "";
  }

  public String getRace()
  {
    return charRace.getRace();
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
