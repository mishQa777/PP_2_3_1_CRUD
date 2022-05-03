package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import web.dao.UserDao;
import web.models.User;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao ud;

    @Override
    @Transactional
    public void addUser(User user) {
        ud.addUser(user);
    }

    @Override
    @Transactional
    public User getUser(long id){
        return ud.getUser(id);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        ud.deleteUser(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        ud.updateUser(user);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return ud.getAllUsers();
    }
}
