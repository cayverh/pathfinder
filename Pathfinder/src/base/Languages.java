package base;

import java.util.ArrayList;
import java.util.Arrays;

public interface Languages
{
  public final String ABOLETH = "Aboleth";
  public final String ABYSSAL = "Abyssal";
  public final String AKLO = "Aklo";
  public final String AQUAN = "Aquan";
  public final String AURAN = "Auran";
  public final String BOGGARD = "Boggard";
  public final String CELESTIAL = "Celestial";
  public final String CYCLOPS = "Cyclops";
  public final String DARKFOLK = "Dark Folk";
  public final String DRACONIC = "Draconic";
  public final String DROWSIGN = "Drow Sign Language";
  public final String DWARVEN = "Dwarven";
  public final String DZIRIAK = "D'ziriak";
  public final String ELVEN = "Elven";
  public final String GIANT = "Giant";
  public final String GNOLL = "Gnoll";
  public final String GNOME = "Gnome";
  public final String GOBLIN = "Goblin";
  public final String GRIPPLI = "Grippli";
  public final String HALFLING = "Halfling";
  public final String IGNAN = "Ignan";
  public final String INFERNAL = "Infernal";
  public final String NECRIL = "Necril";
  public final String ORC = "Orc";
  public final String PROTEAN = "Protean";
  public final String SPHINX = "Sphinx";
  public final String SYLVAN = "Sylvan";
  public final String TERRAN = "Terran";
  public final String TREANT = "Treant";
  public final String UNDERCOMMON = "Undercommon";
  public final String VEGEPYGMY = "Vegepygnmy";

  public final ArrayList<String> allLanguages = new ArrayList<String>(Arrays.asList(ABOLETH,
      ABYSSAL, AKLO, AQUAN, AURAN, BOGGARD, CELESTIAL, CYCLOPS, DARKFOLK, DRACONIC, DROWSIGN,
      DWARVEN, DZIRIAK, ELVEN, GIANT, GNOLL, GNOME, GOBLIN, GRIPPLI, HALFLING, IGNAN, INFERNAL,
      NECRIL, ORC, PROTEAN, SPHINX, SYLVAN, TERRAN, TREANT, UNDERCOMMON, VEGEPYGMY));
}
