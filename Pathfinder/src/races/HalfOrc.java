package races;

import java.util.Arrays;

import base.Classification;
import base.Languages;
import base.Race;

public class HalfOrc extends Race
{
  protected final int BASE_AGE = 14;
  protected final String DEFAULT_ALIGN = "Chaotic Neutral";

  public HalfOrc()
  {
    // Alter standard racial traits
    abilityScoreBonusToSpend = 2;

    languagesToLearn.addAll(Arrays.asList(Languages.ABYSSAL, Languages.DRACONIC, Languages.GIANT,
        Languages.GNOLL, Languages.GOBLIN));

    setRacialTraits("Intimidating",
        "+2 racial bonus on Intimidate checks due to their fearsome nature.");
    setRacialTraits("Orc Ferocity",
        "Once per day, when a half-orc is brought below 0 hit points but not killed, they can fight on for 1 more round as if disabled.\n"
            + "At the end of thier next turn, unless brought to above 0 hit points, they immediately fall unconscious and begin dying.");
    setRacialTraits("Weapon Familiarity",
        "Proficient with greataxes and falchions and treat any weapon with the word \"orc\" in its name as a martial weapon.");
    setRacialTraits("Dark Vision", "Can see in the dark up to 60 feet.");
    setRacialTraits("Light Sensitivity",
        "Dazzled in areas of bright sunlight or within the radius of a daylight spell.");
    setRacialTraits("Weapon Familiarity", "Proficient with greataxes and falchions.\n"
        + "Also treat any weapon with the word �orc� in its name as a martial weapon.");
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

  public String toString()
  {
    return HALFORC;
  }

  /**
   * Set the base height and weight of the player's character. These attributes vary depending on
   * gender.
   */
  @Override
  public void setWeightAndHeight(String gender)
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
