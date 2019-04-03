package application;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;

import abilities.AbilityScores;
import base.*;
import base.Character;

public class CharacterPane extends JPanel implements ActionListener
{
  Border border;

  JTextField playerNameField;
  JTextField charNameField;
  JTextField dietyField;
  JTextField homelandField;
  JTextField sizeField;
  JTextField heightField;
  JTextField weightField;
  JTextField ageField;
  JTextField hairColorField;
  JTextField eyeColorField;

  JComboBox<String> raceField;
  JComboBox<String> classField;
  JComboBox<String> alignmentField;
  JComboBox<String> genderField;

  JButton randomRaceButton = new JButton("Randomize Race!");
  JButton randomClassButton = new JButton("Randomize Class!");
  JButton randomAlignButton = new JButton("Randomize Alignment!");
  JButton randomGenderButton = new JButton("Randomize Gender!");
  JButton randomHeightButton = new JButton("Randomize Height!");
  JButton randomWeightButton = new JButton("Randomize Weight!");
  JButton randomAgeButton = new JButton("Randomize Age!");
  JButton randomizeAllButton = new JButton("Randomize All!");
  JButton submitButton = new JButton("Submit Character Profile!");

  Character character;
  /*
   * String playerName; String charName; Race race; Classification charClass; String alignment;
   * String diety; String homeland; String size; String gender; String height; String weight; int
   * age; String hairColor; String eyeColor;
   */

  AbilityScores as;

  /**
   * 
   */
  public CharacterPane(AbilityScores as)
  {
    this.as = as;
    this.setLayout(new BorderLayout());

    border =
        new CompoundBorder(new TitledBorder("Character Profile"), new EmptyBorder(12, 0, 0, 0));

    setBorder(border);

    character = new Character("", "", "", "", "", "", "", "", 0, "", "", 1, as);

    /*
     * playerName = ""; charName = ""; race = null; charClass = null; alignment = ""; diety = "";
     * homeland = ""; size = ""; gender = ""; height = ""; weight = ""; age = 0; hairColor = "";
     * eyeColor = "";
     */

    constructLabels();
    constructFields();
    constructButtons();
  }

  /**
   * 
   */
  public void constructLabels()
  {
    JPanel labelPane = new JPanel();
    GridLayout layout = new GridLayout(14, 1);

    labelPane.setLayout(layout);

    JLabel playerNameLabel = new JLabel("Player Name: ");
    JLabel charNameLabel = new JLabel("Character Name: ");
    JLabel raceLabel = new JLabel("Race: ");
    JLabel classLabel = new JLabel("Class: ");
    JLabel alignLabel = new JLabel("Alignment: ");
    JLabel dietyLabel = new JLabel("Diety: ");
    JLabel homeLabel = new JLabel("Homeland: ");
    JLabel sizeLabel = new JLabel("Size: ");
    JLabel genderLabel = new JLabel("Gender: ");
    JLabel heightLabel = new JLabel("Height: ");
    JLabel weightLabel = new JLabel("Weight: ");
    JLabel ageLabel = new JLabel("Age: ");
    JLabel hairLabel = new JLabel("Hair Color: ");
    JLabel eyeLabel = new JLabel("Eye Color: ");

    /*
     * int x = 10; int y = 10; int w = 200; int h = 50;
     */

    JLabel[] labels =
        {playerNameLabel, charNameLabel, raceLabel, classLabel, alignLabel, dietyLabel, homeLabel,
            sizeLabel, genderLabel, heightLabel, weightLabel, ageLabel, hairLabel, eyeLabel};

    for (JLabel l : labels)
    {
      l.setFont(new Font("Calibri", Font.BOLD, 16));
      // l.setBounds(x, y, w, h);
      l.setHorizontalAlignment(JLabel.RIGHT);
      labelPane.add(l);
      // y += 35;
    }

    add(labelPane, BorderLayout.WEST);
  }

