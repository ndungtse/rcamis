package rw.ac.rca.webapp.web.instructor;

import rw.ac.rca.webapp.dao.InstructorDAO;
import rw.ac.rca.webapp.dao.impl.InstructorDAOImpl;
import rw.ac.rca.webapp.orm.Instructor;

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
public class CreateInstructor extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private InstructorDAO instructorDAO = InstructorDAOImpl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateInstructor() {
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
            if (pageRedirect.equals("createInstructor")) {
                request.getRequestDispatcher("WEB-INF/pages/createInstructor.jsp").forward(request, response);
            } else {
                request.setAttribute("error ", "No user found");
                request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error ", "No user found");
            request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
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
            if(pageRedirect.equals("createInstructor")){
                Instructor instructor = null;
                try {
                    instructor = new Instructor(
                            request.getParameter("firstName"),
                            request.getParameter("lastName"),
                            request.getParameter("phoneNumber"),
                            simpleDateFormat.parse(request.getParameter("renumerationTime")),
                            simpleDateFormat.parse(request.getParameter("dob"))
                    );
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                // Saving the course;
                try {
                    instructorDAO.saveInstructor(instructor);
                    List<Instructor> instructors = instructorDAO.getAllInstructors();
                    request.setAttribute("success" , "Successfully created the Course" );
                    request.setAttribute("instructors", instructors);
                    request.getRequestDispatcher("WEB-INF/pages/instructors.jsp").forward(request , response);
                }catch (Exception e){
                    request.setAttribute("error" , "Failed to create the Course" );
                    request.getRequestDispatcher("WEB-INF/pages/createCourse.jsp").forward(request , response);
                }
            }else{
                request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request , response);
            }
        }else{
            request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request , response);
        }
    }
}
