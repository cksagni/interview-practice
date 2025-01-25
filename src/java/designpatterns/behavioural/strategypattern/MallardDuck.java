package designpatterns.behavioural.strategypattern;

import designpatterns.behavioural.strategypattern.strategy.FlyWithWings;
import designpatterns.behavioural.strategypattern.strategy.Quack;

public class MallardDuck extends Duck{
    public MallardDuck(){
        super(new FlyWithWings(), new Quack());
    }

    @Override
    public void display(){
        System.out.println("I am a real Mallard Duck");
    }
}
