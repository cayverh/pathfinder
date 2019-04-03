package classes;

import java.util.Arrays;
import java.util.HashMap;

import base.Classification;

public class Ranger extends Classification
{

  public Ranger(HashMap<String, Integer> abilityMods, int level)
  {
    super(abilityMods, level);
    proficientSkills
        .addAll(Arrays.asList(CLIMB, CRAFT1, CRAFT2, CRAFT3, HANDLE, HEAL, INTIMIDATE, KNOWDUNG,
            KNOWGEO, KNOWNAT, PERCEP, PROF1, PROF2, RIDE, SPELLCRAFT, STEALTH, SURVIVAL, SWIM));

    skillRanksPerLevel = (6 + abilityMods.get(INT)) * level;
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
    return RANGER;
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
