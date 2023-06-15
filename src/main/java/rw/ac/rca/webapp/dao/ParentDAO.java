package rw.ac.rca.webapp.dao;

import rw.ac.rca.webapp.orm.Parent;

import java.util.List;

public interface  ParentDAO {
    public  List<Parent> getAllParents();
    public  Parent registerParent(Parent parent);
}
