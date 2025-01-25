package designpatterns.behavioural.strategypattern;

import designpatterns.behavioural.strategypattern.strategy.FlyWithRocket;

public class DuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performFly();
        mallard.performQuack();

        Duck model = new ModelDuck();
        model.display();
        model.performQuack();
        model.performFly();
        model.setFlyBehavior(new FlyWithRocket());
        model.performFly();
    }
}
