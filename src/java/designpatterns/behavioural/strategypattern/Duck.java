package designpatterns.behavioural.strategypattern;

import designpatterns.behavioural.strategypattern.strategy.FlyBehavior;
import designpatterns.behavioural.strategypattern.strategy.QuackBehavior;

public abstract class Duck {
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior){
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    public void setFlyBehavior(FlyBehavior fb){
        this.flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb){
        this.quackBehavior = qb;
    }

    public void performQuack(){
        this.quackBehavior.quack();
    }

    public void performFly(){
        this.flyBehavior.fly();
    }

    public abstract void display();
}
