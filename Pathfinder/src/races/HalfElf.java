package races;

import base.Race;

public class HalfElf extends Race
{
  protected final int BASE_AGE = 20;

  public HalfElf(String gender)
  {
    super(gender);

    setAge();
    setWeightAndHeight();

    // Alter standard racial traits
    abilityScoreBonusToSpend = 2;

    size = "Medium";
    baseSpeed = 30;

    setLanguages();
  }

  @Override
  public void setAge()
  {
    age = BASE_AGE;
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
  public String getPhysicalDesc()
  {
    return "Half-elves stand taller than humans but shorter than elves. They inherit the lean build "
        + "and comely features of their elven lineage, but their skin color is normally dictated by "
        + "their human side. While half-elves retain the pointed ears of elves, theirs are more "
        + "rounded and less pronounced. Their eyes tend to be human-like in shape, but feature an "
        + "exotic range of colors from amber or violet to emerald green and deep blue. This pattern "
        + "changes for half-elves of drow descent, however. Such elves are almost unfailingly marked "
        + "with the white or silver hair of the drow parent, and more often than not have dusky gray "
        + "skin that takes on a purplish or bluish tinge in the right light, while their eye color "
        + "usually favors that of the human parent.";
  }
  
  public String getRace()
  {
    return "Half-Elf";
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
    height = height + D8.roll(2);
    weight = weight + D8.roll(2) * 5;
  }

}
