package application;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class StatsPane extends JPanel
{
  public StatsPane()
  {
    this.setLayout(new BorderLayout());
    setBorder(new CompoundBorder(new TitledBorder("Character Stats"), new EmptyBorder(0, 0, 0, 0)));
    
    constructLabels();
  }

  public void constructLabels()
  {
    JPanel labelPane = new JPanel();
    GridLayout layout = new GridLayout(12, 1);

    labelPane.setLayout(layout);

    JLabel blankLabel1 = new JLabel("");
    JLabel blankLabel2 = new JLabel("");
    JLabel blankLabel3 = new JLabel("");
    JLabel abilityPointsLabel = new JLabel("Ability Points to Spend: ");
    JLabel hitPointsLabel = new JLabel("Hit Points: ");
    JLabel wealthLabel = new JLabel("Wealth: ");
    JLabel levelLabel = new JLabel("Level: ");
    JLabel babLabel = new JLabel("Base Attack Bonus: ");
    JLabel fsLabel = new JLabel("Fortitude Save: ");
    JLabel rsLabel = new JLabel("Reflex Save: ");
    JLabel wsLabel = new JLabel("Will Save: ");
    JLabel skillPointsLabel = new JLabel("Skill Points per Level: ");

    JLabel[] labels = {abilityPointsLabel, blankLabel1, hitPointsLabel, levelLabel, wealthLabel,
        blankLabel2, babLabel, fsLabel, rsLabel, wsLabel, blankLabel3, skillPointsLabel};

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
}
