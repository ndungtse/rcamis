package rw.ac.rca.webapp.web;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import rw.ac.rca.webapp.dao.*;
import rw.ac.rca.webapp.dao.impl.*;
import rw.ac.rca.webapp.orm.Employee;
import rw.ac.rca.webapp.util.UserRole;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;


import java.util.Set;

/**
 * Servlet implementation class Dashboard
 */
public class Dashboard extends HttpServlet {
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException, IOException {
       StudentDAO studentDAO = StudentDAOImpl.getInstance();
       CourseDAO courseDAO = CourseDAOImpl.getInstance();
       EmployeeDAO employeeDAO = EmployeeDAOImpl.getInstance();
       InstructorDAO instructorDAO = InstructorDAOImpl.getInstance();
       ManagerDAO managerDAO = ManagerDAOImpl.getInstance();
       ParentDAO parentDAO = ParentDAImpl.getInstance();
       UserDAO userDAO = UserDAOImpl.getInstance();

       HttpSession httpSession = request.getSession();
       UserRole[] userRoles = UserRole.values();
       httpSession.setAttribute("userRoles", userRoles);
       Set<Employee> employees = new HashSet<>();
       int num = 0;

       if(!employeeDAO.getAllEmployees().isEmpty())
           num = employeeDAO.getAllEmployees().size();
       httpSession.setAttribute("employees", num);
       if(studentDAO.getAllStudents() == null){
           httpSession.setAttribute("instructors", 0);
       }else{
           httpSession.setAttribute("instructors", instructorDAO.getAllInstructors().size());
       }
       if(courseDAO.getAllCourses() == null){
           httpSession.setAttribute("courses", 0);
       }else{
           httpSession.setAttribute("courses", courseDAO.getAllCourses().size());
       }
       if(studentDAO.getAllStudents() == null){
           httpSession.setAttribute("studentsNumber", 0);
       }else{
           httpSession.setAttribute("studentsNumber", studentDAO.getAllStudents().size());
       }
       request.getRequestDispatcher("WEB-INF/pages/dashboard.jsp").forward(
               request, response);
   }
}
