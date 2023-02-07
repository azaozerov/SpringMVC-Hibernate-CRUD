package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private UserDAO userDAO;

    @Autowired
    public UserServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public void createUser(User user) {
        userDAO.createUser(user);
    }

    public User getNewUser() {
        return new User();
    }

    public User readUser(Long id) {
       return userDAO.readUser(id);
    }
    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }
    @Transactional
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }


    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
