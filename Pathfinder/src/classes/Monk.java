package classes;

import java.util.Arrays;
import java.util.HashMap;

import base.Classification;

public class Monk extends Classification
{

  public Monk(HashMap<String, Integer> abilityMods, int level)
  {
    super(abilityMods, level);

    proficientSkills.addAll(Arrays.asList(ACRO, CLIMB, CRAFT1, CRAFT2, CRAFT3, ESCAPE, INTIMIDATE,
        KNOWHIS, KNOWREL, PERCEP, PERFORM1, PERFORM2, PROF1, PROF2, RIDE, SENSE, STEALTH, SWIM));

    skillRanksPerLevel = (4 + abilityMods.get(INT)) * level;
    hitPoints = 8 + abilityMods.get(CON) + getAdditionalHP();
    baseWealth = D6.roll(1) * 10;

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
  public void setBaseAttack()
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
  public void setSpecials()
  {
    // TODO Auto-generated method stub

  }

  @Override
  public String getClassification()
  {
    return MONK;
  }

}
