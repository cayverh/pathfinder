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
import base.Classification;
import base.Generator;
import base.Race;

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
  JButton submitButton = new JButton("SUBMIT");

  String playerName;
  String charName;
  Race race;
  Classification charClass;
  String alignment;
  String diety;
  String homeland;
  String size;
  String gender;
  String height;
  String weight;
  int age;
  String hairColor;
  String eyeColor;

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

    playerName = "";
    charName = "";
    race = null;
    charClass = null;
    alignment = "";
    diety = "";
    homeland = "";
    size = "";
    gender = "";
    height = "";
    weight = "";
    age = 0;
    hairColor = "";
    eyeColor = "";

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

    submitButton.addActionListener(this);

    add(submitButton, BorderLayout.SOUTH);

    add(buttonPane, BorderLayout.EAST);
  }

  /**
   * 
   * @param ae
   */
  @Override
  public void actionPerformed(ActionEvent ae)
  {
    int random;

    // Randomly select a Race if the Randomize Race button is pressed.
    if (ae.getActionCommand().equals(randomRaceButton.getText()))
    {
      // Reset the fields that rely on Race
      heightField.setText("");
      weightField.setText("");
      ageField.setText("");
      
      race = Generator.genRace("");
      for (int i = 0; i < raceField.getItemCount(); i++)
      {
        if (race.toString().equals(raceField.getItemAt(i).toString()))
        {
          raceField.setSelectedIndex(i);
          break;
        }
      }
    }
    
    // Randomly select a Class if the Randomize Class button is pressed.
    if (ae.getActionCommand().equals(randomClassButton.getText()))
    {
      // Reset the fields the rely on Class
      ageField.setText("");
      
      charClass = Generator.genClass("", as.getAbilityMods(), 1);
      
      for (int i = 0; i < classField.getItemCount(); i++)
      {
        if (charClass.toString().equals(classField.getItemAt(i).toString()))
        {
          classField.setSelectedIndex(i);
          break;
        }
      }
    }

    // Randomly select an alignment if the Randomize Alignment button is pressed.
    if (ae.getActionCommand().equals(randomAlignButton.getText()))
    {
      random = new Random().nextInt(alignmentField.getItemCount());
      alignmentField.setSelectedIndex(random);
    }

    // Randomly select a gender if the Randomize Gender button is pressed.
    if (ae.getActionCommand().equals(randomGenderButton.getText()))
    {
      // Reset the fields that rely on gender
      heightField.setText("");
      weightField.setText("");
      
      random = new Random().nextInt(genderField.getItemCount());
      genderField.setSelectedIndex(random);
      gender = genderField.getItemAt(random);
    }
    
    // Randomly select an age if the Randomize Age button is pressed.
    if (ae.getActionCommand().equals(randomAgeButton.getText()))
    {
      if (raceField.getSelectedIndex() != -1 && classField.getSelectedIndex() != -1)
      {
        race.setAge(charClass.toString());
        age = race.getAge();
        ageField.setText(age + " years old");
      }
      else
      {
        JOptionPane.showMessageDialog(new JFrame(),
            "Please select a Race and Class.");
      }
    }
    
    // Randomly select a height if the Randomize Height button is pressed.
    if (ae.getActionCommand().equals(randomHeightButton.getText()))
    {
      if (raceField.getSelectedIndex() != -1 && genderField.getSelectedIndex() != -1)
      {
        race.setHeight(gender);
        height = race.getHeight();
        heightField.setText(height);
      }
      else
      {
        JOptionPane.showMessageDialog(new JFrame(),
            "Please select a Race and Gender.");
      }
    }
    
    // Randomly select a Weight if the Randomize Weight button is pressed.
    if (ae.getActionCommand().equals(randomWeightButton.getText()))
    {
      if (raceField.getSelectedIndex() != -1 && genderField.getSelectedIndex() != -1)
      {
        race.setWeight(gender);
        weight = race.getWeight();
        weightField.setText(weight);
      }
      else
      {
        JOptionPane.showMessageDialog(new JFrame(),
            "Please select a Race and Gender.");
      }
    }
  }
}
