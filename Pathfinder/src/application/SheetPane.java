package application;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

import base.Character;

public class SheetPane extends JPanel implements WindowListener, ActionListener
{
  private Character character;
  private String fontName = "Calibri";
  private String borderFontName = "Calibri";
  private Font profileFont;
  private Font borderFont;

  public SheetPane(Character ch)
  {
    this.setBackground(Color.WHITE);
    this.setSize(PathfinderApp.mainWindow.getWidth(),
        PathfinderApp.mainWindow.getHeight());

    profileFont = new Font(fontName, Font.PLAIN, 14);
    borderFont = new Font(borderFontName, Font.PLAIN, 12);

    character = ch;

    setTop();

    for (Component c : this.getComponents())
    {
      c.setBackground(Color.WHITE);
    }
  }

  /**
   * 
   */
  public void setTop()
  {
    JPanel topPanel = new JPanel();
    topPanel.setLayout(new GridLayout(1, 3));

    JPanel logoPanel = new JPanel();
    logoPanel.setLayout(new BorderLayout());
    JPanel charInfoPanel1 = new JPanel();
    charInfoPanel1.setLayout(new GridLayout(3, 1));
    JPanel charInfoPanel2 = new JPanel();
    charInfoPanel2.setLayout(new GridLayout(3, 1));

    JPanel midRow1 = new JPanel();
    JPanel midRow2 = new JPanel();
    JPanel midRow3 = new JPanel();

    midRow1.setLayout(new FlowLayout(FlowLayout.LEADING));
    midRow2.setLayout(new FlowLayout(FlowLayout.LEADING));
    midRow3.setLayout(new FlowLayout(FlowLayout.LEADING));

    JPanel rightRow1 = new JPanel();
    JPanel rightRow2 = new JPanel();
    JPanel rightRow3 = new JPanel();

    rightRow1.setLayout(new FlowLayout(FlowLayout.LEADING));
    rightRow2.setLayout(new FlowLayout(FlowLayout.LEADING));
    rightRow3.setLayout(new FlowLayout(FlowLayout.LEADING));

    Border border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK);
    TitledBorder titled;

    JLabel charName = new JLabel(character.getName());
    charName.setFont(profileFont);
    charName.setHorizontalAlignment(JLabel.LEFT);
    charName.setPreferredSize(new Dimension(150, 30));
    titled = BorderFactory.createTitledBorder(border, "Character Name ",
        TitledBorder.LEFT, TitledBorder.BELOW_BOTTOM, borderFont);
    charName.setBorder(titled);
    midRow1.add(charName);

    JLabel align = new JLabel(character.getAlignment());
    align.setFont(profileFont);
    align.setHorizontalAlignment(JLabel.LEFT);
    align.setPreferredSize(new Dimension(100, 30));
    titled = BorderFactory.createTitledBorder(border, "Alignment ", TitledBorder.LEFT,
        TitledBorder.BELOW_BOTTOM, borderFont);
    align.setBorder(titled);
    midRow1.add(align);

    JLabel classAndLevel = new JLabel(
        "Level " + character.getLevel() + " " + character.getClassification().toString());
    classAndLevel.setFont(profileFont);
    classAndLevel.setHorizontalAlignment(JLabel.LEFT);
    classAndLevel.setPreferredSize(new Dimension(255, 30));
    titled = BorderFactory.createTitledBorder(border, "Character Class and Level ",
        TitledBorder.LEFT, TitledBorder.BELOW_BOTTOM, borderFont);
    classAndLevel.setBorder(titled);
    midRow2.add(classAndLevel);

    JLabel race = new JLabel(character.getRace().toString());
    race.setFont(profileFont);
    race.setHorizontalAlignment(JLabel.LEFT);
    race.setPreferredSize(new Dimension(65, 30));
    titled = BorderFactory.createTitledBorder(border, "Race ", TitledBorder.LEFT,
        TitledBorder.BELOW_BOTTOM, borderFont);
    race.setBorder(titled);
    midRow3.add(race);

    JLabel size = new JLabel(character.getSize());
    size.setFont(profileFont);
    size.setHorizontalAlignment(JLabel.LEFT);
    size.setPreferredSize(new Dimension(65, 30));
    titled = BorderFactory.createTitledBorder(border, "Size ", TitledBorder.LEFT,
        TitledBorder.BELOW_BOTTOM, borderFont);
    size.setBorder(titled);
    midRow3.add(size);

    JLabel gender = new JLabel(character.getGender());
    gender.setFont(profileFont);
    gender.setHorizontalAlignment(JLabel.LEFT);
    gender.setPreferredSize(new Dimension(75, 30));
    titled = BorderFactory.createTitledBorder(border, "Gender ", TitledBorder.LEFT,
        TitledBorder.BELOW_BOTTOM, borderFont);
    gender.setBorder(titled);
    midRow3.add(gender);

    JLabel age = new JLabel(character.getAge() + "");
    age.setFont(profileFont);
    age.setHorizontalAlignment(JLabel.LEFT);
    age.setPreferredSize(new Dimension(35, 30));
    titled = BorderFactory.createTitledBorder(border, "Age", TitledBorder.LEFT,
        TitledBorder.BELOW_BOTTOM, borderFont);
    age.setBorder(titled);
    midRow3.add(age);