  /**
   * Construct the user-input fields.
   */
  public void constructFields()
  {
    String[] races = Race.getRaces();
    String[] classes = Classification.getClasses();
    String[] alignments =
        new String[] {"Lawful Good", "Lawful Neutral", "Lawful Evil", "Neutral Good", "Neutral",
            "Neutral Evil", "Chaotic Good", "Chaotic Neutral", "Chaotic Evil"};
    String[] genders = new String[] {"Non-Binary", "Female", "Male"};

    JPanel fieldPane = new JPanel();
    GridLayout layout = new GridLayout(14, 1);
    fieldPane.setLayout(layout);

    // Panel for the character's height
    JPanel heightPane = new JPanel();
    GridLayout hl = new GridLayout(1, 2);
    heightPane.setLayout(hl);

    // Panel for the character's weight
    JPanel weightPane = new JPanel();
    GridLayout wl = new GridLayout(1, 2);
    weightPane.setLayout(wl);

    // Initialize the text fields
    playerNameField = new JTextField();
    charNameField = new JTextField();
    dietyField = new JTextField();
    homelandField = new JTextField();
    sizeField = new JTextField();
    ageField = new JTextField();
    hairColorField = new JTextField();
    eyeColorField = new JTextField();

    heightField = new JTextField();
    heightPane.add(heightField);

    weightField = new JTextField();
    weightPane.add(weightField);

    // Initialize the combo boxes
    raceField = new JComboBox<String>(races);
    classField = new JComboBox<String>(classes);
    alignmentField = new JComboBox<String>(alignments);
    genderField = new JComboBox<String>(genders);

    // Set the "default" selected item for the combo boxes to nothing
    raceField.setSelectedIndex(-1);
    classField.setSelectedIndex(-1);
    alignmentField.setSelectedIndex(-1);
    genderField.setSelectedIndex(-1);

    raceField.addActionListener(this);
    classField.addActionListener(this);
    alignmentField.addActionListener(this);
    genderField.addActionListener(this);

    // Set size field as non-editable
    sizeField.setEditable(false);

    // Add the fields to the pane
    fieldPane.add(playerNameField);
    fieldPane.add(charNameField);
    fieldPane.add(raceField);
    fieldPane.add(classField);
    fieldPane.add(alignmentField);
    fieldPane.add(dietyField);
    fieldPane.add(homelandField);
    fieldPane.add(sizeField);
    fieldPane.add(genderField);
    fieldPane.add(heightPane);
    fieldPane.add(weightPane);
    fieldPane.add(ageField);
    fieldPane.add(hairColorField);
    fieldPane.add(eyeColorField);

    // Add the pane of fields to the content pane
    add(fieldPane);
  }

  /**
   * 
   */
  public void constructButtons()
  {
    JPanel buttonPane = new JPanel();
    GridLayout layout = new GridLayout(14, 1);
    buttonPane.setLayout(layout);

    buttonPane.add(new JLabel());
    buttonPane.add(new JLabel());
    buttonPane.add(randomRaceButton);
    buttonPane.add(randomClassButton);
    buttonPane.add(randomAlignButton);
    buttonPane.add(new JLabel());
    buttonPane.add(new JLabel());
    buttonPane.add(new JLabel());
    buttonPane.add(randomGenderButton);
    buttonPane.add(randomHeightButton);
    buttonPane.add(randomWeightButton);
    buttonPane.add(randomAgeButton);
    buttonPane.add(new JLabel());
    buttonPane.add(new JLabel());

    randomRaceButton.addActionListener(this);
    randomClassButton.addActionListener(this);
    randomAlignButton.addActionListener(this);
    randomGenderButton.addActionListener(this);
    randomHeightButton.addActionListener(this);
    randomWeightButton.addActionListener(this);
    randomAgeButton.addActionListener(this);

    randomizeAllButton.addActionListener(this);
    submitButton.addActionListener(this);
    
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(1,2));
    
    buttonPanel.add(randomizeAllButton);
    buttonPanel.add(submitButton);

    add(buttonPanel, BorderLayout.SOUTH);
    //add(submitButton, BorderLayout.SOUTH);

