package application;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.NumberFormatter;

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
  JFormattedTextField heightFtField;
  JFormattedTextField heightInField;
  JFormattedTextField weightField;
  JFormattedTextField ageField;
  JTextField hairColorField;
  JTextField eyeColorField;

  JComboBox<String> raceField;
  JComboBox<String> classField;
  JComboBox<String> alignmentField;
  JComboBox<String> genderField;
  JComboBox<String> languageField;

  JButton randomRaceButton = new JButton("Randomize Race!");
  JButton randomClassButton = new JButton("Randomize Class!");
  JButton randomAlignButton = new JButton("Randomize Alignment!");
  JButton randomGenderButton = new JButton("Randomize Gender!");
  JButton randomHeightButton = new JButton("Randomize Height!");
  JButton randomWeightButton = new JButton("Randomize Weight!");
  JButton randomAgeButton = new JButton("Randomize Age!");
  JButton randomLanguageButton = new JButton("Randomize Language to Learn!");
  JButton randomizeAllButton = new JButton("Randomize All!");
  public static JButton submitButton = new JButton("Submit Character Profile!");

  Character character;
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
    GridLayout layout = new GridLayout(15, 1);

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
    JLabel languageLabel = new JLabel("Language to Learn: ");
    JLabel heightLabel = new JLabel("Height: ");
    JLabel weightLabel = new JLabel("Weight: ");
    JLabel ageLabel = new JLabel("Age: ");
    JLabel hairLabel = new JLabel("Hair Color: ");
    JLabel eyeLabel = new JLabel("Eye Color: ");

    /*
     * int x = 10; int y = 10; int w = 200; int h = 50;
     */

    JLabel[] labels = {playerNameLabel, charNameLabel, raceLabel, classLabel, alignLabel,
        dietyLabel, homeLabel, sizeLabel, genderLabel, languageLabel, heightLabel, weightLabel,
        ageLabel, hairLabel, eyeLabel};

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

    NumberFormat format = NumberFormat.getInstance();
    NumberFormatter formatter = new NumberFormatter(format)
    {
      public Object stringToValue(String string) throws ParseException
      {
        if (string == null || string.length() == 0)
        {
          return null;
        }
        return super.stringToValue(string);
      }
    };
    formatter.setValueClass(Integer.class);
    formatter.setMinimum(0);
    formatter.setMaximum(Integer.MAX_VALUE);
    formatter.setAllowsInvalid(false);
    formatter.setCommitsOnValidEdit(true);

    JPanel fieldPane = new JPanel();
    GridLayout layout = new GridLayout(15, 1);
    fieldPane.setLayout(layout);

    // Panel for the character's height
    JPanel heightPane = new JPanel();
    heightPane.setLayout(new GridLayout(1, 2));
    JPanel feetPane = new JPanel();
    feetPane.setLayout(new BorderLayout());
    JPanel inchesPane = new JPanel();
    inchesPane.setLayout(new BorderLayout());

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
    ageField = new JFormattedTextField(formatter);
    hairColorField = new JTextField();
    eyeColorField = new JTextField();

    heightFtField = new JFormattedTextField(formatter);
    feetPane.add(heightFtField, BorderLayout.CENTER);
    feetPane.add(new JLabel(" feet, "), BorderLayout.EAST);
    heightInField = new JFormattedTextField(formatter);
    inchesPane.add(heightInField, BorderLayout.CENTER);
    inchesPane.add(new JLabel(" inches "), BorderLayout.EAST);
    heightPane.add(feetPane);
    heightPane.add(inchesPane);

    weightField = new JFormattedTextField(formatter);
    weightPane.add(weightField);

    // Initialize the combo boxes
    raceField = new JComboBox<String>(races);
    classField = new JComboBox<String>(classes);
    alignmentField = new JComboBox<String>(alignments);
    genderField = new JComboBox<String>(genders);
    languageField = new JComboBox<String>();

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
    fieldPane.add(languageField);
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
    GridLayout layout = new GridLayout(15, 1);
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
    buttonPane.add(randomLanguageButton);
    buttonPane.add(randomHeightButton);
    buttonPane.add(randomWeightButton);
    buttonPane.add(randomAgeButton);
    buttonPane.add(new JLabel());
    buttonPane.add(new JLabel());

    randomRaceButton.addActionListener(this);
    randomClassButton.addActionListener(this);
    randomAlignButton.addActionListener(this);
    randomGenderButton.addActionListener(this);
    randomLanguageButton.addActionListener(this);
    randomHeightButton.addActionListener(this);
    randomWeightButton.addActionListener(this);
    randomAgeButton.addActionListener(this);

    randomizeAllButton.addActionListener(this);
    submitButton.addActionListener(this);

    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(1, 2));

    buttonPanel.add(randomizeAllButton);
    buttonPanel.add(submitButton);

    add(buttonPanel, BorderLayout.SOUTH);
    // add(submitButton, BorderLayout.SOUTH);

    add(buttonPane, BorderLayout.EAST);
  }
  
  /**
   * 
   * @return
   */
  public Character getCharacter()
  {
    return character;
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
      heightFtField.setEditable(false);
      heightInField.setEditable(false);
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

      // JOptionPane.showMessageDialog(new JFrame(), character.getGeneralCharInfo());
    }

    if (ae.getActionCommand().equals(randomLanguageButton.getText()))
    {
      if (raceField.getSelectedIndex() == -1)
      {
        JOptionPane.showMessageDialog(new JFrame(), "Please select a Race.");
      }
    }

    /********************************************************************************************************/
    /*
     * ACTIONS PERFORMED BY DROPBOXES.
     */
    /********************************************************************************************************/
    // Sets the race to the Race selected.
    if (ae.getSource().equals(raceField))
    {
      heightFtField.setText("");
      heightInField.setText("");
      weightField.setText("");
      ageField.setText("");

      character.setRace(raceField.getSelectedItem().toString());
      sizeField.setText(character.getSize());
    }

    // Sets the class to the Class selected.
    if (ae.getSource().equals(classField))
    {
      ageField.setText("");

      character.setClass(classField.getSelectedItem().toString());
    }

    // Sets the alignment to the Alignment selected.
    if (ae.getSource().equals(alignmentField))
    {
      character.setAlignment(alignmentField.getSelectedItem().toString());
    }

    // Sets the gender to the Gender selected.
    if (ae.getSource().equals(genderField))
    {
      // Reset the fields that rely on gender
      heightFtField.setText("");
      heightInField.setText("");
      weightField.setText("");

      character.setGender(genderField.getSelectedItem().toString());
    }
  }
  
  /********************************************************************************************************/
  /*
   * HELPER METHODS FOR RANDOMIZING CHARACTER ATTRIBUTES.
   */
  /********************************************************************************************************/

  public void randomizeAge()
  {
    if (raceField.getSelectedIndex() != -1 && classField.getSelectedIndex() != -1)
    {
      character.getRace().setAge(character.getClassification().toString());
      ageField.setText(character.getAge() + " years old");

    }
    else
    {
      JOptionPane.showMessageDialog(new JFrame(), "Please select a Race and Class.");
    }
  }

  public void randomizeAlignment()
  {
    int random = new Random().nextInt(alignmentField.getItemCount());
    alignmentField.setSelectedIndex(random);

    character.setAlignment(alignmentField.getItemAt(random));
  }

  public void randomizeClass()
  {
    // Reset the fields the rely on Class
    ageField.setText("");

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

  public void randomizeGender()
  {
    // Reset the fields that rely on gender
    heightFtField.setText("");
    heightInField.setText("");
    weightField.setText("");

    int random = new Random().nextInt(genderField.getItemCount());
    character.setGender(genderField.getItemAt(random));
    genderField.setSelectedIndex(random);
  }

  public void randomizeHeight()
  {
    if (raceField.getSelectedIndex() != -1 && genderField.getSelectedIndex() != -1)
    {
      character.getRace().setHeight(character.getGender());
      
      heightFtField.setText(Integer.toString(character.getRace().getFeet()));
      heightInField.setText(Integer.toString(character.getRace().getInches()));
    }
    else
    {
      JOptionPane.showMessageDialog(new JFrame(), "Please select a Race and Gender.");
    }
  }

  public void randomizeRace()
  {
    // Reset the fields that rely on Race
    heightFtField.setText("");
    heightInField.setText("");
    weightField.setText("");
    ageField.setText("");
    languageField.removeAllItems();

    character.genNewRace();
    raceField.setSelectedItem(character.getRace().toString());
    sizeField.setText(character.getSize());

    ArrayList<String> languagesLearn = character.getRace().getLanguagesToLearn();
    for (int i = 0; i < languagesLearn.size(); i++)
    {
      languageField.addItem(languagesLearn.get(i));
    }
  }

  public void randomizeWeight()
  {
    if (raceField.getSelectedIndex() != -1 && genderField.getSelectedIndex() != -1)
    {
      character.getRace().setWeight(character.getGender());
      weightField.setText(character.getWeight());
    }
    else
    {
      JOptionPane.showMessageDialog(new JFrame(), "Please select a Race and Gender.");
    }
  }
}
