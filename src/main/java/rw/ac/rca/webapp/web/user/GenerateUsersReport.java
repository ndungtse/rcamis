package rw.ac.rca.webapp.web.user;

import rw.ac.rca.webapp.dao.ManagerDAO;
import rw.ac.rca.webapp.dao.StudentDAO;
import rw.ac.rca.webapp.dao.UserDAO;
import rw.ac.rca.webapp.dao.impl.ManagerDAOImpl;
import rw.ac.rca.webapp.dao.impl.StudentDAOImpl;
import rw.ac.rca.webapp.dao.impl.UserDAOImpl;
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
public class GenerateUsersReport extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ManagerDAO managerDAO = ManagerDAOImpl.getInstance();
    private UserDAO userDAO = UserDAOImpl.getInstance();
    private StudentDAO studentDAO = StudentDAOImpl.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateUsersReport() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        List<User> users = userDAO.getAllUsers();
        ExcelDownloader.downloadUsersExcel(users, response);
        request.setAttribute("managers", users);
        request.getRequestDispatcher("WEB-INF/pages/managers.jsp").forward(request , response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);

    }

}
