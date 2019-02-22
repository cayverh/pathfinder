package application;

import java.util.HashMap;
import java.util.LinkedHashMap;

import base.Character;
import base.Generator;

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
    
    int age = 0;
    int charLevel;

    

    HashMap<String, Integer> abilityScores = new LinkedHashMap<String, Integer>(6);
    
    /*Generator.genAbilityScores(abilityScores);
    System.out.println(abilityScores.isEmpty());*/
    
    //c.genAbilityMods();
    
    Character c = new Character(player, charName, gend, alignment, charRace,
        charClass, hairColor, eyeColor, age, 1);

    System.out.println(c.getGeneralCharInfo());

    c.setAbilityScoreMod("Dex");

    System.out.println(c.getAbilityInfo());
  }
}
