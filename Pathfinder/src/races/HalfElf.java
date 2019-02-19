package races;

import base.Classification;
import base.Race;

public class HalfElf extends Race
{
  protected final int BASE_AGE = 20;
  protected final String DEFAULT_ALIGN = "Chaotic Good";

  public HalfElf(String gender)
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
      ageMod = D6.roll(1);
    else if (isSelfTaughtClass(cclass))
      ageMod = D6.roll(2);
    else if (isTrainedClass(cclass))
      ageMod = D6.roll(3);

    return ageMod;
  }

  @Override
  public int getBaseAge()
  {
    return BASE_AGE;
    // TODO
  }

  @Override
  public void setLanguages()
  {
    languages.add("Common");
    languages.add("Eleven");
    // TODO
    /*
     * Half-elves with high Intelligence scores can choose any languages they want (except secret
     * languages, such as Druidic).
     */
  }

  @Override
  public String getDesc()
  {
    return "HOften caught between the worlds of their progenitor races, half-elves are a race of "
        + "both grace and contradiction. Their dual heritage and natural gifts often create "
        + "brilliant diplomats and peacemakers, but half-elves are often susceptible to an intense "
        + "and even melancholic isolation, realizing that they are never truly part of elven or "
        + "human society.";
  }

  public String getRace()
  {
    return HALFELF;
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
      height = 5.16;
      weight = 100;
    }
    else if (gender.equals("Female"))
    {
      height = 5.0;
      weight = 90;
    }
    else if (gender.equals("Non-Binary"))
    {
      height = 5.08;
      weight = 95;
    }

    // Generate the actual height and weight of the player's character
    height = height + (D8.roll(2) / 12.0);
    weight = weight + D8.roll(2) * 5;
  }

}
