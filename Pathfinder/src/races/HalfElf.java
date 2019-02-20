package races;

import base.Classification;
import base.Languages;
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
