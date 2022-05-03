package web.service;

import org.springframework.stereotype.Component;
import web.models.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    User getUser(long id);
    void deleteUser(long id);
    void updateUser(User user);
    List<User> getAllUsers();
}
