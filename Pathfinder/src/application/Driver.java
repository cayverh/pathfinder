package application;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

import base.Character;
import base.Classification;
import base.Generator;
import base.Race;

public class Driver
{
  public static void main(String[] args)
  {
    String player = "";
    String charName = "";
    String gender = "";
    String alignment = "";

    String charRace = "";
    String charClass = "";

    String diety = "";
    String homeland = "";

    String hairColor = "";
    String eyeColor = "";

    int age = 0;
    int charLevel = 1;

    Scanner user = new Scanner(System.in);
    String input = "";
    int reponse = 0;

    do
    {
      System.out.println("Would you like to create a new character (\"C\") or cancel (\"X\")?");
      input = user.nextLine();
    }
    while (!input.equals("C") && !input.equals("U") && !input.equals("X"));

    System.out.println(
        "\n***You have entered 'Character Creator' mode. You may quit at any time by entering (\"X\").***\n");

    boolean valid = false;

    if (input.equals("C"))
    {
      do
      {
        System.out.print("What is your name? (Press ENTER to skip.)\n");
        player = user.nextLine();

        valid = checkStringInput(player);
      }
      while (!valid);

      do
      {
        System.out.print(
            "What gender would you like your character to be? (Press ENTER for a random gender.)\n\tNon-Binary\n\tFemale\n\tMale\n");
        gender = user.nextLine();

        valid = checkStringInput(gender);
      }
      while (!valid);

      do
      {
        System.out.printf(
            "What race would you like your character to be? (Press ENTER for a random race.)\n"
                + Race.getAllRaces());
        charRace = user.nextLine();

        valid = checkStringInput(charRace);
      }
      while (!valid);

      do
      {
        System.out
            .print("What would you like your character's name to be? (Press ENTER to skip.)\n");
        charName = user.nextLine();

        valid = checkStringInput(charName);
      }
      while (!valid);

      do
      {
        System.out.printf(
            "What class would you like your character to be? (Press ENTER for a random race.)\n"
                + Classification.getAllClasses());
        charClass = user.nextLine();

        valid = checkStringInput(charClass);
      }
      while (!valid);

      do
      {
        System.out.print(
            "What would you like your character's alignment to be? (Press ENTER to skip.)\n");
        alignment = user.nextLine();

        valid = checkStringInput(alignment);
      }
      while (!valid);

      do
      {
        System.out
            .print("What would you like your character's homeland to be? (Press ENTER to skip.)\n");
        homeland = user.nextLine();

        valid = checkStringInput(homeland);
      }
      while (!valid);

      do
      {
        System.out
            .print("What would you like your character's diety to be? (Press ENTER to skip.)\n");
        diety = user.nextLine();

        valid = checkStringInput(diety);
      }
      while (!valid);

      do
      {
        System.out.print(
            "What would you like your character's age to be? (Press ENTER for a random age.)\n");
        input = user.nextLine();

        try
        {
          age = Integer.parseInt(input);
          valid = true;
          System.out.println();
        }
        catch (Exception e)
        {
          if (input.equals("X"))
            System.exit(0);
          else if (input.equals(""))
          {
            valid = true;
            System.out.println();
          }
          else
          {
            System.out.print("Invalid Input! ");
            valid = false;
          }
        }
      }
      while (!valid);

      do
      {
        System.out.print(
            "What would you like your character's eye color to be? (Press ENTER to skip.)\n");
        eyeColor = user.nextLine();

        valid = checkStringInput(eyeColor);
      }
      while (!valid);

      do
      {
        System.out.print(
            "What would you like your character's hair color to be? (Press ENTER to skip.)\n");
        hairColor = user.nextLine();

        valid = checkStringInput(hairColor);
      }
      while (!valid);
    }

    /*Character c = new Character(player, charName, gender, alignment, charRace, charClass, hairColor,
        eyeColor, age, diety, homeland, charLevel);

    //System.out.print(c.getGeneralCharInfo());

    do
    {
      System.out.print(
          "These are your character's abilities and ability modifiers. (Press \"R\" to re-roll or ENTER to accept.)\n");
      System.out.printf("%s", c.getAbilityInfo());
      
      input = user.nextLine();

      if (input.equals("R"))
      {
        c.genAbilityScores();
        c.genAbilityMods();
        System.out.println();
      }
    }
    while (input.equals("R"));
    
    
    
     
     
     c.setAbilityScoreMod("Dex");
     
     System.out.println(c.getAbilityInfo());*/
     
  }

  public static boolean checkStringInput(String input)
  {
    if (input.equals("X"))
      System.exit(0);
    else if (!input.matches("[a-zA-Z ]*[\\-]*[a-zA-Z ]*"))
    {
      System.out.print("Invalid Input! ");
    }
    else
    {
      System.out.println();
      return true;
    }

    return false;
  }
}
