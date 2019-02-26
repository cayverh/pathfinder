package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import javax.swing.*;

import app.JApplication;
import base.Generator;
import io.ResourceFinder;
import resources.Engebrechtre;
import visual.Visualization;
import visual.VisualizationView;
import javax.swing.UIManager.*;

import abilities.*;

public class PathfinderApp implements Runnable, WindowListener {
	private static final Font FONT_HEADING = new Font("Onyx", Font.PLAIN, 25);
	private static JPanel contentPane;
	private JFrame mainWindow;
	private static Engebrechtre font;
	private int height, width;
	private AbilitiesPane abilitiesPane;

	public PathfinderApp(int width, int height) throws FontFormatException, IOException {
		font = new Engebrechtre();
		
		
		this.width = width;
		this.height = height;
	}

	public static void main(String args[]) throws Exception {
		SwingUtilities.invokeAndWait(new PathfinderApp(450, 450));
	}

	public void constructMainWindow() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look and feel.
		}

		// TODO ImageIcon icon = null;
		// TODO icon = new ImageIcon(icondata);

		mainWindow = new JFrame("Pathfinder Character Creator");

		contentPane = (JPanel) mainWindow.getContentPane();

		// TODO mainWindow.setIconImage(icon.getImage());

		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setSize(800, 1000);
		mainWindow.addWindowListener(this);
	}

	public void init() {
		contentPane.setLayout(new GridLayout(0,1));

		
		HashMap<String, Integer> abilityScores = new AbilityScores().getAbilityScores();
		HashMap<String, Integer> abilityMods = new AbilityMods(abilityScores).getAbilityMods();
		
		contentPane.add((abilitiesPane = new AbilitiesPane(abilityScores, abilityMods)));

		
		contentPane.setVisible(true);
	}

	public void constructLabels(GridBagConstraints c) {
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

		JLabel[] labels = { playerNameLabel, charNameLabel, raceLabel, classLabel, alignLabel, dietyLabel, homeLabel,
				sizeLabel, genderLabel, heightLabel, weightLabel, ageLabel, hairLabel, eyeLabel};
		
		for (JLabel l : labels)
		{
			l.setFont(new Font("Calibri", Font.BOLD, 16));
		}
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.1;
		c.gridx = 10;
		c.gridy = 10;
		
		
		playerNameLabel.setBounds(10, 10, 100, 50);
		//contentPane.add(playerNameLabel, c);
	}

	@Override
	public void run() {
		constructMainWindow();
		init();
		mainWindow.setVisible(true);
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}
