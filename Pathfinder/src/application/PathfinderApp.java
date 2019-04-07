package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import resources.Engebrechtre;
import javax.swing.UIManager.*;

import abilities.*;
import resources.*;

public class PathfinderApp implements Runnable, WindowListener, ActionListener
{
  private static final Font FONT_HEADING = new Font("Onyx", Font.PLAIN, 25);
  private static JPanel contentPane;
  JPanel abilitySection = new JPanel();
  JPanel characterSection = new JPanel();
  protected static JFrame mainWindow;
  private static Engebrechtre font;
  private int height, width;
  private AbilitiesPane abilitiesPane;
  private CharacterPane charPane;
  private SheetPane sheetPane;
  private AbilityScores abilityScores;

  public PathfinderApp(int width, int height) throws FontFormatException, IOException
  {
    //font = new Engebrechtre();

    this.width = width;
    this.height = height;
  }

  public static void main(String args[]) throws Exception
  {
    SwingUtilities.invokeAndWait(new PathfinderApp(450, 450));

  }

  public void constructMainWindow()
  {
    try
    {
      for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
      {
        if ("Nimbus".equals(info.getName()))
        {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    }
    catch (Exception e)
    {
      // If Nimbus is not available, you can set the GUI to another look and feel.
    }

    mainWindow = new JFrame("Pathfinder Character Creator");

    contentPane = (JPanel) mainWindow.getContentPane();

    // TODO mainWindow.setIconImage(icon.getImage());

    mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainWindow.setSize(800, 800);
    mainWindow.addWindowListener(this);
  }

  public void init()
  {

  }

  @Override
  public void run()
  {
    constructMainWindow();

    characterSection.setLayout(new BoxLayout(characterSection, BoxLayout.X_AXIS));

    contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

    abilityScores = new AbilityScores();
    abilitiesPane = new AbilitiesPane(abilityScores);

    
    contentPane.add(abilitiesPane);
    //contentPane.add(new SheetPane(new base.Character("Cayleigh", "Rykoa", "Non-Binary", "Lawful Neutral", "Half-Orc", "Barbarian", "Red", "Topaz", 131, "Desna", "Korvosa", 1, new AbilityScores())));

    AbilitiesPane.submitButton.addActionListener(this);

    contentPane.setVisible(true);

    mainWindow.setVisible(true);
  }

  @Override
  public void windowActivated(WindowEvent arg0)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowClosed(WindowEvent arg0)
  {

  }

  @Override
  public void windowClosing(WindowEvent arg0)
  {
    // TODO Auto-generated method stub
    saveScreenshot();
  }

  @Override
  public void windowDeactivated(WindowEvent arg0)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowDeiconified(WindowEvent arg0)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowIconified(WindowEvent arg0)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowOpened(WindowEvent arg0)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void actionPerformed(ActionEvent ae)
  {
    if (ae.getActionCommand().equals(AbilitiesPane.SUBMIT))
    {
      charPane = new CharacterPane(abilityScores);
      CharacterPane.submitButton.addActionListener(this);
      characterSection.add(charPane);
      // abilitiesPane.updateData();
      contentPane.add(characterSection);
      //
    }

    if (ae.getActionCommand().equals(CharacterPane.submitButton.getText()))
    {
      mainWindow.remove(contentPane);
      contentPane.removeAll();
      abilitiesPane.updateData(charPane.getCharacter().getRace());
      contentPane.add(abilitiesPane);

      // mainWindow.setContentPane(contentPane);
      characterSection.add(charPane);
      characterSection.add(new StatsPane());
      
      contentPane.add(characterSection);
      
      mainWindow.setContentPane(contentPane);
    }
  }
  
  public void saveScreenshot()
  {
    File file = new File(System.getProperty("user.dir") + "\\PathfinderCharacter.png");
    Dimension size = contentPane.getSize();
    BufferedImage image = new BufferedImage(
                size.width, size.height 
                          , BufferedImage.TYPE_INT_RGB);
    Graphics2D g2 = image.createGraphics();
    contentPane.paint(g2);
    try
    {
        ImageIO.write(image, "png", file);
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
  }

}
