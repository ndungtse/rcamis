package rw.ac.rca.webapp.dao;

import rw.ac.rca.webapp.orm.Mark;

import java.util.List;

public interface MarkDAO {

    public List<Mark> getAllMarks();
    public Mark saveOrUpdateMark(Mark mark);
}
