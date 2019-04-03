package application;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Pane extends JPanel
{
  public void Pane()
  {
    this.setLayout(new BorderLayout());
    
    AbilitiesPane ap = new AbilitiesPane();
    
    //abilityPanel.add(ap);
    add(ap);
  }
}
