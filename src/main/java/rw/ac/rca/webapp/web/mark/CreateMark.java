package rw.ac.rca.webapp.web.mark;

import rw.ac.rca.webapp.dao.MarkDAO;
import rw.ac.rca.webapp.dao.impl.MarkDAOImpl;
import rw.ac.rca.webapp.orm.Mark;

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
public class CreateMark extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MarkDAO markDAO = MarkDAOImpl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateMark() {
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
            if (pageRedirect.equals("createMark")) {
                request.getRequestDispatcher("WEB-INF/mark/createMark.jsp").forward(request, response);
            } else {
                request.setAttribute("error ", "No user found");
                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
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
            if(pageRedirect.equals("createMark")){
                Mark mark = null;
                try {
                    mark = new Mark(
                            request.getParameter("marks"),
                            request.getParameter("owner")
                    );
                } catch ( Exception e) {
                    throw new RuntimeException(e);
                }
                // Saving the marks;
                try {
                    markDAO.saveOrUpdateMark(mark);
                    List<Mark> marks = markDAO.getAllMarks();
                    request.setAttribute("success" , "Successfully created the Course" );
                    request.setAttribute("marks", marks);
                    request.getRequestDispatcher("WEB-INF/mark/marks.jsp").forward(request , response);
                }catch (Exception e){
                    request.setAttribute("error" , "Failed to create the Course" );
                    request.getRequestDispatcher("WEB-INF/mark/createMark.jsp").forward(request , response);
                }
            }else{
                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request , response);
            }
        }else{
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request , response);
        }
    }
}
