package rw.ac.rca.webapp.web.instructor;

import rw.ac.rca.webapp.dao.InstructorDAO;
import rw.ac.rca.webapp.dao.ManagerDAO;
import rw.ac.rca.webapp.dao.StudentDAO;
import rw.ac.rca.webapp.dao.UserDAO;
import rw.ac.rca.webapp.dao.impl.InstructorDAOImpl;
import rw.ac.rca.webapp.dao.impl.ManagerDAOImpl;
import rw.ac.rca.webapp.dao.impl.StudentDAOImpl;
import rw.ac.rca.webapp.dao.impl.UserDAOImpl;
import rw.ac.rca.webapp.orm.Instructor;
import rw.ac.rca.webapp.orm.User;
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
public class GenerateInstructorReport extends HttpServlet {
    private static final long serialVersionUID = 1L;
    InstructorDAO instructorDAO = InstructorDAOImpl.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateInstructorReport() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        List<Instructor> instructors = instructorDAO.getAllInstructors();
        ExcelDownloader.downloadInstructorsExcel(instructors, response);
        request.setAttribute("instructors", instructors);
        request.getRequestDispatcher("WEB-INF/pages/instructors.jsp").forward(request , response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);

    }

}
