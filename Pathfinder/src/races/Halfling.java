package races;

import base.Race;

public class Halfling extends Race
{
  protected final int BASE_AGE = 20;

  public Halfling(String gender)
  {
    super(gender);

    setWeightAndHeight();

    // Alter standard racial traits
    abilityBonuses.put(DEX, 2);
    abilityBonuses.put(CHA, 2);
    abilityBonuses.put(STR, -2);

    size = "Medium";
    baseSpeed = 30;

    setLanguages();
  }

  @Override
  public int getBaseAge()
  {
    return BASE_AGE;
  }

  @Override
  public void setLanguages()
  {
    languages.add("Common");
    languages.add("Halfling");

    // TODO
    /*
     * Halflings with high Intelligence scores can choose from the following: Dwarven, Elven, Gnome,
     * and Goblin.
     */
  }

  @Override
  public String getPhysicalDesc()
  {
    return "Halflings rise to a humble height of 3 feet. They prefer to walk barefoot, leading the "
        + "bottoms of their feet to become roughly calloused. Tufts of thick, curly hair warm the tops "
        + "of their broad, tanned feet.\n" + "\n"
        + "Their skin tends toward a rich cinnamon color and their hair toward light shades of brown. "
        + "A halfling’s ears are pointed, but proportionately not much larger than those of a human.";
  }
  
  public String getRace()
  {
    return HALFLING;
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
      height = 2.75;
      weight = 30;
    }
    else if (gender.equals("Female"))
    {
      height = 2.5;
      weight = 25;
    }
    else if (gender.equals("Non-Binary"))
    {
      height = 2.625;
      weight = 27.5;
    }

    // Generate the actual height and weight of the player's character
    height = height + D4.roll(2);
    weight = weight + D4.roll(2);
  }

}
