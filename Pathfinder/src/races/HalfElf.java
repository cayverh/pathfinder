package races;

import base.Classification;
import base.Languages;
import base.Race;

public class HalfElf extends Race
{
  protected final int BASE_AGE = 20;
  protected final String DEFAULT_ALIGN = "Chaotic Good";

  public HalfElf()
  {
    // Alter standard racial traits
    abilityScoreBonusToSpend = 2;

    languagesToLearn.addAll(Languages.allLanguages);

    setRacialTraits("Elven Immunities",
        "Immune to magic sleep effects and gain a +2 racial saving throw bonus against enchantment spells and effects.");
    setRacialTraits("Adaptability", "Receive Skill Focus as a bonus feat at 1st level.");
    setRacialTraits("Keen Senses", "+2 racial bonus on Perception checks");
    setRacialTraits("Low-Light Vision", "See twice as far as humans in conditions of dim light");
    setRacialTraits("Elven Magic",
        "+2 racial bonus on caster level checks made to overcome spell resistance.\n"
            + "Also +2 racial bonus on Spellcraft skill checks made to identify the properties of magic items.");
    setRacialTraits("Multitalented",
        "Choose two favored classes at first level and gain +1 hit point or +1 skill point whenever they take a level in either one of those classes.");
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
      ageMod = D6.roll(1);
    else if (isSelfTaughtClass(cclass))
      ageMod = D6.roll(2);
    else if (isTrainedClass(cclass))
      ageMod = D6.roll(3);

    age = BASE_AGE + ageMod;
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

  public String toString()
  {
    return HALFELF;
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
      h = 5.16;
    }
    else if (gender.equals("Female"))
    {
      h = 5.0;
    }
    else if (gender.equals("Non-Binary"))
    {
      h = 5.08;
    }

    // Generate the actual height of the player's character
    height = h + (D8.roll(2) / 12.0);
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
      w = 100;
    }
    else if (gender.equals("Female"))
    {
      w = 90;
    }
    else if (gender.equals("Non-Binary"))
    {
      w = 95;
    }

    // Generate the actual weight of the player's character
    weight = w + D8.roll(2) * 5;
  }
}
