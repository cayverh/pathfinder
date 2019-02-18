package races;

import base.Race;

public class Human extends Race
{
  protected final int BASE_AGE = 15;

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
  public String getPhysicalDesc()
  {
    return "The physical characteristics of humans are as varied as the world’s climes. From the "
        + "dark-skinned tribesmen of the southern continents to the pale and barbaric raiders of "
        + "the northern lands, humans possess a wide variety of skin colors, body types, and facial "
        + "features. Generally speaking, humans’ skin color assumes a darker hue the closer to the "
        + "equator they live. At the same time, bone structure, hair color and texture, eye color, "
        + "and a host of facial and bodily phenotypic characteristics vary immensely from one locale "
        + "to another.";
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
    height = height + D10.roll(2);
    weight = weight + D10.roll(2) * 5;
  }

}
