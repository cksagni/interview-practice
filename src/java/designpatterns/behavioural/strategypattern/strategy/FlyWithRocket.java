package designpatterns.behavioural.strategypattern.strategy;

public class FlyWithRocket implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("I am flying with a rocket");
    }
}
