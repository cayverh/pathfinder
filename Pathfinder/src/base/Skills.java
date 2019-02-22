package base;

import java.util.HashMap;
import java.util.LinkedHashMap;

public interface Skills extends Abilities
{
  public final int NUM_SKILLS = 39;
      
  public final String ACRO = "Acrobatics";
  public final String APPRAISE = "Appraise";
  public final String BLUFF = "Bluff";
  public final String CLIMB = "Climb";
  public final String CRAFT1 = "Craft";
  public final String CRAFT2 = "Craft";
  public final String CRAFT3 = "Craft";
  public final String DIPLOM = "Diplomacy";
  public final String DISABLE = "Disable Device";
  public final String DISGUISE = "Disguise";
  public final String ESCAPE = "Escape Artist";
  public final String FLY = "Fly";
  public final String HANDLE = "Handle Animal";
  public final String HEAL = "Heal";
  public final String INTIMIDATE = "Intimidate";
  public final String KNOWARC = "Knowledge (Arcana)";
  public final String KNOWDUNG = "Knowledge (Dungeoneering)";
  public final String KNOWENG = "Knowledge (Engineering)";
  public final String KNOWGEO = "Knowledge (Geography)";
  public final String KNOWHIS = "Knowledge (History)";
  public final String KNOWLOC = "Knowledge (Local)";
  public final String KNOWNAT = "Knowledge (Nature)";
  public final String KNOWNOB = "Knowledge (Nobility)";
  public final String KNOWPLANES = "Knowledge (Planes)";
  public final String KNOWREL = "Knowledge (Religion)";
  public final String LING = "Linguistics";
  public final String PERCEP = "Perception";
  public final String PERFORM1 = "Perform";
  public final String PERFORM2 = "Perform";
  public final String PROF1 = "Profession";
  public final String PROF2 = "Profession";
  public final String RIDE = "Ride";
  public final String SENSE = "Sense Motive";
  public final String SLEIGHT = "Sleight of Hand";
  public final String SPELLCRAFT = "Spellcraft";
  public final String STEALTH = "Stealth";
  public final String SURVIVAL = "Survival";
  public final String SWIM = "Swim";
  public final String USEMAGDEV = "Use Magic Device";

  public HashMap<String, Integer> skillMods = new LinkedHashMap<String, Integer>(NUM_SKILLS)
  {
    {
      put(ACRO, 0);
      put(APPRAISE, 0);
      put(BLUFF, 0);
      put(CLIMB, 0);
      put(CRAFT1, 0);
      put(CRAFT2, 0);
      put(CRAFT3, 0);
      put(DIPLOM, 0);
      put(DISABLE, 0);
      put(DISGUISE, 0);
      put(ESCAPE, 0);
      put(FLY, 0);
      put(HANDLE, 0);
      put(HEAL, 0);
      put(INTIMIDATE, 0);
      put(KNOWARC, 0);
      put(KNOWDUNG, 0);
      put(KNOWENG, 0);
      put(KNOWGEO, 0);
      put(KNOWHIS, 0);
      put(KNOWLOC, 0);
      put(KNOWNAT, 0);
      put(KNOWNOB, 0);
      put(KNOWPLANES, 0);
      put(KNOWREL, 0);
      put(LING, 0);
      put(PERCEP, 0);
      put(PERFORM1, 0);
      put(PERFORM2, 0);
      put(PROF1, 0);
      put(PROF2, 0);
      put(RIDE, 0);
      put(SENSE, 0);
      put(SLEIGHT, 0);
      put(SPELLCRAFT, 0);
      put(STEALTH, 0);
      put(SURVIVAL, 0);
      put(SWIM, 0);
      put(USEMAGDEV, 0);
    }
  };
  
