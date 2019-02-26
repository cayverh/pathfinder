package application;

import java.awt.*;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.border.*;

import abilities.*;

public class AbilitiesPane extends JPanel implements Abilities {
	
    public AbilitiesPane(HashMap<String, Integer> abilityScores, HashMap<String, Integer> abilityMods) {
    	this.setLayout(new BorderLayout());
    	
    	String[] columns = {"Ability", "Ability Score", "Ability Modifier"};
    	
        setBorder(new CompoundBorder(new TitledBorder("Abilities"), new EmptyBorder(12, 0, 0, 0)));

        Object[][] data = {
        		{"STR (Strength)", abilityScores.get(STR), abilityMods.get(STR)},
        		{"DEX (Dexterity)", abilityScores.get(DEX), abilityMods.get(DEX)},
        		{"CON (Constitution)", abilityScores.get(CON), abilityMods.get(CON)},
        		{"INT (Intelligence)", abilityScores.get(INT), abilityMods.get(INT)},
        		{"WIS (Wisdom)", abilityScores.get(WIS), abilityMods.get(WIS)},
        		{"CHA (Charisma)", abilityScores.get(CHA), abilityMods.get(CHA)}
        };
        
        final JTable table = new JTable(data, columns);
        table.setPreferredScrollableViewportSize(new Dimension(500, 100));
        table.setFillsViewportHeight(true);
 
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
 
        JButton reroll = new JButton("Re-Roll Scores");
        
        //Add the scroll pane to this panel.
        add(scrollPane, BorderLayout.PAGE_START);
        add(reroll, BorderLayout.CENTER);
    }
}
