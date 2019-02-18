package races;

import base.Race;

public class HalfOrc extends Race
{
  protected final int BASE_AGE = 14;

  public HalfOrc(String gender)
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
    languages.add("Orc");

    // TODO
    /*
     * Half-orcs with high Intelligence scores can choose from the following: Abyssal, Draconic,
     * Giant, Gnoll, and Goblin.
     */
  }

  @Override
  public String getPhysicalDesc()
  {
    return "Half-orcs average around 6 feet tall, with powerful builds and greenish or grayish skin. "
        + "Their canine teeth often grow long enough to protrude from their mouths, and these 'tusks,' "
        + "combined with heavy brows and slightly pointed ears, give them their notoriously bestial "
        + "appearance. While half-orcs may be impressive, few ever describe them as beautiful. Despite "
        + "these obvious orc traits, half-orcs are as varied as their human parents.";
  }
  
  public String getRace()
  {
    return "Half-Orc";
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
    height = height + D12.roll(2);
    weight = weight + D12.roll(2) * 7;
  }

}
