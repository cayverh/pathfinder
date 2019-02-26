package abilities;

import java.util.HashMap;
import java.util.LinkedHashMap;

import base.Race;

public class AbilityMods {
	private HashMap<String, Integer> abilityMods = new LinkedHashMap<String, Integer>(6);
	
	public AbilityMods(HashMap<String, Integer> abilityScores)
	{
		int mod;

	    for (String key : abilityScores.keySet())
	    {
	      int score = abilityScores.get(key);

	      if (score <= 3)
	        mod = -4;
	      else if (score <= 5)
	        mod = -3;
	      else if (score <= 7)
	        mod = -2;
	      else if (score <= 9)
	        mod = -1;
	      else if (score <= 11)
	        mod = 0;
	      else if (score <= 13)
	        mod = 1;
	      else if (score <= 15)
	        mod = 2;
	      else if (score <= 17)
	        mod = 3;
	      else
	        mod = 4;

	      abilityMods.put(key, mod);
	    }
	}
	
	public AbilityMods(HashMap<String, Integer> abilityScores, Race charRace)
	{
		int mod;

	    for (String key : abilityScores.keySet())
	    {
	      int score = abilityScores.get(key);

	      if (score <= 3)
	        mod = -4;
	      else if (score <= 5)
	        mod = -3;
	      else if (score <= 7)
	        mod = -2;
	      else if (score <= 9)
	        mod = -1;
	      else if (score <= 11)
	        mod = 0;
	      else if (score <= 13)
	        mod = 1;
	      else if (score <= 15)
	        mod = 2;
	      else if (score <= 17)
	        mod = 3;
	      else
	        mod = 4;

	      abilityMods.put(key, mod + charRace.getAbilityBonuses().get(key));
	    }
	}
	
	public HashMap<String, Integer> getAbilityMods()
	{
		return abilityMods;
	}
}
