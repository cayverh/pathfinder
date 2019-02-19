package races;

import base.Classification;
import base.Race;

public class Human extends Race
{
  protected final int BASE_AGE = 15;
  protected final String DEFAULT_ALIGN = "Neutral";

  public Human(String gender)
  {
    super(gender);

    setWeightAndHeight();

    // Alter standard racial traits
    abilityScoreBonusToSpend = 2;

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
      ageMod = D4.roll(1);
    else if (isSelfTaughtClass(cclass))
      ageMod = D6.roll(1);
    else if (isTrainedClass(cclass))
      ageMod = D6.roll(2);

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

    // TODO
    /*
     * Humans with high Intelligence scores can choose any languages they want (except secret
     * languages, such as Druidic).
     */
  }

  @Override
  public String getDesc()
  {
    return "Ambitious, sometimes heroic, and always confident, humans have an ability to work "
        + "together toward common goals that makes them a force to be reckoned with. Though "
        + "short-lived compared to other races, their boundless energy and drive allow them to "
        + "accomplish much in their brief lifetimes.";
  }

  public String getRace()
  {
    return HUMAN;
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
      height = 4.8;
      weight = 120;
    }
    else if (gender.equals("Female"))
    {
      height = 4.42;
      weight = 85;
    }
    else if (gender.equals("Non-Binary"))
    {
      height = 4.61;
      weight = 102.5;
    }

    // Generate the actual height and weight of the player's character
    height = height + (D10.roll(2) / 12.0);
    weight = weight + D10.roll(2) * 5;
  }

}
