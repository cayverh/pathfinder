package classes;

import java.util.Arrays;
import java.util.HashMap;

import base.Classification;

public class Rogue extends Classification
{

  public Rogue(HashMap<String, Integer> abilityMods, int level)
  {
    super(abilityMods, level);

    proficientSkills.addAll(Arrays.asList(ACRO, APPRAISE, BLUFF, CLIMB, CRAFT1, CRAFT2, CRAFT3,
        DIPLOM, DISABLE, DISGUISE, ESCAPE, INTIMIDATE, KNOWDUNG, KNOWLOC, LING, PERCEP, PERFORM1,
        PERFORM2, PROF1, PROF2, SENSE, SLEIGHT, STEALTH, SWIM, USEMAGDEV));

    skillRanksPerLevel = (8 + abilityMods.get(INT)) * level;
    hitPoints = 8 + abilityMods.get(CON) + getAdditionalHP();
    baseWealth = D6.roll(4) * 10;

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
      return D8.roll(level) + abilityMods.get(CON);
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
    return ROGUE;
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
