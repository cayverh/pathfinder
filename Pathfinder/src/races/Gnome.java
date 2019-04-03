package races;

import java.util.Arrays;

import base.Classification;
import base.Languages;
import base.Race;

public class Gnome extends Race
{
  protected final int BASE_AGE = 40;
  protected final String DEFAULT_ALIGN = "Neutral Good";

  public Gnome()
  {
    // Alter standard racial traits
    setAbilityBonuses(CON, 2);
    setAbilityBonuses(CHA, 2);
    setAbilityBonuses(STR, -2);

    languagesToLearn.addAll(Arrays.asList(Languages.DRACONIC, Languages.DWARVEN, Languages.ELVEN,
        Languages.GIANT, Languages.GOBLIN, Languages.GOBLIN, Languages.ORC));

    setRacialTraits("Defensive Training",
        "+4 dodge bonus to AC against monsters of the giant subtype.");
    setRacialTraits("Illusion Resisitance",
        "+2 racial saving throw bonus against illusion spells and effects.");
    setRacialTraits("Keen Senses", "+2 racial bonus on Perception checks.");
    setRacialTraits("Gnome Magic",
        "+1 to the DC of any saving throws against illusion spells that they cast.");
    setRacialTraits("Hatred",
        "+1 bonus on attack rolls against humanoid creatures of the reptilian and goblinoid subtypes.");
    setRacialTraits("Weapon Familiarity",
        "Any weapon with the word \"gnome\" in its name as a martial weapon.");
    setRacialTraits("Low-Light Vision",
        "Can see twice as far as humans in conditions of dim light.");

    size = "Small";
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
      ageMod = D6.roll(4);
    else if (isSelfTaughtClass(cclass))
      ageMod = D6.roll(6);
    else if (isTrainedClass(cclass))
      ageMod = D6.roll(9);

    age = BASE_AGE + ageMod;
  }

  public int getAgeModifier()
  {
    return age;
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
    languages.add("Gnome");
    languages.add("Sylvan");

    // TODO
    /*
     * Gnomes with high Intelligence scores can choose from the following: Draconic, Dwarven, Elven,
     * Giant, Goblin, and Orc.
     */
  }

  @Override
  public String getDesc()
  {
    return "Expatriates of the strange land of fey, these small folk have a reputation for flighty "
        + "and eccentric behavior. Many gnomes are whimsical artisans and tinkers, creating strange "
        + "devices powered by magic, alchemy, and their quirky imagination. Gnomes have an "
        + "insatiable need for new experiences that often gets them in trouble.";
  }

  public String toString()
  {
    return GNOME;
  }

  /**
   * Set the base weight of the player's character. These attributes vary depending on
   * gender.
   */
  @Override
  public void setHeight(String gender)
  {
    if (gender.equals("Male"))
    {
      height = 3.0;
    }
    else if (gender.equals("Female"))
    {
      height = 2.0;
    }
    else if (gender.equals("Non-Binary"))
    {
      height = 2.5;
    }

    // Generate the actual height of the player's character
    height = height + (D4.roll(2) / 12.0);
  }

  /**
   * Set the base weight of the player's character. These attributes vary depending on
   * gender.
   */
  @Override
  public void setWeight(String gender)
  {
    if (gender.equals("Male"))
    {
      weight = 35;
    }
    else if (gender.equals("Female"))
    {
      weight = 30;
    }
    else if (gender.equals("Non-Binary"))
    {

      weight = 32.5;
    }

    // Generate the actual weight of the player's character
    weight = weight + D4.roll(2);
  }
}
