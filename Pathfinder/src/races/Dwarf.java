package races;

import base.*;

public class Dwarf extends Race
{
  protected final int BASE_AGE = 40;

  public Dwarf(String gender)
  {
    super(gender);

    setWeightAndHeight();

    // Alter standard racial traits
    setAbilityBonuses(CON, 2);
    setAbilityBonuses(WIS, 2);
    setAbilityBonuses(CHA, -2);

    size = "Medium";
    baseSpeed = 20;
    
    setLanguages();
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

  public String getPhysicalDesc()
  {
    return "Dwarves are a short and stocky race, and stand about a foot shorter than most humans, "
        + "with wide, compact bodies that account for their burly appearance. Male and female "
        + "dwarves pride themselves on the long length of their hair, and men often decorate their "
        + "beards with a variety of clasps and intricate braids. Clean-shavenness on a male dwarf "
        + "is a sure sign of madness, or worse—no one familiar with their race trusts a beardless "
        + "dwarven man.";
  }
  
  public String getRace()
  {
    return DWARF;
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
      height = 3.75;
      weight = 150;
    }
    else if (gender.equals("Female"))
    {
      height = 3.58;
      weight = 120;
    }
    else if (gender.equals("Non-Binary"))
    {
      height = 3.66;
      weight = 135;
    }

    // Generate the actual height and weight of the player's character
    height = height + D4.roll(2);
    weight = weight + D4.roll(2) * 7;
  }
}
