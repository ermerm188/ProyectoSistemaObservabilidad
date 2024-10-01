package upctrabajoprogramacion2.monitoringService;

import upctrabajoprogramacion2.compositeObserver.CompositeObserver;
import upctrabajoprogramacion2.observable.Observable;

public class MonitoringService {
    private CompositeObserver compositeObserver;

    public MonitoringService() {
        this.compositeObserver = new CompositeObserver();
    }

    public void addObserver(Observable observer) {
        compositeObserver.addObserver(observer);
    }

    public void monitor() {
        compositeObserver.observe();
    }

    public void clearObservers() {
        compositeObserver.clear();
    }
}
