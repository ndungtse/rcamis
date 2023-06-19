package rw.ac.rca.webapp.dao.impl;

import org.hibernate.Query;
import rw.ac.rca.webapp.dao.ManagerDAO;
import rw.ac.rca.webapp.orm.Manager;

import java.util.List;

public class ManagerDAOImpl extends  DAO implements ManagerDAO {

    private static  ManagerDAOImpl instance;

    public static ManagerDAOImpl getInstance(){
        if(instance == null){
            return new ManagerDAOImpl();
        }
        return instance;
    }
    @Override
    public List<Manager> getAllManagers() {
        try{
            begin();
            Query query = getSession().createQuery("from Manager");
            List<Manager> managers = query.list();
            commit();
            return managers;
        }catch (Exception exception){
            System.out.println("Error, failed to get managers : " + exception.getMessage());
            rollback();
            return null;
        }
    }

    @Override
    public Manager saveOrUpdateManager(Manager mark) {
        try{
            begin();
            getSession().saveOrUpdate(mark);
            commit();
        }catch (Exception exception){
            System.out.println("Error failed to save manager : " + exception.getMessage());
            rollback();
        }
        return null;
    }

    @Override
    public Manager getManagerById(int id) {
        try {
            begin();
            Query query = getSession().createQuery("from Manager where id =:id");
            query.setParameter("id", id);
            Manager manager = (Manager) query.list();
            commit();
            return manager;
        }catch (Exception exception){
            System.out.println("Failed to get manager by id");
            rollback();
            return null;
        }
    }

    @Override
    public void deleteManager(Manager manager) {
        try {
            begin();
            getSession().delete(manager);
            commit();
        }catch (Exception exception){
            System.out.println("Failed to delete manager");
            rollback();
        }

    }
}
