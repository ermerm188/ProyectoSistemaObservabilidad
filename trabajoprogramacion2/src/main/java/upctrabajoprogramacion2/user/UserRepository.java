package upctrabajoprogramacion2.user;

import java.util.List;

public interface UserRepository {
    User create(User user);
    User read(int id);
    User update(User user);
    void delete(int id);
    List<User> findAll();
}
