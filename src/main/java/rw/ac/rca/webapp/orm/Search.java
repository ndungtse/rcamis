package rw.ac.rca.webapp.orm;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Search {
    public List<Student> students;
    public List<Instructor> instructors;
    public List<User> users;
    public List<Course> courses;
}
