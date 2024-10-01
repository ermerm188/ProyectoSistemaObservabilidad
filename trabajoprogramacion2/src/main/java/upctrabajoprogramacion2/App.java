package upctrabajoprogramacion2;

import upctrabajoprogramacion2.user.User;
import upctrabajoprogramacion2.user.UserRepository;
import upctrabajoprogramacion2.user.UserRepositoryImpl;
import upctrabajoprogramacion2.monitoringService.MonitoringService;

public class App {

    public static void main(String[] args) {
        MonitoringService monitoringService = new MonitoringService();
        UserRepository userRepository = new UserRepositoryImpl(monitoringService);

        // Crear usuarios
        userRepository.create(new User(1, "Alice", "alice@example.com"));
        userRepository.create(new User(2, "Bob", "bob@example.com"));

        // Leer un usuario
        userRepository.read(1);

        // Actualizar un usuario
        userRepository.update(new User(1, "Alice", "alice_new@example.com"));

        // Eliminar un usuario
        userRepository.delete(2);

        userRepository.findAll();
    }


}
