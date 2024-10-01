package upctrabajoprogramacion2.user;

import upctrabajoprogramacion2.logger.Logger;
import upctrabajoprogramacion2.metric.Metric;
import upctrabajoprogramacion2.monitoringService.MonitoringService;
import upctrabajoprogramacion2.trace.Trace;

import java.util.ArrayList;
import java.util.List;



public class UserRepositoryImpl implements UserRepository {
    private List<User> users = new ArrayList<>();
    private MonitoringService monitoringService;

    public UserRepositoryImpl(MonitoringService monitoringService) {
        this.monitoringService = monitoringService;
    }

    @Override
    public User create(User user) {
        Trace trace = new Trace("CREATE_USER");
        Logger logger = new Logger("Created user with ID: " + user.getId(), Logger.Level.INFO);
        Metric metric = new Metric("Total Users", users.size() + 1);

        monitoringService.clearObservers();
        monitoringService.addObserver(trace);
        monitoringService.addObserver(logger);
        monitoringService.addObserver(metric);

        users.add(user);

        trace.end();
        monitoringService.monitor();

        return user;
    }

    @Override
    public User read(int id) {
        Trace trace = new Trace("READ_USER");
        User user = users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
        Logger logger = (user != null) ?
                new Logger("Fetched user with ID: " + id, Logger.Level.INFO) :
                new Logger("trabajoprogramacion2.src.main.java.com.upctrabajoprogramacion2.app.User with ID " + id + " not found", Logger.Level.ERROR);

        monitoringService.clearObservers();
        monitoringService.addObserver(trace);
        monitoringService.addObserver(logger);

        trace.end();
        monitoringService.monitor();

        return user;
    }

    @Override
    public User update(User user) {
        Trace trace = new Trace("UPDATE_USER");
        User existingUser = read(user.getId());
        Logger logger;

        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            logger = new Logger("Updated user with ID: " + user.getId(), Logger.Level.INFO);
        } else {
            logger = new Logger("trabajoprogramacion2.src.main.java.com.upctrabajoprogramacion2.app.User with ID " + user.getId() + " not found for update", Logger.Level.ERROR);
        }


        monitoringService.clearObservers();
        monitoringService.addObserver(trace);
        monitoringService.addObserver(logger);

        trace.end();
        monitoringService.monitor();

        return existingUser;
    }

    @Override
    public void delete(int id) {
        Trace trace = new Trace("DELETE_USER");
        User user = read(id);
        Logger logger;
        Metric metric;

        if (user != null) {
            users.remove(user);
            logger = new Logger("Deleted user with ID: " + id, Logger.Level.INFO);
            metric = new Metric("Total Users", users.size());
        } else {
            logger = new Logger("trabajoprogramacion2.src.main.java.com.upctrabajoprogramacion2.app.User with ID " + id + " not found for deletion", Logger.Level.ERROR);
            metric = new Metric("Total Users", users.size());
        }


        monitoringService.clearObservers();
        monitoringService.addObserver(trace);
        monitoringService.addObserver(logger);
        monitoringService.addObserver(metric);

        trace.end();
        monitoringService.monitor();
    }

    @Override
    public List<User> findAll() {
        Trace trace = new Trace("LIST_USERS");
        Logger logger = new Logger("Listed all users", Logger.Level.INFO);


        monitoringService.clearObservers();
        monitoringService.addObserver(trace);
        monitoringService.addObserver(logger);

        trace.end();
        monitoringService.monitor();

        return users;
    }
}

