package classes;

import java.util.Arrays;
import java.util.HashMap;

import base.Classification;

public class Fighter extends Classification
{

  public Fighter(HashMap<String, Integer> abilityMods, int level)
  {
    super(abilityMods, level);

    proficientSkills.addAll(Arrays.asList(CLIMB, CRAFT1, CRAFT2, CRAFT3, HANDLE, INTIMIDATE,
        KNOWDUNG, KNOWENG, PROF1, PROF2, RIDE, SURVIVAL, SWIM));

    skillRanksPerLevel = (2 + abilityMods.get(INT)) * level;
    hitPoints = 10 + abilityMods.get(CON) + getAdditionalHP();
    baseWealth = D6.roll(5) * 10;

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
      return D10.roll(level) + abilityMods.get(CON);
    }
    else
      return 0;
  }

  @Override
  public String getClassification()
  {
    return FIGHTER;
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

}
