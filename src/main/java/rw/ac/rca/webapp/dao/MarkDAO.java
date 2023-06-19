package rw.ac.rca.webapp.dao;

import org.hibernate.Query;
import rw.ac.rca.webapp.orm.Manager;
import rw.ac.rca.webapp.orm.Mark;

import java.util.List;

public interface MarkDAO {

    public List<Mark> getAllMarks();
    public Mark saveOrUpdateMark(Mark mark);
    public void deleteMarkById(Mark mark);
    public Mark getMarkById(int id);

}
