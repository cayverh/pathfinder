package resources;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class Engebrechtre
{
  public static Font enge_bd_it;
  public static Font enge_bd;
  public static Font enge_ex_bd_it;
  public static Font enge_ex_bd;
  public static Font enge_ex_it;
  public static Font enge_ex;
  public static Font enge_rg_it;
  public static Font enge_rg;
  
  public Engebrechtre() throws FontFormatException, IOException
  {
    enge_bd_it = Font.createFont(Font.TRUETYPE_FONT, new File("src/resources/engebrechtre_bd_it.ttf"));
    enge_bd = Font.createFont(Font.TRUETYPE_FONT, new File("src/resources/engebrechtre_bd.ttf"));
    enge_ex_bd_it = Font.createFont(Font.TRUETYPE_FONT, new File("src/resources/engebrechtre_ex_bd_it.ttf"));
    enge_ex_bd = Font.createFont(Font.TRUETYPE_FONT, new File("src/resources/engebrechtre_ex_bd.ttf"));
    enge_ex_it = Font.createFont(Font.TRUETYPE_FONT, new File("src/resources/engebrechtre_ex_it.ttf"));
    enge_ex = Font.createFont(Font.TRUETYPE_FONT, new File("src/resources/engebrechtre_ex.ttf"));
    enge_rg_it = Font.createFont(Font.TRUETYPE_FONT, new File("src/resources/engebrechtre_rg_it.ttf"));
    enge_rg = Font.createFont(Font.TRUETYPE_FONT, new File("src/resources/engebrechtre_rg.ttf"));
    
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    ge.registerFont(enge_bd_it);
    ge.registerFont(enge_bd);
    ge.registerFont(enge_ex_bd_it);
    ge.registerFont(enge_ex_bd);
    ge.registerFont(enge_ex_it);
    ge.registerFont(enge_ex);
    ge.registerFont(enge_rg_it);
    ge.registerFont(enge_rg);
  }
}
