package races;

import base.Race;

public class Gnome extends Race
{
  protected final int BASE_AGE = 40;
  
  public Gnome(String gender)
  {
    super(gender);

    setAge();
    setWeightAndHeight();

    // Alter standard racial traits
    setAbilityBonuses(CON, 2);
    setAbilityBonuses(CHA, 2);
    setAbilityBonuses(STR, -2);

    size = "Small";
    baseSpeed = 20;

    setLanguages();
  }

  @Override
  public void setAge()
  {
    age = BASE_AGE;
    // TODO
  }

  @Override
  public void setLanguages()
  {
    languages.add("Common");
    languages.add("Gnome");
    languages.add("Sylvan");

    // TODO
    /*
     * Gnomes with high Intelligence scores can choose from the following: Draconic, Dwarven, Elven,
     * Giant, Goblin, and Orc.
     */
  }

  @Override
  public String getPhysicalDesc()
  {
    return "Gnomes are one of the smallest of the common races, generally standing just over 3 feet "
        + "in height. Despite their small frames, however, gnomes are extremely resilient, and not as "
        + "weak as many of their foes assume. Though their diminutive stature reduces their ability to "
        + "move quickly, gnomes often train to take advantage of their size, especially when fighting "
        + "foes much larger than themselves.";
  }
  
  public String getRace()
  {
    return "Gnomef";
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
      height = 3.0;
      weight = 35;
    }
    else if (gender.equals("Female"))
    {
      height = 2.0;
      weight = 30;
    }
    else if (gender.equals("Non-Binary"))
    {
      height = 2.5;
      weight = 32.5;
    }

    // Generate the actual height and weight of the player's character
    height = height + D4.roll(2);
    weight = weight + D4.roll(2);
  }

}
