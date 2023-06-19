package rw.ac.rca.webapp.dao;

import rw.ac.rca.webapp.orm.Employee;

import java.util.List;

public interface EmployeeDAO  {
    public List<Employee> getAllEmployees();
    public Employee saveOrUpdateEmployee(Employee employee);
    public Employee getEmployeeById(int id);
    public void deleteEmployee(Employee employee);
}
