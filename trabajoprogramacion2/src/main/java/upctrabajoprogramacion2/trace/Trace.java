package upctrabajoprogramacion2.trace;

import upctrabajoprogramacion2.observable.Observable;

public class Trace implements Observable {
    private String traceId;
    private long startTime;
    private long endTime;

    public Trace(String traceId) {
        this.traceId = traceId;
        this.startTime = System.currentTimeMillis();
    }

    public void end() {
        this.endTime = System.currentTimeMillis();
    }

    @Override
    public void observe() {
        long duration = (endTime == 0) ? System.currentTimeMillis() - startTime : endTime - startTime;
        System.out.println("Trace ID: " + traceId + " | Duration: " + duration + "ms");
    }
}
