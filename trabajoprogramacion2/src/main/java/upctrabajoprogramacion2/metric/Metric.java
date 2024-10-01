package upctrabajoprogramacion2.metric;

import upctrabajoprogramacion2.observable.Observable;

public class Metric implements Observable {
    private String name;
    private double value;

    public Metric(String name, double value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public void observe() {
        System.out.println("Metric: " + name + " = " + value);
    }
}