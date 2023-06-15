package rw.ac.rca.webapp.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import rw.ac.rca.webapp.dao.StudentDAO;
import rw.ac.rca.webapp.orm.Student;
import rw.ac.rca.webapp.orm.Student;

import java.util.List;


public class StudentDAOImpl extends DAO implements StudentDAO {
    public static final Logger LOG = Logger.getLogger(UserDAOImpl.class);
    public static StudentDAOImpl instance;

    /**
     * @return user instance
     */
    public static StudentDAOImpl getInstance() {
        if (instance == null) {
            return new StudentDAOImpl();

        } else {
            return instance;
        }
    }

    private StudentDAOImpl() {

    }
    @Override
    public List<Student> getAllStudents() {
        try{
            begin();
            Query query = getSession().createQuery("from Student");
            List<Student> students = query.list();
            commit();
            return  students;
        }catch (Exception e){
            System.out.println("Error : " + e.getMessage());
            rollback();
            return  null;
        }
    }

    @Override
    public Student saveStudent(Student student) {
        try{
            begin();
            getSession().saveOrUpdate(student);
            commit();
            return  student;
        }catch (Exception exception){
            System.out.println("Error  failed to save student :" + exception.getMessage());
            rollback();
            return null;
        }
    }
}

