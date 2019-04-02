package races;

import java.util.Arrays;

import base.*;

public class Elf extends Race
{
  protected final int BASE_AGE = 110;
  protected final String DEFAULT_ALIGN = "Chaotic Good";

  public Elf()
  {
    // Alter standard racial traits
    setAbilityBonuses(DEX, 2);
    setAbilityBonuses(INT, 2);
    setAbilityBonuses(CON, -2);

    languagesToLearn.addAll(Arrays.asList(Languages.CELESTIAL, Languages.DRACONIC, Languages.GNOLL,
        Languages.GNOME, Languages.GOBLIN, Languages.ORC, Languages.SYLVAN));

    setRacialTraits("Even Immunities",
        "Immune to magic sleep effects and gain a +2 racial saving throw bonus against enchantment spells and effects.");
    setRacialTraits("Keen Senses", "+2 racial bonus on Perception checks.");
    setRacialTraits("Elven Magic",
        "+2 racial bonus on caster level checks made to overcome spell resistance.\n"
            + "Also receive a +2 racial bonus on Spellcraft skill checks made to identify the properties of magic items.");
    setRacialTraits("Weapon Familiarity",
        "Proficient with longbows, longswords, rapiers, and shortbows.\n"
            + "Also treat any weapon with the word \"elven\" in its name as a martial weapon.");
    setRacialTraits("Low-Light Vision",
        "Can See twice as far as humans in conditions of dim light.");

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
      ageMod = D6.roll(4);
    else if (isSelfTaughtClass(cclass))
      ageMod = D6.roll(5);
    else if (isTrainedClass(cclass))
      ageMod = D6.roll(7);

    return ageMod;
  }

  /**
   * Set the age of the player's elf. Based on class.
   */
  @Override
  public int getBaseAge()
  {
    return BASE_AGE;
  }

  @Override
  public void setLanguages()
  {
    languages.add("Common");
    languages.add("Elven");

    // TODO
    /*
     * Elves with high Intelligence scores can choose from the following: Celestial, Draconic,
     * Gnoll, Gnome, Goblin, Orc, and Sylvan. See the Linguistics skill page for more information
     * about these languages.
     */
  }

  public String getDesc()
  {
    return "GTall, noble, and often haughty, elves are long-lived and subtle masters of the "
        + "wilderness. Elves excel in the arcane arts. Often they use their intrinsic link to "
        + "nature to forge new spells and create wondrous items that, like their creators, seem "
        + "nearly impervious to the ravages of time. A private and often introverted race, elves "
        + "can give the impression they are indifferent to the plights of others.";
  }

  public String toString()
  {
    return ELF;
  }

  /**
   * Set the base height and weight of the player's character. These attributes vary depending on
   * gender.
   */
  @Override
  public void setWeightAndHeight(String gender)
  {
    height = 5.33;

    if (gender.equals("Male"))
    {
      weight = 110;

      // Generate the actual height and weight of the player's character
      height = height + (D8.roll(2) / 12.0);
      weight = weight + D8.roll(2) * 3;
    }
    else if (gender.equals("Female"))
    {
      weight = 90;

      // Generate the actual height and weight of the player's character
      height = height + (D6.roll(2) / 12.0);
      weight = weight + D6.roll(2) * 3;
    }
    else if (gender.equals("Non-Binary"))
    {
      weight = 100;

      // Generate the actual height and weight of the player's character
      height = height + (D6.roll(1) + D8.roll(1) / 12.0);
      weight = weight + (D6.roll(2) * 3 + D8.roll(2) * 3) / 3;
    }
  }
}
