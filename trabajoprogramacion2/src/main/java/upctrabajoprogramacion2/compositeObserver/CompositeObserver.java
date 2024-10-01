package upctrabajoprogramacion2.compositeObserver;

import upctrabajoprogramacion2.observable.Observable;

import java.util.ArrayList;
import java.util.List;

public class CompositeObserver implements Observable {
    private List<Observable> observers = new ArrayList<>();

    public void addObserver(Observable observer) {
        observers.add(observer);
    }

    public void clear() {
        observers.clear();
    }

    @Override
    public void observe() {
        for (Observable observer : observers) {
            observer.observe();
        }
    }
}