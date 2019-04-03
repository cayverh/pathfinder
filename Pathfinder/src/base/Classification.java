package base;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Classification implements Skills, Dice
{
  public static final String BARBARIAN = "Barbarian";
  public static final String BARD = "Bard";
  public static final String CLERIC = "Cleric";
  public static final String DRUID = "Druid";
  public static final String FIGHTER = "Fighter";
  public static final String MONK = "Monk";
  public static final String PALADIN = "Paladin";
  public static final String RANGER = "Ranger";
  public static final String ROGUE = "Rogue";
  public static final String SORCERER = "Sorcerer";
  public static final String WIZARD = "Wizard";

  // Has default class skills

  protected ArrayList<String> classSkills;
  protected int skillRanksPerLevel;
  protected int hitPoints;
  protected int baseWealth;
  protected int level;

  protected int baseAttackBonus;
  protected int fortSave;
  protected int refSave;
  protected int willSave;

  protected HashMap<String, Integer> abilityMods;
  protected ArrayList<String> proficientSkills = new ArrayList<String>();
  protected ArrayList<String> specials = new ArrayList<String>();

  public Classification(HashMap<String, Integer> abilityMods, int level)
  {
    this.abilityMods = abilityMods;
    this.level = level;

    baseAttackBonus = 0;
    fortSave = 0;
    refSave = 0;
    willSave = 0;

    // Loop through each of the skills and the abilities associated with them
    for (String skill : skillAbilities.keySet())
    {

      // Loop through each of the abilities and their modifiers.
      for (String ability : abilityMods.keySet())
      {

        // When the ability associated with the skill if found, set the ability modifier for the
        // skill
        if (skillAbilities.get(skill).equals(ability))
        {
          skillMods.put(skill, abilityMods.get(ability));
        }
      }
    }
  }

  public static String getAllClasses()
  {
    return String.format("\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n", BARBARIAN,
        BARD, CLERIC, DRUID, FIGHTER, MONK, PALADIN, RANGER, ROGUE, SORCERER, WIZARD);
  }

  /**
   * Sets the skill ranks earned per level, depending on the character's class and Intelligence
   * modifier.
   * 
   * @param base
   *          Base value based on class
   * @param intMod
   *          Intelligence modifier
   */
  public void setSkillRanksPerLevel(int base, int intMod)
  {
    skillRanksPerLevel = base + intMod;
  }

  /**
   * 
   * @return BaseAttackBonus
   */
  public int getBaseAttackBonus()
  {
    return baseAttackBonus;
  }

  /**
   * 
   * @return Fortitude Save
   */
  public int getFortSave()
  {
    return fortSave;
  }

  /**
   * 
   * @return Reflex Save
   */
  public int getRefSave()
  {
    return refSave;
  }

  /**
   * 
   * @return Will Save
   */
  public int getWillSave()
  {
    return willSave;
  }

  public int getSkillRanksPerLevel()
  {
    return skillRanksPerLevel;
  }

  /**
   * Returns a formatted String representation of the player's character's skills.
   * 
   * @return skills
   */
  public String getSkills()
  {
    String skills = "";

    for (String skill : skillMods.keySet())
    {
      skills += String.format("%25s %2s  =  %s %2d  +  %d\n", skill, skillTotals.get(skill),
          skillAbilities.get(skill).toUpperCase(), skillMods.get(skill), skillRanks.get(skill));
    }

    return skills;
  }

  /**
   * Sets the total for each skill. Determined by skill modifier and ranks put into the skill.
   */
  public void setSkillTotals()
  {
    for (String skill : skillAbilities.keySet())
    {
      skillTotals.put(skill, skillMods.get(skill) + skillRanks.get(skill));
    }
  }

  public ArrayList<String> getSpecials()
  {
    return specials;
  }
  
  public static String[] getClasses()
  {
	  return new String[] {BARBARIAN, BARD, CLERIC, DRUID, FIGHTER, MONK, PALADIN, RANGER, ROGUE, SORCERER, WIZARD};
  }

  public abstract int getAdditionalHP();

  public abstract void setBaseAttack();

  public abstract void setFortSave();

  public abstract void setRefSave();

  public abstract void setWillSave();

  public abstract void setSpecials();
}
