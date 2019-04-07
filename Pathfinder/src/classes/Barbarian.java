package classes;

import java.util.Arrays;
import java.util.HashMap;

import base.Classification;

public class Barbarian extends Classification
{
  public Barbarian(HashMap<String, Integer> abilityMods, int level)
  {
    super(abilityMods, level);

    proficientSkills.addAll(Arrays.asList(ACRO, CLIMB, CRAFT1, CRAFT2, CRAFT3, HANDLE, INTIMIDATE,
        KNOWNAT, PERCEP, RIDE, SURVIVAL, SWIM));

    skillRanksPerLevel = (4 + abilityMods.get(INT)) * level;
    hitPoints = 12 + abilityMods.get(CON) + getAdditionalHP();
    baseWealth = D6.roll(3) * 10;

    setBaseAttack();
    setFortSave();
    setRefSave();
    setWillSave();
  }

  @Override
  public String toString()
  {
    return BARBARIAN;
  }

  public int getAdditionalHP()
  {
    if (level > 1)
    {
      return D12.roll(level) + abilityMods.get(CON);
    }
    else
      return 0;
  }

  public void setBaseAttack()
  {
    switch (level)
    {
      case 1:
        baseAttackBonus = 1;
        break;
      case 2:
        baseAttackBonus = 3;
        break;
      case 3:
        baseAttackBonus = 6;
        break;
      case 4:
        baseAttackBonus = 10;
        break;
      case 5:
        baseAttackBonus = 15;
        break;
      case 6:
        baseAttackBonus = 21;
        break;
      case 7:
        baseAttackBonus = 28;
        break;
      case 8:
        baseAttackBonus = 36;
        break;
      case 9:
        baseAttackBonus = 45;
        break;
      case 10:
        baseAttackBonus = 55;
        break;
      case 11:
        baseAttackBonus = 66;
        break;
      case 12:
        baseAttackBonus = 78;
        break;
      case 13:
        baseAttackBonus = 91;
        break;
      case 14:
        baseAttackBonus = 105;
        break;
      case 15:
        baseAttackBonus = 120;
        break;
      case 16:
        baseAttackBonus = 136;
        break;
      case 17:
        baseAttackBonus = 153;
        break;
      case 18:
        baseAttackBonus = 171;
        break;
      case 19:
        baseAttackBonus = 190;
        break;
      default:
        baseAttackBonus = 210;
        break;
    }
  }

  @Override
  public void setFortSave()
  {
    switch (level)
    {
      case 1:
        fortSave = 2;
        break;
      case 2:
        fortSave = 5;
        break;
      case 3:
        fortSave = 8;
        break;
      case 4:
        fortSave = 12;
        break;
      case 5:
        fortSave = 16;
        break;
      case 6:
        fortSave = 21;
        break;
      case 7:
        fortSave = 26;
        break;
      case 8:
        fortSave = 32;
        break;
      case 9:
        fortSave = 38;
        break;
      case 10:
        fortSave = 45;
        break;
      case 11:
        fortSave = 52;
        break;
      case 12:
        fortSave = 60;
        break;
      case 13:
        fortSave = 68;
        break;
      case 14:
        fortSave = 77;
        break;
      case 15:
        fortSave = 86;
        break;
      case 16:
        fortSave = 96;
        break;
      case 17:
        fortSave = 106;
        break;
      case 18:
        fortSave = 117;
        break;
      case 19:
        fortSave = 128;
        break;
      default:
        fortSave = 140;
        break;
    }
  }

  @Override
  public void setRefSave()
  {
    switch (level)
    {
      case 1:
        refSave = 0;
        break;
      case 2:
        refSave = 0;
        break;
      case 3:
        refSave = 1;
        break;
      case 4:
        refSave = 2;
        break;
      case 5:
        refSave = 3;
        break;
      case 6:
        refSave = 5;
        break;
      case 7:
        refSave = 7;
        break;
      case 8:
        refSave = 9;
        break;
      case 9:
        refSave = 12;
        break;
      case 10:
        refSave = 15;
        break;
      case 11:
        refSave = 18;
        break;
      case 12:
        refSave = 22;
        break;
      case 13:
        refSave = 26;
        break;
      case 14:
        refSave = 30;
        break;
      case 15:
        refSave = 35;
        break;
      case 16:
        refSave = 40;
        break;
      case 17:
        refSave = 45;
        break;
      case 18:
        refSave = 51;
        break;
      case 19:
        refSave = 57;
        break;
      default:
        refSave = 63;
        break;
    }
  }

  @Override
  public void setWillSave()
  {
    switch (level)
    {
      case 1:
        willSave = 0;
        break;
      case 2:
        willSave = 0;
        break;
      case 3:
        willSave = 1;
        break;
      case 4:
        willSave = 2;
        break;
      case 5:
        willSave = 3;
        break;
      case 6:
        willSave = 5;
        break;
      case 7:
        willSave = 7;
        break;
      case 8:
        willSave = 9;
        break;
      case 9:
        willSave = 12;
        break;
      case 10:
        willSave = 15;
        break;
      case 11:
        willSave = 18;
        break;
      case 12:
        willSave = 22;
        break;
      case 13:
        willSave = 26;
        break;
      case 14:
        willSave = 30;
        break;
      case 15:
        willSave = 35;
        break;
      case 16:
        willSave = 40;
        break;
      case 17:
        willSave = 45;
        break;
      case 18:
        willSave = 51;
        break;
      case 19:
        willSave = 57;
        break;
      default:
        willSave = 63;
        break;
    }
  }

  public void setSpecials()
  {
    for (int i = 1; i <= 20; i++)
    {
      specials.addAll(Arrays.asList("Fast Movement", "Rage"));
      
      if (i == 2)
        specials.addAll(Arrays.asList("Rage Power 1", "Uncanny Dodge"));
      if (i == 3)
        specials.addAll(Arrays.asList("Trap Sense +1"));
      if (i == 4)
        specials.addAll(Arrays.asList("Rage Power 2"));
      if (i == 5)
        specials.addAll(Arrays.asList("Improved Uncanny Dodge"));
      if (i == 6)
        specials.addAll(Arrays.asList("Rage Power 3", "Trap Sense +2"));
      if (i == 7)
        specials.addAll(Arrays.asList("Damage Reduction 1"));
      if (i == 8)
        specials.addAll(Arrays.asList("Rage Power 4"));
      if (i == 9)
        specials.addAll(Arrays.asList("Trap Sense +3"));
      if (i == 10)
        specials.addAll(Arrays.asList("Damage Reductions 2", "Rage Power 4"));
      if (i == 11)
        specials.addAll(Arrays.asList("Greater Rage"));
      if (i == 12)
        specials.addAll(Arrays.asList("Rage Power 5", "Trap Sense +4"));
      if (i == 13)
        specials.addAll(Arrays.asList("Damage Reduction 3"));
      if (i == 14)
        specials.addAll(Arrays.asList("Indomitable Will", "Rage Power 6"));
      if (i == 15)
        specials.addAll(Arrays.asList("Trap Sense +5"));
      if (i == 16)
        specials.addAll(Arrays.asList("Damage Reduction 4", "Rage Power 7"));
      if (i == 17)
        specials.addAll(Arrays.asList("Tireless Rage"));
      if (i == 18)
        specials.addAll(Arrays.asList("Rage Power 8", "Trap Sense +6"));
      if (i == 19)
        specials.addAll(Arrays.asList("Damage Reduction 5"));
      if (i == 20)
        specials.addAll(Arrays.asList("Mighty Rage", "Rage Power"));
    }
  }
}
