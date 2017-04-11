class Main
{

  public static void main(String[] args)
  {
    RubberDuck rubby = new RubberDuck();
    rubby.display();
    rubby.swim();
    rubby.quack();
    rubby.fly();
    rubby.setFlyBehavior(new FlyRocketPowered());
    rubby.fly();
    
    System.out.println("");
    
    MallardDuck mally = new MallardDuck();
    mally.display();
    mally.swim();
    mally.quack();
    mally.setQuackBehavior(new MuteQuack());
    mally.quack();
    mally.fly();
    mally.setFlyBehavior(new FlyRocketPowered());
    mally.fly();
  }
}


abstract class Duck
{
	QuackBehavior quackBehavior;
	FlyBehavior flyBehavior;
  
  abstract void display();
  
  public void quack()
  {
    quackBehavior.quack();
  }
  
  public void fly()
  {
    flyBehavior.fly();
  }
  
  public void swim()
  {
    System.out.println("All ducks float");
  }
  
  public void setQuackBehavior(QuackBehavior qb)
  {
    System.out.println("changed quack behavior");
    quackBehavior = qb;
  }
  
  public void setFlyBehavior(FlyBehavior fb)
  {
    System.out.println("changed fly behavior");
    flyBehavior = fb;
  }
}

class RubberDuck extends Duck
{
  public RubberDuck()
  {
    quackBehavior = new Squeek(); 
    flyBehavior = new FlyNoWay();
  }
  
  public void display()
  {
    System.out.println("I'm a rubber duckie");
  }
}

class MallardDuck extends Duck
{
  public MallardDuck()
  {
    quackBehavior = new Quack();
    flyBehavior = new FlyWithWings();
  }
  
  public void display()
  {
    System.out.println("I'm a mallard duck");
  }
}

class Quack implements QuackBehavior
{
  public void quack(){
    System.out.println("quack quack!");
  }
}

class Squeek implements QuackBehavior
{
  public void quack(){
    System.out.println("squeek!");
  }
}

class MuteQuack implements QuackBehavior
{
  public void quack(){
    System.out.println("(...)");
  }
}

class FlyWithWings implements FlyBehavior
{
  public void fly()
  {
    System.out.println("I'm flying!");
  }
}

class FlyNoWay implements FlyBehavior
{
  public void fly()
  {
    System.out.println("I can't fly");
  }
}

class FlyRocketPowered implements FlyBehavior {
 public void fly() {
  System.out.println("I'm flying with a rocket");
 }
}

interface QuackBehavior 
{
   public void quack();
}

interface FlyBehavior 
{
  public void fly();
}
