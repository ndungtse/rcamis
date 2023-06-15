package rw.ac.rca.webapp.web.employee;

import rw.ac.rca.webapp.dao.*;
import rw.ac.rca.webapp.dao.impl.*;

import rw.ac.rca.webapp.orm.*;
import rw.ac.rca.webapp.util.UserRole;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class ListCourse
 */
public class ListEmployee extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDAO employeeDAO = EmployeeDAOImpl.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String pageRedirect = request.getParameter("page");
        HttpSession httpSession = request.getSession();
        Object user = httpSession.getAttribute("authenticatedUser");
        System.out.println("The user in session is: " + user);

        if (pageRedirect != null) {
            if (pageRedirect.equals("employees") && request.getParameter("action").equals("list")) {
                List<Employee> employees = employeeDAO.getAllEmployees();
                httpSession.setAttribute("employees", employees);
                request.setAttribute("employees", employees);
                UserRole[] userRoles = UserRole.values();
                httpSession.setAttribute("userRoles", userRoles);
                request.getRequestDispatcher("WEB-INF/employee/employees.jsp").forward(request , response);
            }
        } else {
            httpSession.setAttribute("error", "Invalid User. Try again!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/login.jsp");
            dispatcher.forward(request, response);
        }
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);

    }

}
