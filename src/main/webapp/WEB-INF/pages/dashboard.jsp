<%@ page import="rw.ac.rca.webapp.util.RequestInitializer" %>
<%@ page import="rw.ac.rca.webapp.dao.*" %>
<%@ page import="rw.ac.rca.webapp.dao.impl.*" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
//    StudentDAO studentDAO = StudentDAOImpl.getInstance();
//    CourseDAO courseDAO = CourseDAOImpl.getInstance();
//    EmployeeDAO employeeDAO = EmployeeDAOImpl.getInstance();
//    InstructorDAO instructorDAO = InstructorDAOImpl.getInstance();
//    ManagerDAO managerDAO = ManagerDAOImpl.getInstance();
//    ParentDAO parentDAO = ParentDAImpl.getInstance();
//    UserDAO userDAO = UserDAOImpl.getInstance();
// HttpServletRequest request1 = (HttpServletRequest) request;
 Object number = request.getAttribute("studentsNumber");
 Object coursesNumber = request.getAttribute("courses");
//    RequestInitializer requestInitializer = new RequestInitializer(request.getAttribute("students"), request.getAttribute("courses"), request.getAttribute("instructors"), request.getAttribute("parents"), request.getAttribute("managers"), request.getAttribute("managers"), request.getAttribute("users"), request.getAttribute("employees"), request.getAttribute("students"))

%>
<jsp:include page="../components/headeradmin.jsp">
    <jsp:param value="Home" name="title"/>
</jsp:include>
<div class="flex flex-col w-full gap-5">

    <h1 class="text-xl font-semibold gap-4 flex items-center">
        <i class="bx bx-image text-3xl text-violet-800"></i>
        Pictures From Rwanda Academy</h1>
    <div class="grid w-full gap-4 xl:grid-cols-4 md:grid-cols-3 sm:grid-cols-2">
        <img src="https://www.rca.ac.rw/images/Amb-Israel-Ron-Adam.JPG" class="w-full h-full object-cover rounded-md aspect-[3/2]"/>
        <img src="https://www.rca.ac.rw/images/05.jpg" class="w-full h-full object-cover rounded-md aspect-[3/2]"/>
        <img src="https://www.rca.ac.rw/images/09.jpg" class="w-full h-full object-cover rounded-md aspect-[3/2]"/>
        <img src="https://www.rca.ac.rw/images/visit-to-DMM-Hehe2.jpg" class="w-full h-full object-cover rounded-md aspect-[3/2]"/>
        <img src="images/im1.JPG" class="w-full h-full object-cover rounded-md aspect-[3/2]"/>
        <img src="images/im2.JPG" class="w-full h-full object-cover rounded-md aspect-[3/2]"/>
        <img src="images/im3.JPG" class="w-full h-full object-cover rounded-md aspect-[3/2]"/>
        <img src="images/im4.JPG" class="w-full h-full object-cover rounded-md aspect-[3/2]"/>
    </div>

    <h1 class="text-xl font-semibold gap-4 flex items-center">
        <i class="bx bx-compass  text-3xl text-violet-800"></i>
        Explore more from Rwanda Academy</h1>

    <div class="grid w-full gap-4 xl:grid-cols-6 md:grid-cols-5 sm:grid-cols-4">
        <a href="listcourse.php" class="flex flex-col gap-2 rounded-md duration-300 hover-text-white shadow-md border-[1px] hover:scale-110 hover:bg-slate-200 p-4 items-center">
            <i class="bx bx-book-open text-3xl text-violet-800"></i>
            <p>56 courses</p>
            <h1 class="text-lg font-semibold">View Courses</h1>
        </a>
        <a href="listuser.php" class="flex flex-col gap-2 rounded-md duration-300 hover-text-white shadow-md border-[1px] hover:scale-110 hover:bg-slate-200 p-4 items-center">
            <i class="bx bx-user text-3xl text-violet-800"></i>
            <p>60 users</p>
            <h1 class="text-lg font-semibold">View Users</h1>
        </a>
        <a href="students.php?page='marks'?action='list'" class="flex flex-col gap-2 rounded-md duration-300 hover-text-white shadow-md border-[1px] hover:scale-110 hover:bg-slate-200 p-4 items-center">
            <i class="bx bx-user text-3xl text-violet-800"></i>
                <p><%= number%></p>
            <h1 class="text-lg font-semibold">View Students</h1>
        </a>
        <a href="instructors.php" class="flex flex-col gap-2 rounded-md duration-300 hover-text-white shadow-md border-[1px] hover:scale-110 hover:bg-slate-200 p-4 items-center">
            <i class="bx bx-user text-3xl text-violet-800"></i>
            <p>60 instructors</p>
            <h1 class="text-lg font-semibold">View Instructors</h1>
        </a>
        <a href="employees.php" class="flex flex-col gap-2 rounded-md duration-300 hover-text-white shadow-md border-[1px] hover:scale-110 hover:bg-slate-200 p-4 items-center">
            <i class="bx bx-user text-3xl text-violet-800"></i>
            <p>32 employees</p>
            <h1 class="text-lg font-semibold">View Employees</h1>
        </a>
        <a href="managers.php" class="flex flex-col gap-2 rounded-md duration-300 hover-text-white shadow-md border-[1px] hover:scale-110 hover:bg-slate-200 p-4 items-center">
            <i class="bx bx-user text-3xl text-violet-800"></i>
            <p>${employees}</p>
            <h1 class="text-lg font-semibold">View Managers</h1>
        </a>
    </div>
</div>
<%@ include file="../components/footer.jsp" %>