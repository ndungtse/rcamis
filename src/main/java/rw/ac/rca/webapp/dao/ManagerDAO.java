package rw.ac.rca.webapp.dao;

import rw.ac.rca.webapp.orm.Manager;
import rw.ac.rca.webapp.orm.Mark;

import java.util.List;

public interface ManagerDAO {
    public List<Manager> getAllManagers();
    public Manager saveOrUpdateManager(Manager mark);
}
