package application;

import base.Character;
import base.Classification;
import base.Generator;
import base.Race;
import classes.*;

public class Driver
{
  public static void main(String[] args)
  {
    String charName;
    String alignment;
    String player;
    int charLevel;
    String diety;
    String homeland;

    String hairColor;
    String eyeColor;

    String charRace;
    String charClass;
    
    Character c = new Character("Cayleigh", "Amyn", "", "Chaotic Good", "Half-Elf", "Cleric");
    
    c.genAbilityScores();
    c.genAbilityMods();
    
    System.out.println(c.getGeneralCharInfo());
    
    c.applyAbilityScoreMod("Dex");

    System.out.println(c.getAbilityInfo());
  }
}
