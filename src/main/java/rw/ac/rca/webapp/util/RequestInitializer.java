package rw.ac.rca.webapp.util;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestInitializer {
    private int students;
    private int courses;
    private  int employees;
    private int instructors;
    private int managers;
    private int parents;
    private int users;

    public RequestInitializer(Object students, Object courses, Object instructors, Object parents, Object managers, Object managers1, Object users, Object employees, Object students1) {
        this.courses = (Integer) courses;
        this.students  = (Integer) students;
        this.parents = (Integer) parents;
        this.instructors = (Integer) instructors;
    }
}
