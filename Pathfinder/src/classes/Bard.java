package classes;

import java.util.Arrays;
import java.util.HashMap;

import base.Classification;

public class Bard extends Classification
{
  public Bard(HashMap<String, Integer> abilityMods, int level)
  {
    super(abilityMods, level);

    proficientSkills.addAll(Arrays.asList(ACRO, APPRAISE, BLUFF, CLIMB, CRAFT1, CRAFT2, CRAFT3,
        DIPLOM, DISGUISE, ESCAPE, INTIMIDATE, KNOWARC, KNOWDUNG, KNOWENG, KNOWGEO, KNOWHIS, KNOWLOC,
        KNOWNAT, KNOWNOB, KNOWPLANES, KNOWREL, LING, PERCEP, PERFORM1, PERFORM2, PROF1, PROF2,
        SENSE, SLEIGHT, SPELLCRAFT, STEALTH, USEMAGDEV));

    skillRanksPerLevel = (6 + abilityMods.get(INT)) * level;
    hitPoints = 8 + abilityMods.get(CON) + getAdditionalHP();
    baseWealth = D6.roll(3) * 10;

    setBaseAttack();
    setFortSave();
    setRefSave();
    setWillSave();
  }

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
    return BARD;
  }

  @Override
  public void setBaseAttack()
  {
    switch (level)
    {
      case 1:
        baseAttackBonus = 0;
        break;
      case 2:
        baseAttackBonus = 1;
        break;
      case 3:
        baseAttackBonus = 3;
        break;
      case 4:
        baseAttackBonus = 6;
        break;
      case 5:
        baseAttackBonus = 9;
        break;
      case 6:
        baseAttackBonus = 13;
        break;
      case 7:
        baseAttackBonus = 18;
        break;
      case 8:
        baseAttackBonus = 24;
        break;
      case 9:
        baseAttackBonus = 30;
        break;
      case 10:
        baseAttackBonus = 37;
        break;
      case 11:
        baseAttackBonus = 45;
        break;
      case 12:
        baseAttackBonus = 54;
        break;
      case 13:
        baseAttackBonus = 63;
        break;
      case 14:
        baseAttackBonus = 73;
        break;
      case 15:
        baseAttackBonus = 84;
        break;
      case 16:
        baseAttackBonus = 96;
        break;
      case 17:
        baseAttackBonus = 108;
        break;
      case 18:
        baseAttackBonus = 121;
        break;
      case 19:
        baseAttackBonus = 135;
        break;
      default:
        baseAttackBonus = 150;
        break;
    }
  }

  @Override
  public void setFortSave()
  {
    switch (level)
    {
      case 1:
        fortSave = 0;
        break;
      case 2:
        fortSave = 0;
        break;
      case 3:
        fortSave = 1;
        break;
      case 4:
        fortSave = 2;
        break;
      case 5:
        fortSave = 3;
        break;
      case 6:
        fortSave = 5;
        break;
      case 7:
        fortSave = 7;
        break;
      case 8:
        fortSave = 9;
        break;
      case 9:
        fortSave = 12;
        break;
      case 10:
        fortSave = 15;
        break;
      case 11:
        fortSave = 18;
        break;
      case 12:
        fortSave = 22;
        break;
      case 13:
        fortSave = 26;
        break;
      case 14:
        fortSave = 30;
        break;
      case 15:
        fortSave = 35;
        break;
      case 16:
        fortSave = 40;
        break;
      case 17:
        fortSave = 45;
        break;
      case 18:
        fortSave = 51;
        break;
      case 19:
        fortSave = 57;
        break;
      default:
        fortSave = 63;
        break;
    }
  }

  @Override
  public void setRefSave()
  {
    switch (level)
    {
      case 1:
        refSave = 2;
        break;
      case 2:
        refSave = 5;
        break;
      case 3:
        refSave = 8;
        break;
      case 4:
        refSave = 12;
        break;
      case 5:
        refSave = 16;
        break;
      case 6:
        refSave = 51;
        break;
      case 7:
        refSave = 56;
        break;
      case 8:
        refSave = 62;
        break;
      case 9:
        refSave = 68;
        break;
      case 10:
        refSave = 75;
        break;
      case 11:
        refSave = 82;
        break;
      case 12:
        refSave = 90;
        break;
      case 13:
        refSave = 98;
        break;
      case 14:
        refSave = 107;
        break;
      case 15:
        refSave = 116;
        break;
      case 16:
        refSave = 126;
        break;
      case 17:
        refSave = 136;
        break;
      case 18:
        refSave = 147;
        break;
      case 19:
        refSave = 158;
        break;
      default:
        refSave = 170;
        break;
    }
  }

  @Override
  public void setWillSave()
  {
    switch (level)
    {
      case 1:
        willSave = 2;
        break;
      case 2:
        willSave = 5;
        break;
      case 3:
        willSave = 8;
        break;
      case 4:
        willSave = 12;
        break;
      case 5:
        willSave = 16;
        break;
      case 6:
        willSave = 51;
        break;
      case 7:
        willSave = 56;
        break;
      case 8:
        willSave = 62;
        break;
      case 9:
        willSave = 68;
        break;
      case 10:
        willSave = 75;
        break;
      case 11:
        willSave = 82;
        break;
      case 12:
        willSave = 90;
        break;
      case 13:
        willSave = 98;
        break;
      case 14:
        willSave = 107;
        break;
      case 15:
        willSave = 116;
        break;
      case 16:
        willSave = 126;
        break;
      case 17:
        willSave = 136;
        break;
      case 18:
        willSave = 147;
        break;
      case 19:
        willSave = 158;
        break;
      default:
        willSave = 170;
        break;
    }
  }

  public void setSpecials()
  {
    for (int i = 1; i <= 20; i ++)
    {
      specials.addAll(Arrays.asList("Bardic Knowledge", "Bardic Performance", "Cantrips",
          "Countersong", "Distraction", "Fascinate", "Inspire Courage +1"));
      
      if (i == 2)
        specials.addAll(Arrays.asList("Versatile Performance", "Well-Versed"));
      if (i == 3)
        specials.addAll(Arrays.asList("Inspire Competence +2"));
      if (i == 5)
        specials.addAll(Arrays.asList("Inspire Courage +2", "Lord Master 1/Day"));
      if (i == 6)
        specials.addAll(Arrays.asList("Suggestion", "Versatile Performace 1"));
      if (i == 7)
        specials.addAll(Arrays.asList("Inspire Competence +3"));
      if (i == 8)
        specials.addAll(Arrays.asList("Dirge of Doom"));
      if (i == 9)
        specials.addAll(Arrays.asList("Inspire Greatness"));
      if (i == 10)
        specials.addAll(Arrays.asList("Jack-of-all-Trades", "Versatile Performance 2"));
      if (i == 11)
        specials.addAll(Arrays.asList("Inspire Competence +4", "Inspire Courage +3", "Lore Master 2/Day"));
      if (i == 12)
        specials.addAll(Arrays.asList("Soothing Performance"));
      if (i == 14)
        specials.addAll(Arrays.asList("Frightening Tune", "Versatile Performance 3"));
      if (i == 15)
        specials.addAll(Arrays.asList("Inspire Competence +5", "Inspire Heroics"));
      if (i == 17)
        specials.addAll(Arrays.asList("Inspire Courage +4", "Lore Master 3/Day"));
      if (i == 18)
        specials.addAll(Arrays.asList("Mass Suggestion", "Versatile Performance 4"));
      if (i == 19)
        specials.addAll(Arrays.asList("Inspire Competence +6"));
      if (i == 20)
        specials.addAll(Arrays.asList("Deadly Performance"));
    }
  }
}
