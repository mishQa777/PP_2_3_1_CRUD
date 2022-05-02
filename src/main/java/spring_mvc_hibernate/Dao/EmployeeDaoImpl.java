package spring_mvc_hibernate.Dao;


import org.springframework.stereotype.Repository;
import spring_mvc_hibernate.entity.Employee;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Employee> getAllEmployees() {
        return entityManager
                .createQuery("FROM Employee").getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) {

        entityManager.createQuery("INSERT INTO Employee(name, surname, department, salary)");
    }

    @Override
    public Employee getEmployee(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void deleteEmployee(int id) {
        entityManager.createQuery("delete from Employee where id =:empId")
                .setParameter("empId", id).executeUpdate();

    }
}



