package rw.ac.rca.webapp.dao;

import rw.ac.rca.webapp.orm.Student;

import java.util.List;

public interface StudentDAO {
    public List<Student> getAllStudents();
    public Student saveStudent(Student studentt);
}
