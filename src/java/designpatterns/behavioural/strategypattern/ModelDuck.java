package designpatterns.behavioural.strategypattern;

import designpatterns.behavioural.strategypattern.strategy.FlyNoWay;
import designpatterns.behavioural.strategypattern.strategy.Quack;

public class ModelDuck extends Duck{

    public ModelDuck(){
        super(new FlyNoWay(), new Quack());
    }

    @Override
    public void display() {
        System.out.println("I am a model duck");
    }


}
