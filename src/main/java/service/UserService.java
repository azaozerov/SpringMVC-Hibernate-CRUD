package service;
import model.User;

import java.util.List;
public interface UserService {
    void createUser(User user);
    User getNewUser();

    User readUser(Long id);

    void updateUser(User user);

    void deleteUser(Long id);

    List<User> getAllUsers();
}