    add(buttonPane, BorderLayout.EAST);
  }

  /**
   * 
   * @param ae
   */
  @Override
  public void actionPerformed(ActionEvent ae)
  {
    /********************************************************************************************************/
    /*
     * ACTIONS PERFORMED BY BUTTONS.
     */
    /********************************************************************************************************/

    // Randomly select a Race if the Randomize Race button is pressed.
    if (ae.getActionCommand().equals(randomRaceButton.getText()))
    {
      randomizeRace();
    }

    // Randomly select a Class if the Randomize Class button is pressed.
    if (ae.getActionCommand().equals(randomClassButton.getText()))
    {
      randomizeClass();
    }

    // Randomly select an alignment if the Randomize Alignment button is pressed.
    if (ae.getActionCommand().equals(randomAlignButton.getText()))
    {
      randomizeAlignment();
    }

    // Randomly select a gender if the Randomize Gender button is pressed.
    if (ae.getActionCommand().equals(randomGenderButton.getText()))
    {
      randomizeGender();
    }

    // Randomly select an age if the Randomize Age button is pressed.
    if (ae.getActionCommand().equals(randomAgeButton.getText()))
    {
      randomizeAge();
    }

    // Randomly select a height if the Randomize Height button is pressed.
    if (ae.getActionCommand().equals(randomHeightButton.getText()))
    {
      randomizeHeight();
    }

    // Randomly select a Weight if the Randomize Weight button is pressed.
    if (ae.getActionCommand().equals(randomWeightButton.getText()))
    {
      randomizeWeight();
    }
    
    if (ae.getActionCommand().equals(randomizeAllButton.getText()))
    {
      randomizeRace();
      randomizeClass();
      randomizeAlignment();
      randomizeGender();
      randomizeAge();
      randomizeHeight();
      randomizeWeight();
    }
    
    if (ae.getActionCommand().equals(submitButton.getText()))
    {
      // Disable all buttons
      submitButton.setEnabled(false);
      randomizeAllButton.setEnabled(false);
      randomRaceButton.setEnabled(false);
      randomClassButton.setEnabled(false);
      randomAlignButton.setEnabled(false);
      randomGenderButton.setEnabled(false);
      randomHeightButton.setEnabled(false);
      randomWeightButton.setEnabled(false);
      randomAgeButton.setEnabled(false);
      
      // Disable all input fields
      playerNameField.setEditable(false);
      charNameField.setEditable(false);
      raceField.setEnabled(false);
      classField.setEnabled(false);
      alignmentField.setEnabled(false);
      dietyField.setEditable(false);
      homelandField.setEditable(false);
      genderField.setEnabled(false);
      ageField.setEditable(false);
      heightField.setEditable(false);
      weightField.setEditable(false);
      ageField.setEditable(false);
      hairColorField.setEditable(false);
      eyeColorField.setEditable(false);
      
      character.setPlayerName(playerNameField.getText());
      character.setCharName(charNameField.getText());
      character.setDiety(dietyField.getText());
      character.setHomeland(homelandField.getText());
      character.setHairColor(hairColorField.getText());
      character.setEyeColor(eyeColorField.getText());
      
      JOptionPane.showMessageDialog(new JFrame(), character.getGeneralCharInfo());
    }

    /********************************************************************************************************/
    /*
     * ACTIONS PERFORMED BY DROPBOXES.
     */
    /********************************************************************************************************/
    // Sets the race to the Race selected.
    if (ae.getSource().equals(raceField))
    {
      heightField.setText("");
      weightField.setText("");
      ageField.setText("");

      /*
       * race = Generator.genRace(raceField.getSelectedItem().toString()); size = race.getSize();
       * 
       * sizeField.setText(size);
       */

      character.setRace(raceField.getSelectedItem().toString());
      sizeField.setText(character.getSize());
    }

    // Sets the class to the Class selected.
    if (ae.getSource().equals(classField))
    {
      ageField.setText("");

      /*
       * charClass = Generator.genClass(classField.getSelectedItem().toString(),
       * as.getAbilityMods(), 1);
       */
      character.setClass(classField.getSelectedItem().toString());
    }

    // Sets the alignment to the Alignment selected.
    if (ae.getSource().equals(alignmentField))
    {
      // alignment = alignmentField.getSelectedItem().toString();

      character.setAlignment(alignmentField.getSelectedItem().toString());
    }

    // Sets the gender to the Gender selected.
    if (ae.getSource().equals(genderField))
    {
      // Reset the fields that rely on gender
      heightField.setText("");
      weightField.setText("");

      // gender = genderField.getSelectedItem().toString();

      character.setGender(genderField.getSelectedItem().toString());
    }
  }
  
  
  /********************************************************************************************************/
  /*
   * HELPER METHODS FOR RANDOMIZING CHARACTER ATTRIBUTES.
   */
  /********************************************************************************************************/

  public void randomizeRace()
  {
    // Reset the fields that rely on Race
    heightField.setText("");
    weightField.setText("");
    ageField.setText("");

    /*
     * race = Generator.genRace(""); size = race.getSize(); for (int i = 0; i <
     * raceField.getItemCount(); i++) { if
     * (race.toString().equals(raceField.getItemAt(i).toString())) { raceField.setSelectedIndex(i);
     * sizeField.setText(size); break; } }
     */

    character.genNewRace();
    raceField.setSelectedItem(character.getRace().toString());
    sizeField.setText(character.getSize());
    /*
     * for (int i = 0; i < raceField.getItemCount(); i++) { if
     * (character.getRace().toString().equals(raceField.getItemAt(i).toString())) {
     * raceField.setSelectedIndex(i); sizeField.setText(character.getSize());
     * System.out.println(character.getRace()); break; } }
     */
  }

  public void randomizeClass()
  {
    // Reset the fields the rely on Class
    ageField.setText("");

    /*
     * charClass = Generator.genClass("", as.getAbilityMods(), 1);
     * 
     * for (int i = 0; i < classField.getItemCount(); i++) { if
     * (charClass.toString().equals(classField.getItemAt(i).toString())) {
     * classField.setSelectedIndex(i); break; } }
     */

    character.genNewClass();

    for (int i = 0; i < classField.getItemCount(); i++)
    {
      if (character.getClassification().toString().equals(classField.getItemAt(i).toString()))
      {
        classField.setSelectedIndex(i);
        break;
      }
    }
  }
  
  public void randomizeAlignment()
  {
    int random = new Random().nextInt(alignmentField.getItemCount());
    alignmentField.setSelectedIndex(random);

    character.setAlignment(alignmentField.getItemAt(random));
  }

  public void randomizeGender()
  {
    // Reset the fields that rely on gender
    heightField.setText("");
    weightField.setText("");

    int random = new Random().nextInt(genderField.getItemCount());
    /* gender = genderField.getItemAt(random); */
    character.setGender(genderField.getItemAt(random));
    genderField.setSelectedIndex(random);
  }

  public void randomizeAge()
  {
    if (raceField.getSelectedIndex() != -1 && classField.getSelectedIndex() != -1)
    {
      /*
       * race.setAge(charClass.toString()); age = race.getAge(); ageField.setText(age +
       * " years old");
       */

      character.getRace().setAge(character.getClassification().toString());
      ageField.setText(character.getAge() + " years old");

    }
    else
    {
      JOptionPane.showMessageDialog(new JFrame(), "Please select a Race and Class.");
    }
  }

  public void randomizeHeight()
  {
    if (raceField.getSelectedIndex() != -1 && genderField.getSelectedIndex() != -1)
    {
      /*
       * race.setHeight(gender); height = race.getHeight(); heightField.setText(height);
       */

      character.getRace().setHeight(character.getGender());
      heightField.setText(character.getHeight());
    }
    else
    {
      JOptionPane.showMessageDialog(new JFrame(), "Please select a Race and Gender.");
    }
  }

  public void randomizeWeight()
  {
    if (raceField.getSelectedIndex() != -1 && genderField.getSelectedIndex() != -1)
    {
      /*
       * race.setWeight(gender); weight = race.getWeight(); weightField.setText(weight);
       */

      character.getRace().setWeight(character.getGender());
      weightField.setText(character.getWeight());
    }
    else
    {
      JOptionPane.showMessageDialog(new JFrame(), "Please select a Race and Gender.");
    }
  }
}
