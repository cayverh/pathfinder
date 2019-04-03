package application;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.border.*;

import abilities.*;

public class AbilitiesPane extends JPanel implements Abilities, ActionListener
{
  public final String REROLL = "Re-Roll Scores!";
  public static final String SUBMIT = "Submit Scores!";

  static boolean scoresSubmitted;
  JScrollPane scrollPane;
  public static JButton rerollButton;
  public static JButton submitButton;
  JTable table;
  String[] columns = {"Ability", "Ability Name", "Ability Score", "Ability Modifier"};

  static AbilityScores as;

  HashMap<String, Integer> scores;
  HashMap<String, Integer> mods;

  public AbilitiesPane()
  {
    this.setLayout(new BorderLayout());

    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(2, 1));

    as = new AbilityScores();
    scores = as.getAbilityScores();
    mods = as.getAbilityMods();
    scoresSubmitted = false;

    setBorder(new CompoundBorder(new TitledBorder("Abilities"), new EmptyBorder(0, 0, 0, 0)));

    Object[][] data = {{"STR", "Strength", scores.get(STR), mods.get(STR)},
        {"DEX", "Dexterity", scores.get(DEX), mods.get(DEX)},
        {"CON", "Constitution", scores.get(CON), mods.get(CON)},
        {"INT", "Intelligence", scores.get(INT), mods.get(INT)},
        {"WIS", "Wisdom", scores.get(WIS), mods.get(WIS)},
        {"CHA", "Charisma", scores.get(CHA), mods.get(CHA)}};

    table = new JTable(data, columns);
    table.setPreferredScrollableViewportSize(new Dimension(500, 100));
    table.setFillsViewportHeight(true);

    // Create the scroll pane and add the table to it.
    scrollPane = new JScrollPane(table);

    rerollButton = new JButton(REROLL);
    rerollButton.addActionListener(this);

    submitButton = new JButton(SUBMIT);
    submitButton.addActionListener(this);

    buttonPanel.add(rerollButton);
    buttonPanel.add(submitButton);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(2, 1));

    panel.add(scrollPane);
    panel.add(buttonPanel);

    // Add the scroll pane to this panel.
    add(panel, BorderLayout.PAGE_START);
  }

  @Override
  public void actionPerformed(ActionEvent ae)
  {
    if (ae.getActionCommand().equals(REROLL))
    {
      as = new AbilityScores();
      scores = as.getAbilityScores();
      mods = as.getAbilityMods();

      Object[][] data = {{"STR", "Strength", scores.get(STR), mods.get(STR)},
          {"DEX", "Dexterity", scores.get(DEX), mods.get(DEX)},
          {"CON", "Constitution", scores.get(CON), mods.get(CON)},
          {"INT", "Intelligence", scores.get(INT), mods.get(INT)},
          {"WIS", "Wisdom", scores.get(WIS), mods.get(WIS)},
          {"CHA", "Charisma", scores.get(CHA), mods.get(CHA)}};

      for (int i = 0; i < 6; i++)
      {
        for (int j = 2; j < 4; j++)
        {
          table.getModel().setValueAt(data[i][j], i, j);
        }
      }
    }

    if (ae.getActionCommand().equals(SUBMIT))
    {
      rerollButton.setEnabled(false);
      submitButton.setEnabled(false);
      scoresSubmitted = true;
    }
  }

  public static AbilityScores getAbilityScores()
  {
    return as;
  }

  public static boolean scoresSubmitted()
  {
    return scoresSubmitted;
  }
}
