package TheStrategyPattern;

public class TheStrategyPattern {

    public static void main(String[] args) 
    {
        //we're entering in the Duck floor - the parent floor, but because of the overrides, 
        //we have access to the display  mehtod
        Duck mallard = new MallardDuck();
        
        //this calls the inhierted performQuack - but this method is 
        //DELEGATED to the object's QUACKBEHAVIOR (e.g., calls quack()
        //on the duck's inherited QuackBehavior reference
        mallard.performQuack();
        
        //Calls the inherieted method from the DUCK class, which in turns
        //is delegated to the object's FLY BEHAVIOR
        mallard.performFly();
        mallard.display();
        
        Duck model = new ModelDuck();
        model.performFly(); //first calls to the perforFly object set in the ModelDuck's construcotr
        model.setFlyBehavior(new FlyRocketPowered()); //invokes the modle's inheireted setter method
        model.performFly(); //changes fly behavior! Can't do if the implementation lives inside the Duck class
    }
}
