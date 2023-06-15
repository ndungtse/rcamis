package rw.ac.rca.webapp.dao.impl;
import org.hibernate.Query;
import rw.ac.rca.webapp.dao.EmployeeDAO;
import rw.ac.rca.webapp.orm.Employee;
import java.util.List;

public class EmployeeDAOImpl extends DAO implements EmployeeDAO {

    private static EmployeeDAOImpl instance;
    public static EmployeeDAOImpl getInstance(){
        if(instance == null){
            return new EmployeeDAOImpl();
        }
        return instance;
    }
    @Override
    public List<Employee> getAllEmployees() {
        try{
            begin();
            Query query = getSession().createQuery("from Employee");
            List<Employee> employees = query.list();
            commit();
            return  employees;
        }catch (Exception exception){
            System.out.println("Error , failed to get employees list : " + exception.getMessage());
            rollback();
            return  null;
        }
    }
    @Override
    public Employee saveOrUpdateEmployee(Employee employee) {
        try{
            begin();
            getSession().saveOrUpdate(employee);
            commit();
            return employee;

        }catch (Exception e){
            System.out.println("Error, failed to save an employee : " + e.getMessage());
            rollback();
            return null;
        }
    }
}
