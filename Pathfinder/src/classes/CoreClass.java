package classes;

import java.util.HashMap;
import java.util.Random;

public abstract class CoreClass implements Class
{
  private int skillRanksPerLevel;

  private int baseAttackBonus;
  private int fortSave;
  private int refSave;
  private int willSave;

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

  public abstract void setForSave();
  
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
