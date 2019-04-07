package races;

import base.Languages;
import base.Race;

public class Human extends Race
{
  protected final int BASE_AGE = 15;
  protected final String DEFAULT_ALIGN = "Neutral";

  public Human()
  {
    // Alter standard racial traits
    abilityScoreBonusToSpend = 2;

    languagesToLearn.addAll(Languages.allLanguages);

    setRacialTraits("Bonus Feat", "Select one extra feat at 1st level.");
    setRacialTraits("Skilled",
        "Gain an additional skill rank at first level and one additional rank whenever they gain a level.");

    size = "Medium";
    baseSpeed = 30;

    setLanguages();
  }

  public String getAlignment()
  {
    return DEFAULT_ALIGN;
  }

  public void setAge(String cclass)
  {
    int ageMod = 0;

    if (isIntuitiveClass(cclass))
      ageMod = D4.roll(1);
    else if (isSelfTaughtClass(cclass))
      ageMod = D6.roll(1);
    else if (isTrainedClass(cclass))
      ageMod = D6.roll(2);

    age = BASE_AGE + ageMod;
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

  public String toString()
  {
    return HUMAN;
  }

  /**
   * Set the base height of the player's character. These attributes vary depending on
   * gender.
   */
  @Override
  public void setHeight(String gender)
  {
    double h = 0;
    
    if (gender.equals("Male"))
    {
      h = 4.8;
    }
    else if (gender.equals("Female"))
    {
      h = 4.42;
    }
    else if (gender.equals("Non-Binary"))
    {
      h = 4.61;
    }

    // Generate the actual height of the player's character
    height = h + (D10.roll(2) / 12.0);
  }

  /**
   * Set the base weight of the player's character. These attributes vary depending on
   * gender.
   */
  @Override
  public void setWeight(String gender)
  {
    double w = 0;
    
    if (gender.equals("Male"))
    {
      w = 120;
    }
    else if (gender.equals("Female"))
    {
      w = 85;
    }
    else if (gender.equals("Non-Binary"))
    {
      w = 102.5;
    }

    // Generate the actual weight of the player's character
    weight = w + D10.roll(2) * 5;
  }
}
