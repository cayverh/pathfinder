package races;

import base.Classification;
import base.Race;

public class HalfOrc extends Race
{
  protected final int BASE_AGE = 14;
  protected final String DEFAULT_ALIGN = "Chaotic Neutral";

  public HalfOrc(String gender)
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
    languages.add("Orc");

    // TODO
    /*
     * Half-orcs with high Intelligence scores can choose from the following: Abyssal, Draconic,
     * Giant, Gnoll, and Goblin.
     */
  }

  @Override
  public String getDesc()
  {
    return "Often fierce and savage, sometimes noble and resolute, half-orcs can manifest the best "
        + "and worst qualities of their parent races. Many half-orcs struggle to keep their more "
        + "bestial natures in check in order to epitomize the most heroic values of humanity. "
        + "Unfortunately, many outsiders see half-orcs as hopeless abominations devoid of civility, "
        + "if not monsters unworthy of pity or parley.";
  }

  public String getRace()
  {
    return HALFORC;
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
      weight = 150;
    }
    else if (gender.equals("Female"))
    {
      height = 4.42;
      weight = 110;
    }
    else if (gender.equals("Non-Binary"))
    {
      height = 4.61;
      weight = 130;
    }

    // Generate the actual height and weight of the player's character
    height = height + (D12.roll(2) / 12.0);
    weight = weight + D12.roll(2) * 7;
  }

}
