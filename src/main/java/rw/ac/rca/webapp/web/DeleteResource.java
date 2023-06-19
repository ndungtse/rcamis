package rw.ac.rca.webapp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rw.ac.rca.webapp.dao.MarkDAO;
import rw.ac.rca.webapp.dao.impl.MarkDAOImpl;
import rw.ac.rca.webapp.orm.Mark;
import rw.ac.rca.webapp.orm.User;
import rw.ac.rca.webapp.util.UserRole;
import rw.ac.rca.webapp.util.Util;
import rw.ac.rca.webapp.dao.UserDAO;
import rw.ac.rca.webapp.dao.impl.UserDAOImpl;

/**
 * Servlet implementation class CreateUser
 */
public class DeleteResource extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO = UserDAOImpl.getInstance();
    private MarkDAO markDAO = MarkDAOImpl.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteResource() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        String pageRedirect = request.getPathInfo().substring(1);
        int  id = Integer.parseInt(request.getParameter("id"));
        String action = request.getParameter("page");

        switch (action){
            case "deleteMark":
                request.setAttribute("message", "Are you sure do you want to delete this mark record?");
                request.setAttribute("id", id);
                request.getRequestDispatcher("WEB-INF/pages/validator/sure.jsp").forward(request, response);
                break;
            case "deleteStudent":
                request.getRequestDispatcher("WEB-INF/pages/students.jsp").forward(request, response);
                break;
            case "deleteCourse":
                request.getRequestDispatcher("WEB-INF/pages/courses.jsp").forward(request, response);
                break;
            case "deleteManager":
                request.getRequestDispatcher("WEB-INF/pages/managers.jsp").forward(request, response);
                break;
            case "deleteEmployee":
                request.getRequestDispatcher("WEB-INF/pages/employees.jsp").forward(request, response);
                break;
            case "deleteUser":
                request.getRequestDispatcher("WEB-INF/pages/users.jsp").forward(request, response);
                break;
            case "deleteInstructor":
                request.getRequestDispatcher("WEB-INF/pages/instructors.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("WEB-INF/pages/notfound.jsp").forward(request, response);
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int  id = Integer.parseInt(request.getParameter("id"));
        String action = request.getParameter("page");

        switch (action){
            case "deleteMark":
                Mark availableMark = markDAO.getMarkById(id);
                markDAO.deleteMarkById(availableMark);
                request.setAttribute("responseMessage", "Mark deleted successfully");
                request.setAttribute("marks", markDAO.getAllMarks());
                request.getRequestDispatcher("WEB-INF/pages/marks.jsp").forward(request, response);
                break;
            case "deleteStudent":
                request.getRequestDispatcher("WEB-INF/pages/students.jsp").forward(request, response);
                break;
            case "deleteCourse":
                request.getRequestDispatcher("WEB-INF/pages/courses.jsp").forward(request, response);
                break;
            case "deleteManager":
                request.getRequestDispatcher("WEB-INF/pages/managers.jsp").forward(request, response);
                break;
            case "deleteEmployee":
                request.getRequestDispatcher("WEB-INF/pages/employees.jsp").forward(request, response);
                break;
            case "deleteUser":
                request.getRequestDispatcher("WEB-INF/pages/users.jsp").forward(request, response);
                break;
            case "deleteInstructor":
                request.getRequestDispatcher("WEB-INF/pages/instructors.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("WEB-INF/pages/notfound.jsp").forward(request, response);
        }
    }
}