    charInfoPanel1.add(midRow1);
    charInfoPanel1.add(midRow2);
    charInfoPanel1.add(midRow3);

    // Set the second group of labels
    JLabel player = new JLabel(character.getPlayer());
    player.setFont(profileFont);
    player.setHorizontalAlignment(JLabel.LEFT);
    player.setPreferredSize(new Dimension(245, 30));
    titled = BorderFactory.createTitledBorder(border, "Player", TitledBorder.LEFT,
        TitledBorder.BELOW_BOTTOM, borderFont);
    player.setBorder(titled);
    rightRow1.add(player);

    JLabel diety = new JLabel(character.getDiety());
    diety.setFont(profileFont);
    diety.setHorizontalAlignment(JLabel.LEFT);
    diety.setPreferredSize(new Dimension(140, 30));
    titled = BorderFactory.createTitledBorder(border, "Diety", TitledBorder.LEFT,
        TitledBorder.BELOW_BOTTOM, borderFont);
    diety.setBorder(titled);
    rightRow2.add(diety);

    JLabel homeland = new JLabel(character.getHomeland());
    homeland.setFont(profileFont);
    homeland.setHorizontalAlignment(JLabel.LEFT);
    homeland.setPreferredSize(new Dimension(100, 30));
    titled = BorderFactory.createTitledBorder(border, "Homeland", TitledBorder.LEFT,
        TitledBorder.BELOW_BOTTOM, borderFont);
    homeland.setBorder(titled);
    rightRow2.add(homeland);

    // Second set of labels
    JLabel height = new JLabel(character.getHeight());
    height.setFont(profileFont);
    height.setHorizontalAlignment(JLabel.LEFT);
    height.setPreferredSize(new Dimension(70, 30));
    titled = BorderFactory.createTitledBorder(border, "Height", TitledBorder.LEFT,
        TitledBorder.BELOW_BOTTOM, borderFont);
    height.setBorder(titled);
    rightRow3.add(height);

    JLabel weight = new JLabel(character.getWeight());
    weight.setFont(profileFont);
    weight.setHorizontalAlignment(JLabel.LEFT);
    weight.setPreferredSize(new Dimension(70, 30));
    titled = BorderFactory.createTitledBorder(border, "Weight", TitledBorder.LEFT,
        TitledBorder.BELOW_BOTTOM, borderFont);
    weight.setBorder(titled);
    rightRow3.add(weight);

    JLabel hair = new JLabel(character.getHairColor());
    hair.setFont(profileFont);
    hair.setHorizontalAlignment(JLabel.LEFT);
    hair.setPreferredSize(new Dimension(45, 30));
    titled = BorderFactory.createTitledBorder(border, "Hair", TitledBorder.LEFT,
        TitledBorder.BELOW_BOTTOM, borderFont);
    hair.setBorder(titled);
    rightRow3.add(hair);

    JLabel eyes = new JLabel(character.getEyeColor());
    eyes.setFont(profileFont);
    eyes.setHorizontalAlignment(JLabel.LEFT);
    eyes.setPreferredSize(new Dimension(45, 30));
    titled = BorderFactory.createTitledBorder(border, "Eyes", TitledBorder.LEFT,
        TitledBorder.BELOW_BOTTOM, borderFont);
    eyes.setBorder(titled);
    rightRow3.add(eyes);

    charInfoPanel2.add(rightRow1);
    charInfoPanel2.add(rightRow2);
    charInfoPanel2.add(rightRow3);

    
    logoPanel.add(new JLabel(createLogo(), JLabel.CENTER), BorderLayout.CENTER);
    JLabel sheet = new JLabel("Character Sheet", JLabel.CENTER);
    sheet.setFont(new Font(fontName, Font.BOLD, 20));
    logoPanel.add(sheet,BorderLayout.PAGE_END);
    
    // Set the top panel
    topPanel.add(logoPanel);
    topPanel.add(charInfoPanel1);
    topPanel.add(charInfoPanel2);

    setComponentBackground(topPanel, Color.WHITE);
    setComponentBackground(charInfoPanel1, Color.WHITE);
    setComponentBackground(charInfoPanel2, Color.WHITE);

    add(topPanel);
  }

  public void setComponentBackground(JPanel j, Color cc)
  {
    for (Component c : j.getComponents())
    {
      c.setBackground(cc);
    }
  }

  public ImageIcon createLogo()
  {
    ImageIcon image = new ImageIcon(getClass().getResource("logo.png"));

    Image i = image.getImage(); // transform it
    Image newimg = i.getScaledInstance(image.getIconWidth() / 2, image.getIconHeight() / 2,
        java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
    image = new ImageIcon(newimg); // set the image back

    return image;
  }

  @Override
  public void actionPerformed(ActionEvent arg0)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowActivated(WindowEvent arg0)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowClosed(WindowEvent arg0)
  {
    Container c = PathfinderApp.mainWindow.getContentPane();
    BufferedImage im = new BufferedImage(c.getWidth(), c.getHeight(), BufferedImage.TYPE_INT_ARGB);
    c.paint(im.getGraphics());
    try
    {
      ImageIO.write(im, "PNG", new File("shot.png"));
    }
    catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Override
  public void windowClosing(WindowEvent arg0)
  {
    // TODO Auto-generated method stub

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

}
