package web.dao;

import web.models.User;

import javax.transaction.Transactional;
import java.util.List;

public interface UserDao {
    void addUser(User user);
    User getUser(long id);
    void deleteUser(long id);
    void updateUser(User user);
    List<User> getAllUsers();
}
