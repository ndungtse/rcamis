package rw.ac.rca.webapp.web.parent;

import rw.ac.rca.webapp.dao.CourseDAO;
import rw.ac.rca.webapp.dao.InstructorDAO;
import rw.ac.rca.webapp.dao.MarkDAO;
import rw.ac.rca.webapp.dao.ParentDAO;
import rw.ac.rca.webapp.dao.impl.CourseDAOImpl;
import rw.ac.rca.webapp.dao.impl.InstructorDAOImpl;
import rw.ac.rca.webapp.dao.impl.MarkDAOImpl;
import rw.ac.rca.webapp.dao.impl.ParentDAImpl;
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
public class ListParent extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ParentDAO parentDAO = ParentDAImpl.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListParent() {
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
            if (pageRedirect.equals("parents") && request.getParameter("action").equals("list")) {
                List<Parent> parents = parentDAO.getAllParents();
                httpSession.setAttribute("parents", parents);
                request.setAttribute("parents", parents);
                UserRole[] userRoles = UserRole.values();
                httpSession.setAttribute("userRoles", userRoles);
                request.getRequestDispatcher("WEB-INF/parent/parents.jsp").forward(request , response);
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