  public HashMap<String, Integer> skillRanks = new LinkedHashMap<String, Integer>()
  {
    {
      put(ACRO, 0);
      put(APPRAISE, 0);
      put(BLUFF, 0);
      put(CLIMB, 0);
      put(CRAFT1, 0);
      put(CRAFT2, 0);
      put(CRAFT3, 0);
      put(DIPLOM, 0);
      put(DISABLE, 0);
      put(DISGUISE, 0);
      put(ESCAPE, 0);
      put(FLY, 0);
      put(HANDLE, 0);
      put(HEAL, 0);
      put(INTIMIDATE, 0);
      put(KNOWARC, 0);
      put(KNOWDUNG, 0);
      put(KNOWENG, 0);
      put(KNOWGEO, 0);
      put(KNOWHIS, 0);
      put(KNOWLOC, 0);
      put(KNOWNAT, 0);
      put(KNOWNOB, 0);
      put(KNOWPLANES, 0);
      put(KNOWREL, 0);
      put(LING, 0);
      put(PERCEP, 0);
      put(PERFORM1, 0);
      put(PERFORM2, 0);
      put(PROF1, 0);
      put(PROF2, 0);
      put(RIDE, 0);
      put(SENSE, 0);
      put(SLEIGHT, 0);
      put(SPELLCRAFT, 0);
      put(STEALTH, 0);
      put(SURVIVAL, 0);
      put(SWIM, 0);
      put(USEMAGDEV, 0);
    }
  };
  
  public HashMap<String, Integer> skillTotals = new LinkedHashMap<String, Integer>(NUM_SKILLS)
  {
    {
      put(ACRO, 0);
      put(APPRAISE, 0);
      put(BLUFF, 0);
      put(CLIMB, 0);
      put(CRAFT1, 0);
      put(CRAFT2, 0);
      put(CRAFT3, 0);
      put(DIPLOM, 0);
      put(DISABLE, 0);
      put(DISGUISE, 0);
      put(ESCAPE, 0);
      put(FLY, 0);
      put(HANDLE, 0);
      put(HEAL, 0);
      put(INTIMIDATE, 0);
      put(KNOWARC, 0);
      put(KNOWDUNG, 0);
      put(KNOWENG, 0);
      put(KNOWGEO, 0);
      put(KNOWHIS, 0);
      put(KNOWLOC, 0);
      put(KNOWNAT, 0);
      put(KNOWNOB, 0);
      put(KNOWPLANES, 0);
      put(KNOWREL, 0);
      put(LING, 0);
      put(PERCEP, 0);
      put(PERFORM1, 0);
      put(PERFORM2, 0);
      put(PROF1, 0);
      put(PROF2, 0);
      put(RIDE, 0);
      put(SENSE, 0);
      put(SLEIGHT, 0);
      put(SPELLCRAFT, 0);
      put(STEALTH, 0);
      put(SURVIVAL, 0);
      put(SWIM, 0);
      put(USEMAGDEV, 0);
    }
  };
  
  public HashMap<String, String> skillAbilities = new LinkedHashMap<String, String>()
  {
    {
      put(ACRO, DEX);
      put(APPRAISE, INT);
      put(BLUFF, CHA);
      put(CLIMB, STR);
      put(CRAFT1, INT);
      put(CRAFT2, INT);
      put(CRAFT3, INT);
      put(DIPLOM, CHA);
      put(DISABLE, DEX);
      put(DISGUISE, CHA);
      put(ESCAPE, DEX);
      put(FLY, DEX);
      put(HANDLE, CHA);
      put(HEAL, WIS);
      put(INTIMIDATE, CHA);
      put(KNOWARC, INT);
      put(KNOWDUNG, INT);
      put(KNOWENG, INT);
      put(KNOWGEO, INT);
      put(KNOWHIS, INT);
      put(KNOWLOC, INT);
      put(KNOWNAT, INT);
      put(KNOWNOB, INT);
      put(KNOWPLANES, INT);
      put(KNOWREL, INT);
      put(LING, INT);
      put(PERCEP, WIS);
      put(PERFORM1, CHA);
      put(PERFORM2, CHA);
      put(PROF1, WIS);
      put(PROF2, WIS);
      put(RIDE, DEX);
      put(SENSE, WIS);
      put(SLEIGHT, DEX);
      put(SPELLCRAFT, INT);
      put(STEALTH, DEX);
      put(SURVIVAL, WIS);
      put(SWIM, STR);
      put(USEMAGDEV, CHA);
    }
  };
}
