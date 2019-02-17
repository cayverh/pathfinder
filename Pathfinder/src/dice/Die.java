package dice;

import java.util.Random;

public class Die
{
  public static int faces;
  
  public Die(int faces)
  {
    this.faces = faces;
  }
  
  public static int roll(int times)
  {
    int result = 0;
    
    for (int i = 0; i < times; i++)
    {
      result += new Random().nextInt(faces) + 1;
    }
    return result;
  }
}
