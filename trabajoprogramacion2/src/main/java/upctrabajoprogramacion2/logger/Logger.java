package upctrabajoprogramacion2.logger;

import upctrabajoprogramacion2.observable.Observable;

import java.io.FileWriter;
import java.io.IOException;



public class Logger implements Observable {
    public enum Level { INFO, ERROR, DEBUG }

    private String message;
    private Level level;

    public Logger(String message, Level level) {
        this.message = message;
        this.level = level;
    }

    @Override
    public void observe() {
        logToConsole();
        logToFile();
    }

    private void logToConsole() {
        System.out.println(level.name() + ": " + message);
    }

    private void logToFile() {
        try (FileWriter writer = new FileWriter("application.log", true)) {
            writer.write(level.name() + ": " + message + "\n");
        } catch (IOException e) {
            System.err.println("Failed to write log: " + e.getMessage());
        }
    }
}
