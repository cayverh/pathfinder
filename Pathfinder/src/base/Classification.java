package base;

public abstract class Classification
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
  
  // Has an HP
  // Has a base wealth
  // Has default class skills
  // Has a skill ranks per level
  
  private int skillRanksPerLevel;

  private int baseAttackBonus;
  private int fortSave;
  private int refSave;
  private int willSave;

  public abstract String getClassification();
  
  /**
   * Sets the skill ranks earned per level, depending on the character's class and Intelligence
   * modifier.
   * 
   * @param base
   *                 Base value based on class
   * @param intMod
   *                 Intelligence modifier
   */
  public abstract void setSkillRanksPerLevel(int base, int intMod);

  public abstract void setFortSave();
  
  public abstract void setRefSave();
  
  public abstract void setWillSave();
  
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
}
