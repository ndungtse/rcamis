package rw.ac.rca.webapp.dao.impl;

import org.hibernate.Query;
import rw.ac.rca.webapp.dao.InstructorDAO;
import rw.ac.rca.webapp.orm.Instructor;

import java.util.List;

public class InstructorDAOImpl extends DAO implements InstructorDAO {

    private static InstructorDAOImpl instance;

    private InstructorDAOImpl() {
    }

    public static InstructorDAOImpl getInstance() {
        if (instance == null) {
            return new InstructorDAOImpl();
        } else {
            return instance;
        }
    }
    @Override
    public List<Instructor> getAllInstructors() {
        try{
            begin();
            Query query = getSession().createQuery("from Instructor");
            List<Instructor> instructors = query.list();
            commit();
            return  instructors;
        }catch (Exception e){
            System.out.println("Error : " + e.getMessage());
            rollback();
            return  null;
        }
    }
    @Override
    public Instructor saveInstructor(Instructor instructor) {
        try{
            begin();
            getSession().saveOrUpdate(instructor);
            commit();
            return  instructor;
        }catch (Exception exception){
            System.out.println("Error  failed to  save the Instructor: " + exception.getMessage());
            rollback();
            return null;
        }
    }

    @Override
    public Instructor getInstructorById(int id) {
        try{
            begin();
            Query query = getSession().createQuery("from Instructor where id =:idValue");
            query.setParameter("idValue", id);
            Instructor instructor = (Instructor) query.list();
            commit();
            return  instructor;
        }catch (Exception exception){
            System.out.println("Failed to get the instructor by id : " + exception.getMessage());
            rollback();
            return null;
        }
    }

    @Override
    public void deleteInstructor(Instructor instructor) {
         try{
             begin();
             getSession().delete(instructor);
             commit();
         }catch (Exception exception){
             System.out.println("Failed to delete an instructor : " + exception.getMessage());
             rollback();
         }
    }
}
