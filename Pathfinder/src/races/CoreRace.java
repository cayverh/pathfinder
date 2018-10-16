package races;

public abstract class CoreRace
{
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    
    private String alignment;
    private String name;
    private String height;
    private String weight;
    
    public CoreRace()
    {
        this.name = "[PENDING]";
    }
    
    public CoreRace(String name)
    {
        this.name = name;
        
        int[] random = new int[6];
        
        for (int i = 1; i <= 6; i++)
        {
            
        }
    }
    
    public CoreRace(String name, String alignment)
    {
        this.name = name;
        this.alignment = alignment;
    }
    
    /*public abstract void genReligion();
    public abstract void genAlignemnt();
    public abstract void genPhysicalDesc();
    public abstract void genHistory();
    
    
    public int getStr()
    {
        return strength;
    }
    
    public int getDexy()
    {
        return dexterity;
    }
    
    public int getCon()
    {
        return constitution;
    }
    
    public int getInt()
    {
        return intelligence;
    }
    
    public int getWis()
    {
        return wisdom;
    }
    
    public int getCha()
    {
        return charisma;
    }*/
}
