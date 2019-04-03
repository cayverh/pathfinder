package classes;

import java.util.Arrays;
import java.util.HashMap;

import base.Classification;

public class Sorcerer extends Classification
{

  public Sorcerer(HashMap<String, Integer> abilityMods, int level)
  {
    super(abilityMods, level);

    proficientSkills.addAll(Arrays.asList(APPRAISE, BLUFF, CRAFT1, CRAFT2, CRAFT3, FLY, INTIMIDATE,
        KNOWARC, PROF1, PROF2, SPELLCRAFT, USEMAGDEV));

    skillRanksPerLevel = (2 + abilityMods.get(INT)) * level;
    hitPoints = 6 + abilityMods.get(CON) + getAdditionalHP();
    baseWealth = D6.roll(2) * 10;

    setBaseAttack();
    setFortSave();
    setRefSave();
    setWillSave();
  }

  @Override
  public int getAdditionalHP()
  {
    if (level > 1)
    {
      return D6.roll(level) + abilityMods.get(CON);
    }
    else
      return 0;
  }

  @Override
  public void setSkillRanksPerLevel(int base, int intMod)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void setFortSave()
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void setRefSave()
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void setWillSave()
  {
    // TODO Auto-generated method stub

  }

  @Override
  public String toString()
  {
    return SORCERER;
  }

  @Override
  public void setBaseAttack()
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void setSpecials()
  {
    // TODO Auto-generated method stub

  }

}
