package base;

/**
 * The creation of a Pathfinder character.
 * 
 * The user enters information into a GUI, which is passed to this class.
 * 
 * @author Cayleigh
 *
 */
public class Character implements Abilities
{
  public static final int MAX = 6;
  public static final int MIN = 1;

  private String player;
  private int age;
  private String charName;
  private String alignment;
  private String diety;
  private String homeland;
  private String gender;
  private String hairColor;
  private String eyeColor;

  private Race charRace; // Size, gender, height, weight, and speed are all determined by
                         // race

  private Classification charClass; // HP, starting wealth, skills, and skill ranks, base attack
                                    // bonus, fort save, ref save, and will save are determined by
                                    // class

  /**
   * Creates a new Pathfinder character based on user input. If a user omits information, details
   * are either randomly generated or left blank.
   * 
   * @param player
   *          The name of the player
   * @param charName
   *          The name of the player's character
   * @param gend
   *          The gender of the player's character
   * @param align
   *          The alignment of the player's character
   * @param race
   *          The Race of the player's character
   * @param cclass
   *          The Classification of the player's character
   */
  public Character(String player, String charName, String gend, String align,
      String race, String cclass, String hairColor, String eyeColor, int age)
  {
    this.player = player;
    this.charName = charName;
    alignment = align;
    this.age = age;

    gender = Generator.genGender(gend);

    // Gets the Race of the character based on user input.
    // If none, a Race is randomly generated.
    charRace = Generator.genRace(gender, race);
    charClass = Generator.genClass(cclass);

    setAppearance(hairColor, eyeColor);
  }
  
  /********************************************************************************************************/
  /*
   * BELOW ARE THE SETTERS FOR APPLYING DETAILS TO THE PLAYER'S CHARACTER.
   */
  /********************************************************************************************************/

  /**
   * Sets the player's character's appearance.
   * 
   * @param hairColor
   *          Color of character's hair
   * @param eyeColor
   *          Color of character's eyes
   */
  public void setAppearance(String hairColor, String eyeColor)
  {
    if (hairColor != null)
      this.hairColor = hairColor;
    else
      this.hairColor = "";

    if (eyeColor != null)
      this.eyeColor = eyeColor;
    else
      this.eyeColor = "";
  }

  /**
   * Generate random scores for the six abilities: Strength, Dexterity, Constitution, Intelligence,
   * Wisdom, and Charisma.
   */
  public void genAbilityScores()
  {
    Generator.genAbilityScores(abilityScores);
  }

  /**
   * Generate the ability modifiers of the six abilities: Strength, Dexterity, Constitution,
   * Intelligence, Wisdom, and Charisma.
   */
  public void genAbilityMods()
  {
    Generator.genAbilityMods(abilityScores, abilityMods, charRace);
  }
  
  /**
   * Applies an Ability Score Bonus Modifier to an ability of the player's choice. If the player has
   * a Modifier to spend, the Ability Modifiers are regenerated in order to account for the change
   * in Ability Score.
   * 
   * @param ability
   *          Ability to spend bonus on
   */
  public void setAbilityScoreMod(String ability)
  {
    int toSpend = charRace.getAbilityScoreBonusToSpend();

    abilityScores.put(ability, abilityScores.get(ability) + toSpend);

    if (toSpend != 0)
      genAbilityMods();
  }

  /********************************************************************************************************/
  /*
   * BELOW ARE THE GETTERS FOR RETREIVING DETAILS ABOUT THE PLAYER'S CHARACTER.
   */
  /********************************************************************************************************/

  /**
   * Creates a formatted String representing the Ability Scores and Modifiers of the player's
   * character.
   * 
   * @return abilityInfo
   */
  public String getAbilityInfo()
  {
    String abilityInfo = "";

    for (String ability : abilityScores.keySet())
    {
      abilityInfo += String.format("%s: %s, Mod: %s\n", ability,
          abilityScores.get(ability), abilityMods.get(ability));
    }

    return abilityInfo;
  }

  /**
   * Returns the age of the player's character. If the player doesn't enter a desired age, the age
   * is generated based on Race and Class.
   * 
   * @return age
   */
  public int getAge()
  {
    if (age == 0)
      return charRace.getBaseAge()
          + charRace.getAgeModifier(getClassification());
    else
      return age;
  }

  /**
   * Returns the character's alignment. If an alignment isn't provided by the user, the alignment is
   * set as the character's Race default alignment.
   * 
   * @return alignment
   */
  public String getAlignment()
  {
    if (alignment.isEmpty())
      alignment = charRace.getAlignment();

    return alignment;
  }

