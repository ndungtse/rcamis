package rw.ac.rca.webapp.web.employee;
import rw.ac.rca.webapp.dao.EmployeeDAO;
import rw.ac.rca.webapp.dao.impl.EmployeeDAOImpl;
import rw.ac.rca.webapp.orm.Employee;
import java.io.IOException;
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
public class CreateEmployee extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDAO employeeDAO = EmployeeDAOImpl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateEmployee() {
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
            if (pageRedirect.equals("createEmployee")) {
                request.getRequestDispatcher("WEB-INF/employee/createEmployee.jsp").forward(request, response);
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
            if(pageRedirect.equals("createEmployee")){
                Employee employee = null;
                try {
                    employee = new Employee(
                            request.getParameter("firstName"),
                            request.getParameter("lastName"),
                            request.getParameter("phoneNumber"),
                            simpleDateFormat.parse(request.getParameter("dateOfBirth"))
                    );
                } catch ( Exception e) {
                    throw new RuntimeException(e);
                }
                // Saving the parent;
                try {
                    employeeDAO.saveOrUpdateEmployee(employee);
                    List<Employee> employees = employeeDAO.getAllEmployees();
                    request.setAttribute("success" , "Successfully created the employee" );
                    request.setAttribute("employees", employees);
                    request.getRequestDispatcher("WEB-INF/employee/employees.jsp").forward(request , response);
                }catch (Exception e){
                    request.setAttribute("error" , "Failed to create the Course" );
                    request.getRequestDispatcher("WEB-INF/employee/createEmployee.jsp").forward(request , response);
                }
            }else{
                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request , response);
            }
        }else{
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request , response);
        }
    }
}
