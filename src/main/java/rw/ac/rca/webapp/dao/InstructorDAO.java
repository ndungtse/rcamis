package rw.ac.rca.webapp.dao;

import rw.ac.rca.webapp.orm.Instructor;

import java.util.List;

public interface InstructorDAO {
    public List<Instructor> getAllInstructors();
    public Instructor saveInstructor(Instructor instructor);
}
