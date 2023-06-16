<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"/>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <link rel="shortcut icon" href="images/rcalogo.png" type="image/x-icon"/>
  <title>Instructors List</title>
</head>
<body>
<jsp:include page="../components/headeradmin.jsp">
  <jsp:param value="marks" name="title"/>
</jsp:include>
<div class="flex flex-col w-full gap-y-4">
  <div class="flex w-full items-center justify-between">
    <h1 class="font-semibold text-xl text-center">Registered instructors</h1>
    <h1 class="font-semibold text-xl hover:bg-violet-900  text-white w-[30%] p-2 rounded-lg text-center">Registered instructors</h1>

    <div class="flex flex-row  gap-4">
      <a href="generate_instructors_report.php" class="bg-violet-800 flex gap-4 justify-between hover:bg-violet-900 text-white  font-bold py-2 px-3 rounded">
        <i class="bx text-xl font-bold bx-download"></i>  Download excel
      </a>
    <a href="create_instructor.php?page=createInstructor" class="bg-violet-800 hover:bg-violet-900 text-white gap-x-3 font-bold py-2 px-4 rounded">
      <i class="bx bx-plus"></i>  Add Instructor
    </a>
    </div>
  </div>
  <div class="w-full flex overflow-x-auto">
    <table class="min-w-[500px]">
      <thead>
      <tr>
        <th>ID</th>
        <th>FirstName</th>
        <th>LastName</th>
        <th>PhoneNumber</th>
        <th>Salary</th>
        <th>Date of Birth</th>
        <th>Remuneration time</th>
        <th>Action</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${instructors}" var="csr" varStatus="usrstatus">
        <tr>
          <td>${csr.id}</td>
          <td>${csr.firstName}</td>
          <td>${csr.lastName}</td>
          <td>${csr.phoneNumber}</td>
          <td>${csr.salary}</td>
          <td>${csr.dateOfBirth}</td>
          <td>${csr.remunerationDate}</td>
          <td class="buttons">
            <form method="get" action="updatecourse.php/${csr.id}">
              <button type="submit">Delete</button>
            </form>
            <form  method="get" action="updatecourse.phpo/${csr.id}">
              <button type="submit">Update</button>
            </form>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</div>
</div>
</div>
</div>
</body>
<%--<%@ include file="../footer.jsp" %>--%>