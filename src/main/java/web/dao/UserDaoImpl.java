package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers(){
        return entityManager.createQuery("FROM User").getResultList();
    }

    @Override
    public void addUser(User user) {
        this.entityManager.persist(user);
    }


    @Override
    public User getUser(long id) {
        User user = entityManager.find(User.class, (int) id);
        return user;

    }

    @Override
    public void deleteUser(long id) {
        entityManager.createQuery("delete from User where id= :id")
                .setParameter("id", (int) id).executeUpdate();
    }



    @Override
    public void updateUser(User user) {
        System.out.println(user.toString());
        entityManager.createQuery("update User set name = :name, surname = :surname, mail = :mail, age = :age where id = :id")
                .setParameter("name", user.getName())
                .setParameter("surname", user.getSurname())
                .setParameter("mail", user.getMail())
                .setParameter("age", user.getAge())
                .setParameter("id",  user.getId())
                .executeUpdate();
    }


}
