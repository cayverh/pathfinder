package application;

import base.Character;
import classes.*;

public class Driver
{
  public static void main(String[] args)
  {
    Character c = new Character("Cayleigh", "Amyn", "Female", "Chaotic Good", "Half-Elf", "Cleric");
    
    c.genAbilityScores();
    c.genAbilityMods();
    
    System.out.println(c.getGeneralCharInfo());
    
    c.applyAbilityScoreMod("Dex");

    System.out.println(c.getAbilityInfo());
  }
}
