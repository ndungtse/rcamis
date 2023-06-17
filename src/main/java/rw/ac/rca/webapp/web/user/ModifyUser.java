package rw.ac.rca.webapp.web.user;

import rw.ac.rca.webapp.dao.UserDAO;
import rw.ac.rca.webapp.dao.impl.UserDAOImpl;
import rw.ac.rca.webapp.orm.User;
import rw.ac.rca.webapp.util.UserRole;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ModifyUser", urlPatterns = {"/modify.php/*"})
public class ModifyUser extends HttpServlet {
    private final UserDAO userDAO = UserDAOImpl.getInstance();

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response){
        HttpSession httpSession = request.getSession();
        User user = new User();
        String usernameauth = request.getParameter("username");
        String passwordauth = request.getParameter("password");
        String userfullname = request.getParameter("userfullname");
        String email = request.getParameter("email");
        String id = request.getParameter("id");
        String userRole = request.getParameter("userRole");
//        set user role to user (default) if not selected (null)
        if (userRole == null) {
            userRole = "GUEST";
        }
        UserRole usrr = UserRole.valueOf(userRole);

        try {
            User existingUser = userDAO.getUserById(Integer.parseInt(id));
            existingUser.setUsername(usernameauth);
            existingUser.setPassword(passwordauth);
            existingUser.setFullName(userfullname);
            existingUser.setEmail(email);
            existingUser.setUserRole(usrr);
            userDAO.updateUser(existingUser);
            response.sendRedirect("users");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession();
        String path = request.getPathInfo();
        if(path.equals("/delete")){
            doDelete(request, response);
            try {
                response.sendRedirect("users");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return;
        } else {
            String id = request.getParameter("id");
            User user = userDAO.getUserById(Integer.parseInt(id));
            System.out.println("user found"+user);
            UserRole[] userRoles = UserRole.values();
            httpSession.setAttribute("userRoles", userRoles);
            httpSession.setAttribute("user", user);
            try {
                request.getRequestDispatcher("WEB-INF/pages/useredit.jsp").forward(
                        request, response);
            } catch (IOException | ServletException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response){
        HttpSession httpSession = request.getSession();
        String id = request.getParameter("id");
        User user = userDAO.getUserById(Integer.parseInt(id));
        if (user != null) {
            userDAO.deleteUser(user);
        } else {
            httpSession.setAttribute("error", "User not found");
        }
    }
}
