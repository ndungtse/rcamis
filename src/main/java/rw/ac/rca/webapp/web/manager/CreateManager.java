package rw.ac.rca.webapp.web.manager;

import rw.ac.rca.webapp.dao.ManagerDAO;
import rw.ac.rca.webapp.dao.impl.ManagerDAOImpl;
import rw.ac.rca.webapp.orm.Manager;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CreateCourse
 */
public class CreateManager extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ManagerDAO managerDAO = ManagerDAOImpl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateManager() {
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
            System.out.println("The print statement is and the only is: " + pageRedirect);
            if (pageRedirect.equals("createManager")) {
                request.getRequestDispatcher("WEB-INF/pages/createManager.jsp").forward(request, response);
            } else {
                request.setAttribute("error ", "No user found");
                request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error ", "No user found");
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageRedirect = request.getParameter("page");
        HttpSession httpSession = request.getSession();
        Object user = httpSession.getAttribute("authenticatedUser");

        if(pageRedirect != null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if(pageRedirect.equals("createManager")){
                Manager manager = null;
                try {
                    manager = new Manager(
                            request.getParameter("firstName"),
                            request.getParameter("lastName"),
                            request.getParameter("phoneNumber"),
                            simpleDateFormat.parse(request.getParameter("dob"))
                    );
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                // Saving the course;
                try {
                    managerDAO.saveOrUpdateManager(manager);
                    List<Manager> managers = managerDAO.getAllManagers();
                    request.setAttribute("success" , "Successfully created the manager" );
                    request.setAttribute("managers", managers);
                    request.getRequestDispatcher("WEB-INF/pages/managers.jsp").forward(request , response);
                }catch (Exception e){
                    request.setAttribute("error" , "Failed to create the Course" );
                    request.getRequestDispatcher("WEB-INF/pages/createManager.jsp").forward(request , response);
                }
            }else{
                request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request , response);
            }
        }else{
            request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request , response);
        }
    }
}
