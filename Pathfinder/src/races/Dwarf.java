package races;

import dice.*;

public class Dwarf extends CoreRace
{
  protected static final String DESCRIPTION = "Dwarves are a short and stocky race, and stand about a foot shorter than most humans, "
      + "with wide, compact bodies that account for their burly appearance. Male and female dwarves pride"
      + " themselves on the long length of their hair, and men often decorate their beards with a variety"
      + " of clasps and intricate braids. Clean-shavenness on a male dwarf is a sure sign of madness, or"
      + " worse—no one familiar with their race trusts a beardless dwarven man.";
  protected static final int BASE_AGE = 40;
  
  public Dwarf(String gender)
  {
    super();
    
    die = new D4();

    // Set the gender of the player's character
    this.gender = gender;

    // Set the age of the player's character
    age = BASE_AGE; // TODO - Add age based on class

    // Set the base height and weight of the player's character
    if (gender.equals("Male"))
    {
      baseHeight = 3.75;
      baseWeight = 150;
    }
    else if (gender.equals("Female"))
    {
      baseHeight = 3.58;
      baseWeight = 120;
    }
    else if (gender.equals("Non-Binary"))
    {
      baseHeight = 3.66;
      baseWeight = 135;
    }

    // Generate the actual height and weight of the player's character
    height = baseHeight + die.roll(2);
    weight = baseWeight + die.roll(2) * 7;
    
    // Alter standard racial traits
    abilityBonuses.replace(CON, abilityBonuses.get(CON) + 2);
    abilityBonuses.replace(WIS, abilityBonuses.get(WIS) + 2);
    abilityBonuses.replace(CHA, abilityBonuses.get(CHA) - 2);
    
    size = "Medium";
    baseSpeed = 20;
    languages.add("Common");
    languages.add("Dwarven");
  }
}
