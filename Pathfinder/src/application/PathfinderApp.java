package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import javax.swing.*;

import base.Generator;
import resources.Engebrechtre;
import javax.swing.UIManager.*;

import abilities.*;

public class PathfinderApp implements Runnable, WindowListener, ActionListener {
	private static final Font FONT_HEADING = new Font("Onyx", Font.PLAIN, 25);
	private static JPanel contentPane;
	private JFrame mainWindow;
	private static Engebrechtre font;
	private int height, width;
	private AbilitiesPane abilitiesPane;
	private CharacterPane charPane;
	private AbilityScores abilityScores;

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
		
	}

	@Override
	public void run() {
		constructMainWindow();
		JPanel abilitySection = new JPanel();
		abilitySection.setLayout(new GridLayout(1, 0));
		
		contentPane.setLayout(new GridLayout(2,1));

		abilityScores = new AbilityScores();
		
		abilitySection.add((abilitiesPane = new AbilitiesPane()));
		contentPane.add(abilitySection);
		
		AbilitiesPane.submitButton.addActionListener(this);
		
		
		
		contentPane.setVisible(true);
		
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

	@Override
	public void actionPerformed(ActionEvent ae) {
	  if (ae.getActionCommand().equals(AbilitiesPane.SUBMIT))
	  {
	    contentPane.add((charPane = new CharacterPane(abilityScores)));
	  }
	}

}
