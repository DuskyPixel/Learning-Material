//Builder Pattern - based on Effective Java's NutrionFact BuilderPattern
class Main
{
  public static void main(String[] args)
  {
    CharacterEntity ent = new CharacterEntity.Builder(1).build();
    System.out.println(ent);
    
    CharacterEntity ent2 = new CharacterEntity.Builder(2).strength(12).build();
    System.out.println(ent2);
    
    CharacterEntity ent3 = new CharacterEntity.Builder(5).strength(12).agility(14).build();
    System.out.println(ent3);
    
    CharacterEntity ent4 = new CharacterEntity.Builder(21).strength(22).vitality(25).dexterity(30).agility(33).intelligence(15).wisdom(16).build();
    System.out.println(ent4);
  }
}

class CharacterEntity
{
  private int strength;
  private int vitality;
  private int agility;
  private int dexterity;
  private int intelligence;
  private int wisdom;
  
  private final int level;
  
  public static class Builder
  {
    //required parameters
    private final int level;
    
    //optional parameters
    private int strength = 10;
    private int vitality = 10;
    private int agility = 10;
    private int dexterity = 10;
    private int intelligence = 10;
    private int wisdom = 10;
    
    
    public Builder(int level)
    {
      this.level = level;
    }
    
    public Builder strength(int val)
    { strength = val; return this;}
    public Builder vitality(int val)
    { vitality = val; return this;}
    public Builder agility(int val)
    { agility = val; return this;}
    public Builder dexterity(int val)
    { dexterity = val; return this;}
    public Builder intelligence(int val)
    { intelligence = val; return this;}
    public Builder wisdom(int val)
    { wisdom = val; return this;}
    
    public CharacterEntity build()
    {
      return new CharacterEntity(this);
    }
  }
  
  private CharacterEntity(Builder builder)
  {
    strength = builder.strength;
    vitality = builder.vitality;
    agility = builder.agility;
    dexterity = builder.dexterity;
    intelligence = builder.intelligence;
    wisdom = builder.wisdom;
    
    level = builder.level;
  }
  public String toString()
  {
    return "Level: "+level+" {"+strength+", "+vitality+", "+agility+", "+dexterity+", "+intelligence+", "+wisdom+"}";
  }
}
