
package TheStrategyPattern;

/**
 *
 * @author jennaezis
 */
public abstract class Duck 
{
    //these are the INTERFACES that are set here;
    //through reference variables
    //the DUCK subclasses - the child classes will inhiert these
    
    //So basically you're setting up the general concepts of the methods here - the behaviors
    //expected from a parent class - DUCK.
    //When the child is implemented - MallarDuck - the specific behavior is set THERE
    //using the variables that uses the interface - fly behavior, quack behavior
    FlyBehavior     flyBehavior;
    QuackBehavior   quackBehavior;
    
    public Duck()
    {
        
    }
    
    public abstract void display();
    
    public void setFlyBehavior(FlyBehavior fb)
    {
        flyBehavior = fb;
    }
    
    public void setQuackBehavior (QuackBehavior qb)
    {
        quackBehavior = qb;
    }
    
    public void performFly()
    {
        //methods to be set in the classes that implement the interface 
        flyBehavior.fly();
    }
    
    public void performQuack()
    {
        //methods to be set in the classes that implement the interface 
        quackBehavior.quack();
    }
    
    public void swim()
    {
        System.out.println("All ducks float, even decoys!");
    }
}

//set up duck behavior in the SETTER bheavior through the Duck class rather
//than by instantiating it in the duck's constructor
class ModelDuck extends Duck
{
    public ModelDuck()
    {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }
    
    public void display()
    {
        System.out.println("I'm a model duck!");
    }
}
class MallardDuck extends Duck
{
    public MallardDuck() //specific behavior is set here, when child is implemented
    {   //these attributes were set in the Duck class - memory location is set here, 
        //with the specific behavior that is set through the INTERFACE
        quackBehavior       = new Quack();
        flyBehavior         = new FlyWithWings();
    } 
    
    //this was an abstract method set in the Duck class, being overriden here;
    public void display()
    {
        System.out.println("I'm a real Mallard duck.");
    }
}

interface FlyBehavior
{
    public void fly();
}

class FlyRocketPowered implements FlyBehavior
{
    public void fly()
    {
       System.out.println("I'm flying with a rocket1");
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

interface QuackBehavior
{
    public void quack();
}


class Quack implements QuackBehavior 
{
    public void quack()
    {
        System.out.println("Quack");
    }
}

class MuteQuack implements QuackBehavior 
{
    public void quack()
    {
        System.out.println("<< silence >>");
    }
}

class Squeak implements QuackBehavior 
{
    public void quack()
    {
        System.out.println("Squeak");
    }
}