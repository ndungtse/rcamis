package rw.ac.rca.webapp.web;

import rw.ac.rca.webapp.dao.CourseDAO;
import rw.ac.rca.webapp.dao.StudentDAO;
import rw.ac.rca.webapp.dao.UserDAO;
import rw.ac.rca.webapp.dao.impl.CourseDAOImpl;
import rw.ac.rca.webapp.dao.impl.StudentDAOImpl;
import rw.ac.rca.webapp.orm.Course;
import rw.ac.rca.webapp.orm.Student;
import rw.ac.rca.webapp.orm.User;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CreateCourse
 */
public class CreateStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private  StudentDAO studentDAO = StudentDAOImpl.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateStudent() {
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
            if (pageRedirect.equals("createStudent")) {
                request.getRequestDispatcher("WEB-INF/pages/createStudent.jsp").forward(request, response);
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
            if(pageRedirect.equals("createStudent")){
                Student student = null;
                try {
                    student = new Student(
                            request.getParameter("firstName"),
                            request.getParameter("lastName"),
                            request.getParameter("phoneNumber"),
                            simpleDateFormat.parse(request.getParameter("dob")),
                            false,
                            true,
                            false
                    );
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                // Saving the course;
                try {
                    studentDAO.saveStudent(student);
                    request.setAttribute("students", studentDAO.getAllStudents());
                    request.setAttribute("success" , "Successfully created the Course" );
                    request.getRequestDispatcher("WEB-INF/pages/students.jsp").forward(request , response);
                    Thread.sleep(2000);
                    request.removeAttribute("success");
                }catch (Exception e){
                    request.setAttribute("error" , "Failed to create the Course" );
                    request.getRequestDispatcher("WEB-INF/pages/createStudent.jsp").forward(request , response);
                }
            }else{
                request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request , response);
            }
        }else{
            request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request , response);
        }
    }
}
