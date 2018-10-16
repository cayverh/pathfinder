package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.swing.*;

import app.JApplication;
import io.ResourceFinder;
import resources.Engebrechtre;
import visual.Visualization;
import visual.VisualizationView;

public class PathfinderApp extends JApplication
{
  private static final Font FONT_HEADING = new Font("Onyx", Font.PLAIN, 25);
  private static JPanel contentPane;
  private static Engebrechtre font;

  public PathfinderApp(int width, int height)
  {
    super(width, height);
  }

  public static void main(String[] args) throws InvocationTargetException, InterruptedException, FontFormatException, IOException
  {
    font = new Engebrechtre();
    SwingUtilities.invokeAndWait(new PathfinderApp(800, 800));
  }

  @Override
  public void init()
  {
    // Marker for finding resources
    ResourceFinder finder = ResourceFinder.createInstance(resources.Marker.class);
    contentPane = (JPanel) this.getContentPane();
    visual.statik.sampled.Content logo;

    // Visualization for adding content
    Visualization visual = new Visualization();
    VisualizationView view = visual.getView();

    contentPane.setBackground(Color.WHITE);
    contentPane.setSize(width, height);
    contentPane.setLayout(null);

    logo = new visual.statik.sampled.ContentFactory(finder).createContent("Pathfinder-logo.png", 4);
    logo.setScale(0.50);
    logo.setLocation(0, 0);

    // Set the bounds of the view so it "shows up" on the screen
    view.setBounds(0, 0, (int) logo.getBounds2D().getWidth() / 2,
        (int) logo.getBounds2D().getHeight() / 2);

    visual.add(logo);

    JLabel charText;
    JLabel playText;

    // Initialize components
    charText = new JLabel("Character Name: ______________");
    charText.setFont(FONT_HEADING);
    charText.setBounds(350, 10, 300, 30);

    playText = new JLabel("Player: ______________");
    playText.setFont(FONT_HEADING);
    playText.setBounds(350, 50, 300, 30);

    // Add visual content to the content pane
    contentPane.add(visual.getView());
    
    contentPane.add(charText);
    contentPane.add(playText);
    

  }

}