  /**
   * Creates a formatted String representing the general information about the player's character.
   * 
   * @return charInfo
   */
  public String getGeneralCharInfo()
  {
    String charInfo = "";

    charInfo += String.format("   Player Name: %-20.20s\tCharacter: %s\n",
        player, charName, charRace.getBaseAge());
    charInfo +=
        String.format("\tGender: %-20.20s\t      Age: %d\n", gender, getAge());
    charInfo +=
        String.format("\tHeight: %-20.20s\t   Weight: %-20.10s\tSize: %s\n",
            getHeight(), getWeight(), getSize());
    charInfo += String.format("    Hair Color: %-20.20s\tEye Color: %s\n",
        hairColor, eyeColor);

    charInfo += "\n";

    charInfo += String.format("\t  Race: %-20.20s\t    Class: %s\n", getRace(),
        getClassification());
    charInfo += String.format("     Alignment: %-20.20s\t    Diety: %s\n",
        getAlignment(), diety);
    charInfo += String.format("      Homeland: %-20.20s\n", homeland);

    return charInfo;
  }

  /**
   * Generates, sets, and returns a new race for the player's character.
   * 
   * @return new Race
   */
  public String getNewClass()
  {
    charClass = Generator.genClass("");
    return getClassification();
  }

  /**
   * Returns the Class of the player's character.
   * 
   * @return classification
   */
  public String getClassification()
  {
    return charClass.getClassification();
  }

  public String getHeight()
  {
    return charRace.getHeight();
  }

  /**
   * Generates, sets, and returns a new race for the player's character.
   * 
   * @return new Race
   */
  public String getNewRace()
  {
    charRace = Generator.genRace(gender, "");
    return getRace();
  }

  /**
   * Returns the Race of the player's character.
   * 
   * @return race
   */
  public String getRace()
  {
    return charRace.getRace();
  }

  /**
   * Gets the size of the character's race.
   * 
   * @return size
   */
  public String getSize()
  {
    return charRace.getSize();
  }

  /**
   * Gets the String representation of the character's weight.
   * 
   * @return weight
   */
  public String getWeight()
  {
    return charRace.getWeight();
  }

  /********************************************************************************************************/
  /*
   * BELOW ARE THE GETTERS AND SETTERS FOR THE ABILITY SCORES AND MODIFIERS. MAY NOT EVER BE USED.
   */
  /********************************************************************************************************/

  /**
   * Returns the Ability Score for STRENGTH.
   * 
   * @return strength score
   */
  public int getStr()
  {
    return abilityScores.get(STR);
  }

  /**
   * Returns the Ability Modifier for STRENGTH.
   * 
   * @return strength mod
   */
  public int getStrMod()
  {
    return abilityMods.get(STR);
  }

  /**
   * Returns the Ability Score for DEXTERITY.
   * 
   * @return dexterity score
   */
  public int getDex()
  {
    return abilityScores.get(DEX);
  }

  /**
   * Returns the Ability Modifier for DEXTERITY.
   * 
   * @return dexterity mod
   */
  public int getDexMod()
  {
    return abilityMods.get(DEX);
  }

  /**
   * Returns the Ability Score for CONSTITUTION.
   * 
   * @return constitution score
   */
  public int getCon()
  {
    return abilityScores.get(CON);
  }

  /**
   * Returns the Ability Modifier for CONSTITUTION.
   * 
   * @return constitution mod
   */
  public int getConMod()
  {
    return abilityMods.get(CON);
  }

  /**
   * Returns the Ability Score for INTELLIGENCE.
   * 
   * @return intelligence score
   */
  public int getInt()
  {
    return abilityScores.get(INT);
  }

  /**
   * Returns the Ability Mod for INTELLIGENCE.
   * 
   * @return intelligence mod
   */
  public int getIntMod()
  {
    return abilityMods.get(INT);
  }

  /**
   * Returns the Ability Score for WISDOM.
   * 
   * @return wisdom score
   */
  public int getWis()
  {
    return abilityScores.get(WIS);
  }

  /**
   * Returns the Ability Modifier for WISDOM.
   * 
   * @return wisdom mod
   */
  public int getWisMod()
  {
    return abilityMods.get(WIS);
  }

  /**
   * Returns the Ability Score for CHARISMA.
   * 
   * @return charisma score
   */
  public int getCha()
  {
    return abilityScores.get(CHA);
  }

  /**
   * Returns the Ability Modifier for CHARISMA.
   * 
   * @return charisma mod
   */
  public int getChaMod()
  {
    return abilityMods.get(CHA);
  }
}
