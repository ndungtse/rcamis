package rw.ac.rca.webapp.web;

import rw.ac.rca.webapp.dao.StudentDAO;
import rw.ac.rca.webapp.dao.UserDAO;
import rw.ac.rca.webapp.dao.impl.StudentDAOImpl;
import rw.ac.rca.webapp.dao.impl.UserDAOImpl;
import rw.ac.rca.webapp.orm.Student;
import rw.ac.rca.webapp.util.UserRole;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ListStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO = UserDAOImpl.getInstance();
    private StudentDAO studentDAO = StudentDAOImpl.getInstance();

    public ListStudent() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageRedirect = request.getParameter("page");
        List<Student> students = studentDAO.getAllStudents();
        HttpSession httpSession = request.getSession();
        UserRole[] userRoles = UserRole.values();
        httpSession.setAttribute("userRoles", userRoles);
        httpSession.setAttribute("students", students);
        request.setAttribute("students", students);
        System.out.println("======================== students==========" + students);
        request.getRequestDispatcher("WEB-INF/pages/students.jsp").forward(
                request, response);
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {
        HttpSession httpSession = request.getSession();
        try {
            httpSession.setAttribute("success", "Created successfully");
            request.getRequestDispatcher("WEB-INF/homeadmin.jsp").forward(
                    request, response);

        } catch (Exception e) {
            httpSession.setAttribute("error", "Can't Create");
            request.getRequestDispatcher("WEB-INF/createuser.jsp").forward(
                    request, response);
        }

    }
}
