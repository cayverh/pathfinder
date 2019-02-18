package races;

import base.*;

public class Elf extends Race
{
  protected final int BASE_AGE = 110;

  public Elf(String gender)
  {
    super(gender);
    
    setWeightAndHeight();

    // Alter standard racial traits
    setAbilityBonuses(DEX, 2);
    setAbilityBonuses(INT, 2);
    setAbilityBonuses(CON, -2);
    
    size = "Medium";
    baseSpeed = 30;

    setLanguages();
  }

  /**
   * Set the age of the player's elf. Based on class.
   */
  @Override
  public int getBaseAge()
  {
    return BASE_AGE;
  }

  @Override
  public void setLanguages()
  {
    languages.add("Common");
    languages.add("Elven");

    // TODO
    /*
     * Elves with high Intelligence scores can choose from the following: Celestial, Draconic,
     * Gnoll, Gnome, Goblin, Orc, and Sylvan. See the Linguistics skill page for more information
     * about these languages.
     */
  }

  public String getPhysicalDesc()
  {
    return "Generally taller than humans, elves possess a graceful, slender physique that is accentuated "
        + "by their long, pointed ears. It is a mistake, however, to consider them weak or feeble, as the "
        + "thin limbs of an elf can contain surprising power. Their eyes are wide and almond-shaped, and "
        + "filled with large, vibrantly colored pupils. The coloration of elves as a whole varies wildly, "
        + "and is much more diverse than that of human populations. However, as their coloration often "
        + "matches their surroundings, the elves of a single community may appear quite similar. "
        + "Forest-dwelling elves often have variations of green, brown, and tan in their hair, eye, and "
        + "even skin tones.";
  }
  
  public String getRace()
  {
    return ELF;
  }

  /**
   * Set the base height and weight of the player's character. These attributes vary depending on
   * gender.
   */
  @Override
  public void setWeightAndHeight()
  {
    if (gender.equals("Male"))
    {
      height = 3.75;
      weight = 150;

      // Generate the actual height and weight of the player's character
      height = height + D8.roll(2);
      weight = weight + D8.roll(2) * 3;
    }
    else if (gender.equals("Female"))
    {
      height = 3.58;
      weight = 120;

      // Generate the actual height and weight of the player's character
      height = height + D6.roll(2);
      weight = weight + D6.roll(2) * 3;
    }
    else if (gender.equals("Non-Binary"))
    {
      height = 3.66;
      weight = 135;

      // Generate the actual height and weight of the player's character
      height = height + D6.roll(1) + D8.roll(1);
      weight = weight + (D6.roll(2) * 3 + D8.roll(2) * 3) / 3;
    }
  }
}
