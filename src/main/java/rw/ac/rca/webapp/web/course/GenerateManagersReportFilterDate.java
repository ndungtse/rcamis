package rw.ac.rca.webapp.web.course;

import rw.ac.rca.webapp.dao.CourseDAO;
import rw.ac.rca.webapp.dao.ManagerDAO;
import rw.ac.rca.webapp.dao.StudentDAO;
import rw.ac.rca.webapp.dao.UserDAO;
import rw.ac.rca.webapp.dao.impl.CourseDAOImpl;
import rw.ac.rca.webapp.dao.impl.ManagerDAOImpl;
import rw.ac.rca.webapp.dao.impl.StudentDAOImpl;
import rw.ac.rca.webapp.dao.impl.UserDAOImpl;
import rw.ac.rca.webapp.orm.Course;
import rw.ac.rca.webapp.util.ExcelDownloader;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListCourse
 */
public class GenerateManagersReportFilterDate extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ManagerDAO managerDAO = ManagerDAOImpl.getInstance();
    private UserDAO userDAO = UserDAOImpl.getInstance();
    private StudentDAO studentDAO = StudentDAOImpl.getInstance();
    private CourseDAO courseDAO = CourseDAOImpl.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateManagersReportFilterDate() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//        String pageRedirect = request.getParameter("page");
//        HttpSession httpSession = request.getSession();
//        Object user  httpSession.getAttribute("authenticatedUser");
//        System.out.println("The user in session is: " + user);

//        if (pageRedirect != null) {
//            if (pageRedirect.equals("reportManagers") && request.getParameter("action").equals("list")) {
        List<Course> courses = courseDAO.getAllCourses();
        ExcelDownloader.downloadCourses(courses, response);

        request.setAttribute("courses", courses);
        request.getRequestDispatcher("WEB-INF/pages/courses.jsp").forward(request , response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);

    }

}
