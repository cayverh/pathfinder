package application;

import base.Character;
import classes.*;

public class Driver
{
  public static void main(String[] args)
  {
    Character c = new Character("Cayleigh", "Rukoa", "Female", "Chaotic Good", "Dwarf", "Barbarian");
    
    c.genAbilityScores();
    c.genAbilityMods();

    System.out.printf("Str: %s, Mod: %s\n", c.getStr(), c.getStrMod());
    System.out.printf("Dex: %s, Mod: %s\n", c.getDex(), c.getDexMod());
    System.out.printf("Con: %s, Mod: %s\n", c.getCon(), c.getConMod());
    System.out.printf("Int: %s, Mod: %s\n", c.getInt(), c.getIntMod());
    System.out.printf("Wis: %s, Mod: %s\n", c.getWis(), c.getWisMod());
    System.out.printf("Cha: %s, Mod: %s\n", c.getCha(), c.getChaMod());
  }
}
