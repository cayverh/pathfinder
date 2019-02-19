package races;

import java.util.ArrayList;

import base.Classification;
import base.Race;

public class Halfling extends Race
{
  protected final int BASE_AGE = 20;
  protected final String DEFAULT_ALIGN = "Neutral";

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
  
  public String getAlignment()
  {
    return DEFAULT_ALIGN;
  }
  
  public int getAgeModifier(String cclass)
  {
    int ageMod = 0;

    if (isIntuitiveClass(cclass))
      ageMod = D4.roll(2);
    else if (isSelfTaughtClass(cclass))
      ageMod = D6.roll(3);
    else if (isTrainedClass(cclass))
      ageMod = D6.roll(4);

    return ageMod;
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
  public String getDesc()
  {
    return "Members of this diminutive race find strength in family, community, and their own innate "
        + "and seemingly inexhaustible luck. While their fierce curiosity is sometimes at odds with "
        + "their intrinsic common sense, half lings are eternal optimists and cunning opportunists "
        + "with an incredible knack for getting out the worst situations.";
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
    height = height + (D4.roll(2) / 12.0);
    weight = weight + D4.roll(2);
  }

}
