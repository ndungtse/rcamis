package rw.ac.rca.webapp.web;

import rw.ac.rca.webapp.dao.*;
import rw.ac.rca.webapp.dao.impl.*;
import rw.ac.rca.webapp.orm.*;
import rw.ac.rca.webapp.orm.Student;
import rw.ac.rca.webapp.util.UserRole;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.zip.CheckedOutputStream;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateCourse
 */
public class UpdateResource extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private  CourseDAO courseDAO = CourseDAOImpl.getInstance();
    private MarkDAO markDAO = MarkDAOImpl.getInstance();
    private ManagerDAO managerDAO = ManagerDAOImpl.getInstance();
    private StudentDAO studentDAO = StudentDAOImpl.getInstance();
    private UserDAO userDAO = UserDAOImpl.getInstance();
    private InstructorDAO instructorDAO = InstructorDAOImpl.getInstance();
    private EmployeeDAO employeeDAO = EmployeeDAOImpl.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateResource() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        int  id = Integer.parseInt(request.getParameter("id"));
        String action = request.getParameter("page");

        switch (action){
            case "updateMark":
                Mark mark = markDAO.getMarkById(id);
                request.setAttribute("mark", mark);
                request.setAttribute("id", id);
                request.getRequestDispatcher("WEB-INF/pages/mark/updateMark.jsp").forward(request, response);
                break;
            case "updateStudent":
                Student student = studentDAO.getStudentById(id);
                request.setAttribute("student", student);
                request.setAttribute("id", id);
                request.getRequestDispatcher("WEB-INF/pages/student/updateStudent.jsp").forward(request, response);
                break;
            case "updateCourse":
                Course course = courseDAO.getCourseById(id);
                request.setAttribute("course", course);
                request.setAttribute("id", id);
                request.getRequestDispatcher("WEB-INF/pages/course/updateCourse.jsp").forward(request, response);
                break;
            case "updateManager":
                Manager manager = managerDAO.getManagerById(id);
                request.setAttribute("manager", manager);
                request.setAttribute("id",id);
                request.getRequestDispatcher("WEB-INF/pages/manager/updateManager.jsp").forward(request, response);
                break;
            case "updateEmployee":
                Employee employee = employeeDAO.getEmployeeById(id);
                request.setAttribute("employee", employee);
                request.setAttribute("id", id);
                request.getRequestDispatcher("WEB-INF/pages/employee/updateEmployee.jsp").forward(request, response);
                break;
            case "updateUser":
                User user = userDAO.getUserById(id);
                request.setAttribute("user", user);
                request.setAttribute("id", id);
                request.getRequestDispatcher("WEB-INF/pages/user/updateUser.jsp").forward(request, response);
                break;
            case "updateInstructor":
                Instructor instructor = instructorDAO.getInstructorById(id);
                System.out.println("instructor" + instructor);
                request.setAttribute("instructor", instructor);
                request.setAttribute("id",id);
                request.getRequestDispatcher("WEB-INF/pages/instructor/updateInstructor.jsp").forward(request, response);
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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Mark mark = null;
        Manager manager = null;
        Student student = null;
        Instructor instructor = null;
        Employee employee = null;
        Course course = null;
        try {
            switch (action){
                case "updateMark":
                    Mark availableMark = markDAO.getMarkById(id);
                    mark = new Mark(
                            request.getParameter("marks"),
                            request.getParameter("owner")
                    );
                    availableMark.setMarks(mark.getMarks());
                    availableMark.setOwner(mark.getOwner());
                    markDAO.saveOrUpdateMark(availableMark);
                    request.setAttribute("responseMessage", "Mark updated successfully.!");
                    request.setAttribute("marks", markDAO.getAllMarks());
                    request.getRequestDispatcher("WEB-INF/pages/marks.jsp").forward(request, response);
                    break;
                case "updateStudent":
                    Student availableStudent = studentDAO.getStudentById(id);
                    student = new Student(
                            request.getParameter("firstName"),
                            request.getParameter("lastName"),
                            request.getParameter("phoneNumber"),
                            simpleDateFormat.parse(request.getParameter("dob")),
                            false,
                            true,
                            false
                    );
                    availableStudent.setDateOfBirth(student.getDateOfBirth());
                    availableStudent.setPartTime(student.isPartTime());
                    availableStudent.setPhoneNumber(student.getPhoneNumber());
                    availableStudent.setLastName(student.getLastName());
                    availableStudent.setRepeating(student.isRepeating());
                    availableStudent.setInternational(student.isInternational());
                    studentDAO.saveStudent(availableStudent);
                    request.setAttribute("success", true);
                    request.setAttribute("students", studentDAO.getAllStudents());
                    request.getRequestDispatcher("WEB-INF/pages/students.jsp").forward(request, response);
                    break;
                case "updateCourse":
                    Course availableCourse = courseDAO.getCourseById(id);
                    availableCourse.setMaxStudent( Integer.parseInt(request.getParameter("maxStudent")));
                    availableCourse.setMinStudent( Integer.parseInt(request.getParameter("minStudent")));
                    availableCourse.setName(request.getParameter("courseName"));
                    availableCourse.setCode(request.getParameter("courseCode"));
                    availableCourse.setStart(simpleDateFormat.parse(request.getParameter("startDate")));
                    availableCourse.setEnd(simpleDateFormat.parse(request.getParameter("endDate")));
                    courseDAO.saveOrUpdateCourse(availableCourse);
                    request.setAttribute("responseMessage", "Course updated successfully");
                    request.setAttribute("success", true);
                    request.setAttribute("courses", courseDAO.getAllCourses());
                    request.getRequestDispatcher("WEB-INF/pages/courses.jsp").forward(request, response);
                    break;
                case "updateManager":
                    Manager availableManager = managerDAO.getManagerById(id);
                    manager = new Manager(
                            request.getParameter("firstName"),
                            request.getParameter("lastName"),
                            request.getParameter("phoneNumber"),
                            simpleDateFormat.parse(request.getParameter("dob"))
                    );
                    availableManager.setDateOfBirth(manager.getDateOfBirth());
                    availableManager.setPhoneNumber(manager.getPhoneNumber());
                    availableManager.setLastName(manager.getLastName());
                    availableManager.setFirstName(manager.getFirstName());
                    managerDAO.saveOrUpdateManager(availableManager);
                    request.setAttribute("responseMessage", "Manager updated successfully");
                    request.setAttribute("success", true);
                    request.setAttribute("managers", managerDAO.getAllManagers());
                    request.getRequestDispatcher("WEB-INF/pages/managers.jsp").forward(request, response);
                    break;
                case "updateEmployee":
                    Employee availableEmployee = employeeDAO.getEmployeeById(id);
                    availableEmployee.setFirstName( request.getParameter("firstName"));
                    availableEmployee.setLastName(request.getParameter("lastName"));
                    availableEmployee.setPhoneNumber(request.getParameter("phoneNumber"));
                    availableEmployee.setDateOfBirth(simpleDateFormat.parse(request.getParameter("dateOfBirth")));
                    employeeDAO.saveOrUpdateEmployee(availableEmployee);
                    request.setAttribute("employees", employeeDAO.getAllEmployees());
                    request.setAttribute("responseMessage", "Employee updated successfully");
                    request.getRequestDispatcher("WEB-INF/pages/employees.jsp").forward(request, response);
                    break;
                case "updateUser":
                    User availableUser = userDAO.getUserById(id);
                    availableUser.setEmail(request.getParameter("email"));
                    availableUser.setPassword(request.getParameter("password"));
                    availableUser.setFullName(request.getParameter("userfullname"));
                    availableUser.setUsername(request.getParameter("username"));
                    availableUser.setUserRole(UserRole.valueOf(request.getParameter("userRoles")));
                    userDAO.saveOrUpdateUser(availableUser);
                    request.setAttribute("users", userDAO.getAllUsers());
                    request.setAttribute("responseMessage", "User updated successfully");
                    request.getRequestDispatcher("WEB-INF/pages/mark/updateUser.jsp").forward(request, response);
                    break;
                case "updateInstructor":
                    Instructor availableInstructor = instructorDAO.getInstructorById(id);
                    availableInstructor.setFirstName(request.getParameter("firstName"));
                    availableInstructor.setLastName(request.getParameter("lastName"));
                    availableInstructor.setPhoneNumber(request.getParameter("phoneNumber"));
                    availableInstructor.setRemunerationDate(simpleDateFormat.parse(request.getParameter("renumerationTime")));
                    availableInstructor.setDateOfBirth(simpleDateFormat.parse(request.getParameter("dob")));
                    instructorDAO.saveInstructor(availableInstructor);
                    request.setAttribute("instuctors", instructorDAO.getAllInstructors());
                    request.setAttribute("responseMessage", "Instructor updated successfully");
                    request.getRequestDispatcher("WEB-INF/pages/instructors.jsp").forward(request, response);
                    break;
                default:
                    request.getRequestDispatcher("WEB-INF/pages/notfound.jsp").forward(request, response);
            }
        }catch (Exception exception){
            System.out.println("Exception met when updating the resource");
        }

    }
}
