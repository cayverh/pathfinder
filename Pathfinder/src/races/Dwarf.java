package races;

import java.util.Arrays;

import base.*;

public class Dwarf extends Race
{
  protected final int BASE_AGE = 40;
  protected final String DEFAULT_ALIGN = "Lawful Good";

  public Dwarf()
  {
    super();

    // Alter standard racial traits
    setAbilityBonuses(CON, 2);
    setAbilityBonuses(WIS, 2);
    setAbilityBonuses(CHA, -2);

    languagesToLearn.addAll(Arrays.asList(Languages.GIANT, Languages.GNOLL));

    setRacialTraits("Defensive Training",
        "+4 dodge bonus to AC against monsters of the giant subtype.");
    setRacialTraits("Hardy",
        "+2 racial bonus on saving throws against poison, spells, and spell-like abilities.");
    setRacialTraits("Stability",
        "+4 racial bonus on CMD when resisting a bull rush or trip attempt while standing.");
    setRacialTraits("Greed",
        "+2 racial bonus to Appraise checks made to determine the price of non-magical goods that contain precious metals or gemstones.");
    setRacialTraits("Stonecunning",
        "+2 bonus on Perception checks to notice unusual stonework, such as traps and hidden doors located in stone walls or floors.\n"
            + "Also receive a check to notice such features whenever they pass within 10 feet of them, whether or not they are actively looking.");
    setRacialTraits("Darkvision", "See perfectly in the dark up to 60 feet.");
    setRacialTraits("Hatred",
        "+1 racial bonus on attack rolls against creatures of the orc and goblinoid subtypes.");
    setRacialTraits("Weapon Familiarity",
        "Proficiency with battleaxes, heavy picks, and warhammers.\n"
            + "Also treat any weapon with the word \"dwarven\" in its name as a martial weapon.");

    size = "Medium";
    baseSpeed = 20;

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
      ageMod = D6.roll(3);
    else if (isSelfTaughtClass(cclass))
      ageMod = D6.roll(5);
    else if (isTrainedClass(cclass))
      ageMod = D6.roll(7);
    
    age = BASE_AGE + ageMod;
  }

  /**
   * Set the age of the player's dwarf. Based on class.
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
    languages.add("Dwarven");
  }

  public String getDesc()
  {
    return "These short and stocky defenders of mountain fortresses are often seen as stern and "
        + "humorless. Known for mining the earth�s treasures and crafting magnificent items from "
        + "ore and gemstones, they have an unrivaled affinity for the bounties of the deep earth. "
        + "Dwarves also have a tendency toward traditionalism and isolation that sometimes "
        + "manifests as xenophobia.";
  }

  public String toString()
  {
    return DWARF;
  }

  /**
   * Set the base height and weight of the player's character. These attributes vary depending on
   * gender.
   */
  @Override
  public void setHeight(String gender)
  {
    double h = 0;
    
    if (gender.equals("Male"))
    {
      h = 3.75;
    }
    else if (gender.equals("Female"))
    {
      h = 3.58;
    }
    else if (gender.equals("Non-Binary"))
    {
      h = 3.66;
    }

    // Generate the actual height of the player's character
    height = h + (D4.roll(2) / 12.0);
  }
  
  /**
   * Set the base height and weight of the player's character. These attributes vary depending on
   * gender.
   */
  @Override
  public void setWeight(String gender)
  {
    double w = 0;
    
    if (gender.equals("Male"))
    {
      w = 150;
    }
    else if (gender.equals("Female"))
    {
      w = 120;
    }
    else if (gender.equals("Non-Binary"))
    {
      w = 135;
    }

    // Generate the actual weight of the player's character
    weight = w + D4.roll(2) * 7;
  }
}
