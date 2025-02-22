package designpatterns.behavioural.observerpattern;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    List<Observer> observerList = new ArrayList<>();
    public void addObserver(Observer observer){
        this.observerList.add(observer);
    }
    public void removeObserver(Observer observer){
        this.observerList.remove(observer);
    }
    public void notifyObservers(){
        for (Observer observer: observerList){
            observer.update();
        }
    };
}
