package abilities;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

public class AbilityScores implements Abilities {
	public static final int NUM_CLASSES = 11;
	public static final int NUM_RACES = 7;
	public static final int NUM_ABILITY_SCORES = 6;
	public static final int MAX = 6;
	public static final int MIN = 1;

	private HashMap<String, Integer> abilityScores = new LinkedHashMap<String, Integer>(6);
	private HashMap<String, Integer> abilityMods = new LinkedHashMap<String, Integer>(6);

	public AbilityScores() {
		int[] randNum = new int[4];
		int lowestScore = 0;
		int totalScore = 0;

		// Randomly generate an ability score for each ability.
		for (int i = 0; i < NUM_ABILITY_SCORES; i++) {
			// Reset
			lowestScore = 0;
			totalScore = 0;

			// Generate and store four random numbers between 1 and 6.
			// Also record the lowest number.
			for (int j = 0; j < 4; j++) {
				randNum[j] = new Random().nextInt(MAX) + MIN;

				if (j == 0) {
					lowestScore = randNum[j];
				} else if (randNum[j] <= lowestScore) {
					lowestScore = randNum[j];
				}
			}

			// Add the three highest "rolls" together.
			for (int k = 0; k < 4; k++) {
				totalScore += randNum[k];
			}

			// Subtract the lowest "roll" from the total score.
			totalScore -= lowestScore;

			// Associate the random generated score to an ability score on each iteration.
			switch (i) {
			case 0:
				abilityScores.put(STR, totalScore);
				break;

			case 1:
				abilityScores.put(DEX, totalScore);
				break;

			case 2:
				abilityScores.put(CON, totalScore);
				break;

			case 3:
				abilityScores.put(INT, totalScore);
				break;

			case 4:
				abilityScores.put(WIS, totalScore);
				break;

			case 5:
				abilityScores.put(CHA, totalScore);
				break;
			}
		}
		
		setAbilityMods();
	}
	
	public HashMap<String, Integer> getAbilityScores() {
	  setAbilityMods();
	  
		return abilityScores;
	}
	
	public HashMap<String, Integer> getAbilityMods() {
		return abilityMods;
	}
	
	public void setAbilityMods()
	{
	  abilityMods = new AbilityMods(abilityScores).getAbilityMods();
	}
}
