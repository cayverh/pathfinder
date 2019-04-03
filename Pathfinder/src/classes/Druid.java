package classes;

import java.util.Arrays;
import java.util.HashMap;

import base.Classification;

public class Druid extends Classification
{

  public Druid(HashMap<String, Integer> abilityMods, int level)
  {
    super(abilityMods, level);

    proficientSkills.addAll(Arrays.asList(CLIMB, CRAFT1, CRAFT2, CRAFT3, FLY, HANDLE, HEAL, KNOWGEO,
        KNOWNAT, PERCEP, PROF1, PROF2, RIDE, SPELLCRAFT, SURVIVAL, SWIM));

    skillRanksPerLevel = (4 + abilityMods.get(INT)) * level;
    hitPoints = 8 + abilityMods.get(CON) + getAdditionalHP();
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
      return D8.roll(level) + abilityMods.get(CON);
    }
    else
      return 0;
  }

  @Override
  public String toString()
  {
    return DRUID;
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
