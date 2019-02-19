package application;

import base.Character;

public class Driver
{
  public static void main(String[] args)
  {
    String player = "Cayleigh";
    String charName = "Amyn";
    String gend = "";
    String alignment = "";
    
    String charRace = "";
    String charClass = "";
    
    String diety;
    String homeland;
    
    String hairColor = "Dusty Pink";
    String eyeColor = "Brown";
    
    int age = 23;
    int charLevel;

    Character c = new Character(player, charName, gend, alignment, charRace,
        charClass, hairColor, eyeColor, age);

    c.genAbilityScores();
    c.genAbilityMods();

    System.out.println(c.getGeneralCharInfo());

    c.setAbilityScoreMod("Dex");

    // System.out.println(c.getAbilityInfo());
  }
}
