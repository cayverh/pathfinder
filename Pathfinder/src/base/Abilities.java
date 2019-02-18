package base;

import java.util.HashMap;
import java.util.LinkedHashMap;

public interface Abilities
{
  public static final String STR = "Str";
  public static final String DEX = "Dex";
  public static final String CON = "Con";
  public static final String INT = "Int";
  public static final String WIS = "Wis";
  public static final String CHA = "Cha";
  
  HashMap<String, Integer> abilityScores = new LinkedHashMap<String, Integer>(6);
  HashMap<String, Integer> abilityMods = new LinkedHashMap<String, Integer>(6);
}
